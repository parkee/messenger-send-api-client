package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class RequestButtonType(private val type: String) {
    WEB_URL("web_url"),
    POSTBACK("postback");

    @JsonCreator
    fun fromString(type: String?): RequestButtonType? {
        type ?: return null
        return valueOf(type)
    }

    @JsonValue
    override fun toString(): String {
        return type
    }
}