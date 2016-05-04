package com.github.parkee.messenger.model.settings

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class ThreadState(private val threadState: String) {
    NEW_THREAD("new_thread");

    @JsonCreator
    fun fromString(threadState: String?): ThreadState? {
        threadState ?: return null
        return valueOf(threadState)
    }

    @JsonValue
    override fun toString(): String {
        return threadState
    }
}