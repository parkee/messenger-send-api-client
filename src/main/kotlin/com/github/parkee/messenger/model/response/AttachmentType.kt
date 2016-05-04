package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class AttachmentType(private val type: String) {
    IMAGE("image"),
    AUDIO("audio"),
    FILE("file"),
    FALLBACK("fallback");

    @JsonCreator
    fun fromString(type: String?): AttachmentType? {
        type ?: return null
        return AttachmentType.valueOf(type)
    }

    @JsonValue
    override fun toString(): String{
        return "AttachmentType(type='$type')"
    }


}