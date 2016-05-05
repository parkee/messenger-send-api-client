package com.github.parkee.messenger.model.error

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookError(
        @JsonProperty("message") val message: String,
        @JsonProperty("type") val type: String,
        @JsonProperty("code") val code: Int,
        @JsonProperty("error_data") val errorData: String,
        @JsonProperty("fbtrace_id") val facebookTraceId: String
)