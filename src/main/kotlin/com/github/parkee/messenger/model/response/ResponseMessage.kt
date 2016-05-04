package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseMessage(
        @JsonProperty("mid") val mid: String,
        @JsonProperty("seq") val seq: Int,
        @JsonProperty("sticker_id") val stickerId: Long?,
        @JsonProperty("attachments") val attachments: List<ResponseAttachment>?,
        @JsonProperty("text") val text: String?
)