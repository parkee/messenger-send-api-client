package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Element(
        @JsonProperty("title") val title: String,
        @JsonProperty("subtitle") val subtitle: String? = null,
        @JsonProperty("item_url") val itemUrl: String? = null,
        @JsonProperty("image_url") val imageUrl: String? = null,
        @JsonProperty("buttons") val buttons: List<Button>? = null,
        @JsonProperty("quantity") val quantity: Number? = null,
        @JsonProperty("price") val price: Number? = null,
        @JsonProperty("currency") val currencyIsoCode: String? = null
)