package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.builder.button.ButtonBuilder
import com.github.parkee.messenger.model.request.Button
import com.github.parkee.messenger.model.request.Element

class GenericTemplateElementButtonsStep(private val title: String,
                                        private val itemUrl: String?,
                                        private val imageUrl: String?,
                                        private val subtitle: String?,
                                        private val genericTemplateStep: GenericTemplateStep) {

    internal val buttons = mutableListOf<Button>()

    fun addPostbackButton(title: String, payload: Any): GenericTemplateElementButtonsStep {
        val button = ButtonBuilder.postbackButton().build(title, payload)
        buttons.add(button)
        return this
    }

    fun addWebUrlButton(title: String, url: String): GenericTemplateElementButtonsStep {
        val button = ButtonBuilder.webUrlButton().build(title, url)
        buttons.add(button)
        return this
    }

    fun finishAddingButtons(): GenericTemplateStep {

        val element = Element(
                title = title,
                subtitle = subtitle,
                itemUrl = itemUrl,
                imageUrl = imageUrl,
                buttons = if (buttons.isNotEmpty()) buttons else null
        )
        genericTemplateStep.elements.add(element)
        return genericTemplateStep
    }
}