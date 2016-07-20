package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by parkee on 4/29/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendMessageResponse(
        @JsonProperty("recipient_id") val recipientId: String,
        @JsonProperty("message_id") val messageId: String? = null
)