package com.github.parkee.messenger

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.parkee.messenger.exception.FacebookException
import com.github.parkee.messenger.model.error.FacebookError
import com.github.parkee.messenger.model.request.FacebookRequest
import com.github.parkee.messenger.model.request.RequestMessage
import com.github.parkee.messenger.model.request.SendMessageResponse
import com.github.parkee.messenger.model.settings.SettingType
import com.github.parkee.messenger.model.settings.ThreadSettings
import com.github.parkee.messenger.model.settings.ThreadState
import com.github.parkee.messenger.model.user.FacebookUserProfile
import com.github.parkee.messenger.util.json.fromJsonTo
import com.github.parkee.messenger.util.json.toJsonAsBytes
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by parkee on 4/28/16.
 */
class FacebookMessengerSendApiClient(private val pageAccessToken: String) {

    private val LOG : Logger = LoggerFactory.getLogger(FacebookMessengerSendApiClient::class.java);

    init {
        jacksonObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
    }

    private val defaultHeader = mapOf("Content-Type" to "application/json")

    fun sendRequest(facebookRequest: FacebookRequest): SendMessageResponse {
        val request = "https://graph.facebook.com/v2.6/me/messages?access_token=$pageAccessToken".httpPost()
                .header(defaultHeader)
                .body(facebookRequest.toJsonAsBytes())

        LOG.debug(request.cUrlString())
        val (success, error) = request.responseString().third

        checkForErrors(success, error)
        return success!!.fromJsonTo(SendMessageResponse::class)
    }

    fun getUserProfile(userId: Long,
                       fields: List<String> = listOf("first_name", "last_name", "profile_pic")): FacebookUserProfile {
        val request = "https://graph.facebook.com/v2.6/$userId".httpGet(listOf(
                "access_token" to pageAccessToken,
                "fields" to fields.joinToString(",")))

        LOG.debug(request.cUrlString())
        val (success, error) = request.responseString().third

        checkForErrors(success, error)
        return success!!.fromJsonTo(FacebookUserProfile::class)
    }

    fun setWelcomeMessage(pageId: Long, message: RequestMessage): String {

        val threadSettings = ThreadSettings(SettingType.CALL_TO_ACTIONS, ThreadState.NEW_THREAD, listOf(mapOf("message" to message)))

        val request = "https://graph.facebook.com/v2.6/$pageId/thread_settings?access_token=$pageAccessToken"
                .httpPost()
                .header(defaultHeader)
                .body(threadSettings.toJsonAsBytes())

        LOG.debug(request.cUrlString())
        val (success, error) = request.responseString().third

        checkForErrors(success, error)
        return success.orEmpty()
    }

    private fun checkForErrors(success: String?, error: FuelError?) {
        val errorData = error?.errorData
        if (errorData != null || success == null) {
            val facebookErrorData = errorData ?: "{}".toByteArray()
            LOG.error(String(facebookErrorData))
            val tr = object : TypeReference<Map<String, FacebookError>>() {}
            val facebookError = facebookErrorData.fromJsonTo(tr)["error"] ?: throw FacebookException()
            throw FacebookException(facebookError)
        }
    }
}