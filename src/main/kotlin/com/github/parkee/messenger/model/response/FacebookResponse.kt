package com.github.parkee.messenger.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookResponse(
        @JsonProperty("entry") val entry: List<FacebookResponseEntry>,
        @JsonProperty("object") val obj: String
)