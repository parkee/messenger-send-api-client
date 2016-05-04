package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MessageDelivery(
        @JsonProperty("mids") val mids: List<String>,
        @JsonProperty("watermark") val watermark: Long,
        @JsonProperty("seq") val seq: Int
)