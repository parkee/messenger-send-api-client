package com.github.parkee.messenger.builder.message

import com.github.parkee.messenger.builder.message.quickreply.QuickReplyTextOrAttachmentStep
import com.github.parkee.messenger.model.request.RequestMessage
import com.github.parkee.messenger.model.request.quickreply.QuickReply
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by parkee on 4/27/16.
 */
object RequestMessageBuilder {

    private val LOG: Logger = LoggerFactory.getLogger(RequestMessageBuilder::class.java)

    fun withTextMessage(text: String): FinalStep {
        return FinalStep(RequestMessage(text = text))
    }

    fun withImageAttachment(): StructuredMessageImageStep {
        return StructuredMessageImageStep()
    }

    fun withStructuredMessageTemplateAttachment(): StructuredMessageTemplateStep {
        return StructuredMessageTemplateStep()
    }

    fun withQuickReply(quickReplies: List<QuickReply>? = null): QuickReplyTextOrAttachmentStep {
        if (quickReplies != null && quickReplies.size > 10) {
            LOG.info("quick_replies is limited to 10, but {} found", quickReplies.size)
            throw IllegalArgumentException("quick_replies is limited to 10, but ${quickReplies.size} found")
        }
        return QuickReplyTextOrAttachmentStep(quickReplies)
    }
}

