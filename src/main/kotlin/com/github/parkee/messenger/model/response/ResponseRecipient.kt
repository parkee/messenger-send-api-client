package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseRecipient(
        @JsonProperty("id") val id: Long? = null
)