package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.model.request.RequestAttachment
import com.github.parkee.messenger.model.request.RequestAttachmentType
import com.github.parkee.messenger.model.request.RequestMessage
import com.github.parkee.messenger.model.request.RequestPayload

class StructuredMessageImageStep internal constructor() {

    fun withImageUrl(url: String): FinalStep {
        val payload = RequestPayload(url = url)
        val attachmentType = RequestAttachmentType.IMAGE
        val attachment = RequestAttachment(type = attachmentType, payload = payload)
        val message = RequestMessage(attachment = attachment)
        return FinalStep(message)
    }
}