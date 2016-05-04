package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.model.request.*

class ReceiptTemplateStep internal constructor() {

    private val elements = mutableListOf<Element>()

    fun addElement(title: String, subtitle: String?, quantity: Number?, price: Number?, currencyIsoCode: String?,
                   imageUrl: String?): ReceiptTemplateStep {

        val element = Element(title = title,
                subtitle = subtitle,
                quantity = quantity,
                price = price,
                currencyIsoCode = currencyIsoCode,
                imageUrl = imageUrl)

        elements.add(element)
        return this
    }

    fun with(recipientName: String, orderNumber: String,
             currencyIsoCode: String, paymentMethod: String,
             orderSummary: OrderSummary, timestamp: Long?, orderUrl: String?,
             orderAddress: OrderAddress?, adjustments: List<PaymentAdjustment>?): FinalStep {

        val payload = RequestPayload(templateType = TemplateType.RECEIPT,
                recipientName = recipientName,
                orderNumber = orderNumber,
                currencyIsoCode = currencyIsoCode,
                paymentMethod = paymentMethod,
                elements = elements,
                orderSummary = orderSummary,
                timestamp = timestamp,
                orderUrl = orderUrl,
                orderAddress = orderAddress,
                adjustments = adjustments
        )
        val attachmentType = RequestAttachmentType.TEMPLATE
        val attachment = RequestAttachment(attachmentType, payload)
        val message = RequestMessage(attachment)
        return FinalStep(message)
    }
}