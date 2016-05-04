package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseAttachment(
        @JsonProperty("title") val title: String,
        @JsonProperty("url") val url: String,
        @JsonProperty("type") val type: String, // image, audio, file, fallback
        @JsonProperty("payload") val payload: ResponsePayload?
)