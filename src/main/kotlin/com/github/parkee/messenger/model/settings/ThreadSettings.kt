package com.github.parkee.messenger.model.settings

import com.fasterxml.jackson.annotation.JsonProperty

data class ThreadSettings(
        @JsonProperty("setting_type") val settingType: SettingType,
        @JsonProperty("thread_state") val threadState: ThreadState,
        @JsonProperty("call_to_actions") val callToActions: List<Any>
)