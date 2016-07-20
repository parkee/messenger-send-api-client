package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.*

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

enum class SenderAction(private val actionName: String) {
    MARK_SEEN("mark_seen"),
    TYPING_ON("mark_seen"),
    TYPING_OFF("mark_seen");

    @JsonCreator
    fun fromString(actionName: String?): RequestAttachmentType? {
        actionName ?: return null
        return RequestAttachmentType.valueOf(actionName)
    }

    @JsonValue
    override fun toString(): String{
        return actionName
    }
}
