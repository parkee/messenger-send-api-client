package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.model.request.RequestMessage

class FinalStep internal constructor(private val message: RequestMessage) {

    fun buildRequestMessage(): RequestMessage {
        return message
    }

}