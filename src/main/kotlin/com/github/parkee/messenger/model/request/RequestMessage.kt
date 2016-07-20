package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.parkee.messenger.model.request.quickreply.QuickReply

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RequestMessage(
        @JsonProperty("attachment") val attachment: RequestAttachment? = null,
        @JsonProperty("text") val text: String? = null,
        @JsonProperty("quick_replies") val quickReplies: List<QuickReply>? = null
)