package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.parkee.messenger.model.request.quickreply.QuickReply

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseMessage(
        @JsonProperty("mid") val mid: String,
        @JsonProperty("seq") val seq: Int,
        @JsonProperty("sticker_id") val stickerId: Long? = null,
        @JsonProperty("attachments") val attachments: List<ResponseAttachment>? = null,
        @JsonProperty("text") val text: String? = null,
        @JsonProperty("quick_reply") val quickReply: QuickReply? = null
)