package com.github.parkee.messenger.model.request.senderaction

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.github.parkee.messenger.model.request.RequestAttachmentType

enum class SenderAction(private val actionName: String) {
    MARK_SEEN("mark_seen"),
    TYPING_ON("typing_on"),
    TYPING_OFF("typing_off");

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