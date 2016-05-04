package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.builder.button.ButtonBuilder
import com.github.parkee.messenger.model.request.*

class ButtonTemplateStep internal constructor() {

    internal val buttons = mutableListOf<Button>()

    fun addPostbackButton(title: String, payload: Any): ButtonTemplateStep {
        val button = ButtonBuilder.postbackButton().build(title, payload)
        buttons.add(button)
        return this
    }

    fun addWebUrlButton(title: String, url: String): ButtonTemplateStep {
        val button = ButtonBuilder.webUrlButton().build(title, url)
        buttons.add(button)
        return this
    }

    fun withText(text: String? = null): FinalStep {
        val payload = RequestPayload(templateType = TemplateType.BUTTON, text = text, buttons = buttons)
        val attachmentType = RequestAttachmentType.TEMPLATE
        val attachment = RequestAttachment(attachmentType, payload)
        val message = RequestMessage(attachment)
        return FinalStep(message)
    }
}