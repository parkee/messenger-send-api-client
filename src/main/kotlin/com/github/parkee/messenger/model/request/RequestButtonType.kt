package com.github.parkee.messenger.model.request

enum class RequestButtonType(private val type: String) {
    WEB_URL("web_url"),
    POSTBACK("postback");

    fun fromString(type: String?): RequestButtonType? {
        type ?: return null
        return valueOf(type)
    }

    override fun toString(): String {
        return type
    }
}