package com.github.parkee.messenger.model.request.quickreply

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.parkee.messenger.builder.message.quickreply.ContentType

/**
 * Created by parkee on 7/20/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QuickReply(
        @JsonProperty("content_type") val contentType: ContentType? = ContentType.TEXT,
        @JsonProperty("title") val title: String? = null,
        @JsonProperty("payload", required = true) val payload: Any
)
