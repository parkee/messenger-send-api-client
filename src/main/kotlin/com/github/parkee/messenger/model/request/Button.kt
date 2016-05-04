package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Button(
        @JsonProperty("type") val type: RequestButtonType,
        @JsonProperty("title") val title: String,
        @JsonProperty("url") val url: String? = null,
        @JsonProperty("payload") val payload: Any? = null
)