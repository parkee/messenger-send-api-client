package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderSummary(
        @JsonProperty("subtotal") val subtotal: Number? = null,
        @JsonProperty("shipping_cost") val shippingCost: Number? = null,
        @JsonProperty("total_tax") val totalTax: Number? = null,
        @JsonProperty("total_cost") val totalCost: Number
)