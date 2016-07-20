package com.github.parkee.messenger.builder.request

import com.github.parkee.messenger.model.request.*

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

    fun byRecipientId(recipientId: Long, senderAction: SenderAction,
                      notificationType: NotificationType = NotificationType.REGULAR): FacebookRequest {
        val recipient = RequestRecipient(id = recipientId)
        return FacebookRequest(recipient, senderAction = senderAction, notificationType = notificationType)
    }

    fun byRecipientPhoneNumber(phoneNumber: String, senderAction: SenderAction,
                               notificationType: NotificationType = NotificationType.REGULAR): FacebookRequest {
        val recipient = RequestRecipient(phoneNumber = phoneNumber)
        return FacebookRequest(recipient, senderAction = senderAction, notificationType = notificationType)
    }
}