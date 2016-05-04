package com.github.parkee.messenger.exception

import com.github.parkee.messenger.model.error.FacebookError

/**
 * Created by parkee on 4/29/16.
 */
class FacebookException : RuntimeException {

    var error: FacebookError? = null
        private set

    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)

    constructor(facebookError: FacebookError) : super(facebookError.message) {
        error = facebookError
    }
}