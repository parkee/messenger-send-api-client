package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class TemplateType(private val type: String) {
    GENERIC("generic"),
    BUTTON("button"),
    RECEIPT("receipt");

    @JsonCreator
    fun fromString(type: String?): TemplateType? {
        type ?: return null
        return valueOf(type)
    }

    @JsonValue
    override fun toString(): String{
        return type
    }
}