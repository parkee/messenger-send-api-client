package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.builder.button.ButtonBuilder
import com.github.parkee.messenger.model.request.*

class GenericTemplateLastElementButtonsStep internal constructor(private val title: String,
                                                                 private val itemUrl: String?,
                                                                 private val imageUrl: String?,
                                                                 private val subtitle: String?,
                                                                 private val genericTemplateStep: GenericTemplateStep) {

    internal val buttons = mutableListOf<Button>()

    fun addPostbackButton(title: String, payload: Any): GenericTemplateLastElementButtonsStep {
        val button = ButtonBuilder.postbackButton().build(title, payload)
        buttons.add(button)
        return this
    }

    fun addWebUrlButton(title: String, url: String): GenericTemplateLastElementButtonsStep {
        val button = ButtonBuilder.webUrlButton().build(title, url)
        buttons.add(button)
        return this
    }

    fun finishAddingButtons(): FinalStep {
        val element = Element(
                title = title,
                subtitle = subtitle,
                itemUrl = itemUrl,
                imageUrl = imageUrl,
                buttons = if (buttons.isNotEmpty()) buttons else null
        )
        genericTemplateStep.elements.add(element)
        val payload = RequestPayload(templateType = TemplateType.GENERIC, elements = genericTemplateStep.elements)
        val attachmentType = RequestAttachmentType.TEMPLATE
        val attachment = RequestAttachment(attachmentType, payload)
        val message = RequestMessage(attachment)
        return FinalStep(message)
    }
}