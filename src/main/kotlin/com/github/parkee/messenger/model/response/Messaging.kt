package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Messaging(
        @JsonProperty("sender") val sender: Sender,
        @JsonProperty("recipient") val recipient: ResponseRecipient,
        @JsonProperty("timestamp") val timestamp: Long,
        @JsonProperty("postback") val postback: Postback?,
        @JsonProperty("message") val message: ResponseMessage?,
        @JsonProperty("delivery") val delivery: MessageDelivery?
)