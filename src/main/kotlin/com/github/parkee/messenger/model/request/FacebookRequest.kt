package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.parkee.messenger.model.request.senderaction.SenderAction

/**
 * Created by parkee on 4/27/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class FacebookRequest(
        @JsonProperty("recipient") val recipient: RequestRecipient,
        @JsonProperty("message") val message: RequestMessage? = null,
        @JsonProperty("notification_type") val notificationType: NotificationType?,
        @JsonProperty("sender_action") val senderAction: SenderAction? = null
)

