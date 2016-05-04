package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderAddress(
        @JsonProperty("street_1") val street1: String,
        @JsonProperty("street_2") val street2: String? = null,
        @JsonProperty("city") val city: String,
        @JsonProperty("postal_code") val postalCode: String,
        @JsonProperty("state") val stateCode: String,
        @JsonProperty("country") val countryIsoCode: String

)