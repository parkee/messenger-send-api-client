package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookResponseEntry(
        @JsonProperty("id") val id: Long,
        @JsonProperty("time") val time: Long,
        @JsonProperty("messaging") val messaging: List<Messaging>
)