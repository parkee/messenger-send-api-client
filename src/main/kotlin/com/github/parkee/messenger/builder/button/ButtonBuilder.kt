package com.github.parkee.messenger.builder.button

import com.github.parkee.messenger.model.request.Button
import com.github.parkee.messenger.model.request.RequestButtonType

object ButtonBuilder {
    fun webUrlButton(): WebUrlButton {
        return WebUrlButton()
    }

    fun postbackButton(): PostbackButton {
        return PostbackButton()
    }

    class WebUrlButton {
        fun build(title: String, url: String): Button {
            return Button(type = RequestButtonType.WEB_URL, title = title, url = url)
        }
    }

    class PostbackButton {
        fun build(title: String, payload: Any): Button {
            return Button(type = RequestButtonType.POSTBACK, title = title, payload = payload)
        }
    }

}