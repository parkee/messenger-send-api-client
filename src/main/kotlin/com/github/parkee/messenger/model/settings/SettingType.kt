package com.github.parkee.messenger.model.settings

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class SettingType(private val settingType: String) {
    CALL_TO_ACTIONS("call_to_actions");

    @JsonCreator
    fun fromString(settingType: String?): SettingType? {
        settingType ?: return null
        return valueOf(settingType)
    }

    @JsonValue
    override fun toString(): String {
        return settingType
    }
}