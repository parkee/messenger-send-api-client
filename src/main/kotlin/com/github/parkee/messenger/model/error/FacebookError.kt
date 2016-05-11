package com.github.parkee.messenger.model.error

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookError(
        @JsonProperty("message") val message: String? = null,
        @JsonProperty("type") val type: String? = null,
        @JsonProperty("code") val code: Int? = null,
        @JsonProperty("error_data") val errorData: String? = null,
        @JsonProperty("fbtrace_id") val facebookTraceId: String? = null
)