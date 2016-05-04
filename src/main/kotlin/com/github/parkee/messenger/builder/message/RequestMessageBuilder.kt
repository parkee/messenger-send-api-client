package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.model.request.RequestMessage

/**
 * Created by parkee on 4/27/16.
 */
object RequestMessageBuilder {

    fun withTextMessage(text: String): FinalStep {
        return FinalStep(RequestMessage(text = text))
    }

    fun withImageAttachment(): StructuredMessageImageStep {
        return StructuredMessageImageStep()
    }

    fun withStructuredMessageTemplateAttachment(): StructuredMessageTemplateStep {
        return StructuredMessageTemplateStep()
    }
}