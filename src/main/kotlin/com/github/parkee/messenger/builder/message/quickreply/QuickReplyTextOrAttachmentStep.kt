package com.github.parkee.messenger.builder.message.quickreply

import com.github.parkee.messenger.builder.message.FinalStep
import com.github.parkee.messenger.model.request.RequestAttachment
import com.github.parkee.messenger.model.request.RequestMessage
import com.github.parkee.messenger.model.request.quickreply.QuickReply

class QuickReplyTextOrAttachmentStep internal constructor(private val quickReplies: List<QuickReply>?){
    fun withText(text: String): FinalStep {
        return FinalStep(RequestMessage(text = text, quickReplies = quickReplies))
    }

    fun withAttachment(attachment: RequestAttachment): FinalStep {
        return FinalStep(RequestMessage(attachment = attachment, quickReplies = quickReplies))
    }
}