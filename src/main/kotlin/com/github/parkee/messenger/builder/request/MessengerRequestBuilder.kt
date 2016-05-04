package com.github.parkee.messenger.builder.request

import com.github.parkee.messenger.model.request.FacebookRequest
import com.github.parkee.messenger.model.request.NotificationType
import com.github.parkee.messenger.model.request.RequestMessage
import com.github.parkee.messenger.model.request.RequestRecipient

/**
 * Created by parkee on 4/29/16.
 */
object MessengerRequestBuilder {
    fun byRecipientId(recipientId: Long, message: RequestMessage,
                      notificationType: NotificationType = NotificationType.REGULAR): FacebookRequest {
        val recipient = RequestRecipient(id = recipientId)
        return FacebookRequest(recipient, message, notificationType)
    }

    fun byRecipientPhoneNumber(phoneNumber: String, message: RequestMessage,
                               notificationType: NotificationType = NotificationType.REGULAR): FacebookRequest {
        val recipient = RequestRecipient(phoneNumber = phoneNumber)
        return FacebookRequest(recipient, message, notificationType)
    }
}