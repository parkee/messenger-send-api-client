package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.model.request.Element

class GenericTemplateStep internal constructor() {

    internal val elements = mutableListOf<Element>()

    fun addElement(title: String, itemUrl: String?, imageUrl: String?, subtitle: String?): GenericTemplateElementButtonsStep {
        return GenericTemplateElementButtonsStep(title, itemUrl, imageUrl, subtitle, this)
    }

    fun addLastElement(title: String, itemUrl: String?, imageUrl: String?, subtitle: String?): GenericTemplateLastElementButtonsStep {
        return GenericTemplateLastElementButtonsStep(title, itemUrl, imageUrl, subtitle, this)
    }
}