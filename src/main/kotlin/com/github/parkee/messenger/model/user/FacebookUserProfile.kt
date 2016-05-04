package com.github.parkee.messenger.model.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by parkee on 4/28/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookUserProfile(
        @JsonProperty("first_name") val firstName: String? = null,
        @JsonProperty("last_name") val lastName: String? = null,
        @JsonProperty("profile_pic") val profilePicture: String? = null
)