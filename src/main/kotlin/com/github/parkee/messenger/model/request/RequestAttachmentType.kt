package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class RequestAttachmentType(private val type: String) {
    IMAGE("image"),
    TEMPLATE("template");

    @JsonCreator
    fun fromString(type: String?): RequestAttachmentType? {
        type ?: return null
        return valueOf(type)
    }

    @JsonValue
    override fun toString(): String{
        return type
    }
}