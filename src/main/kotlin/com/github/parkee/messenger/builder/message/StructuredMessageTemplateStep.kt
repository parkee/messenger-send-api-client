package com.github.parkee.messenger.builder.message

class StructuredMessageTemplateStep internal constructor() {

    fun withGenericTemplate(): GenericTemplateStep {
        return GenericTemplateStep()
    }

    fun withButtonTemplate(): ButtonTemplateStep {
        return ButtonTemplateStep()
    }

    fun withReceiptTemplate(): ReceiptTemplateStep {
        return ReceiptTemplateStep()
    }
}