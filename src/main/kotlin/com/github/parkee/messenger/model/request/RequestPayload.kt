package com.github.parkee.messenger.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RequestPayload(
        @JsonProperty("template_type") val templateType: TemplateType? = null,
        @JsonProperty("text") val text: String? = null,
        @JsonProperty("url") val url: String? = null,
        @JsonProperty("buttons") val buttons: List<Button>? = null,
        @JsonProperty("elements") val elements: List<Element>? = null,
        @JsonProperty("recipient_name") val recipientName: String? = null,
        @JsonProperty("order_number") val orderNumber: String? = null,
        @JsonProperty("currency") val currencyIsoCode: String? = null,
        @JsonProperty("payment_method") val paymentMethod: String? = null,
        @JsonProperty("order_url") val orderUrl: String? = null,
        @JsonProperty("timestamp") val timestamp: Long? = null,
        @JsonProperty("address") val orderAddress: OrderAddress? = null,
        @JsonProperty("summary") val orderSummary: OrderSummary? = null,
        @JsonProperty("adjustments") val adjustments: List<PaymentAdjustment>? = null
)