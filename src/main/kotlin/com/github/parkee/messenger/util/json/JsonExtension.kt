package com.github.parkee.messenger.util.json

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.reflect.KClass

/**
* Created by parkee on 4/22/16.
*/
internal fun Any.toJsonAsString(): String {
    return jacksonObjectMapper().writeValueAsString(this)
}

internal fun Any.toJsonAsBytes(): ByteArray {
    return jacksonObjectMapper().writeValueAsBytes(this)
}

internal fun <T> String.fromJsonTo(clazz: Class<T>): T {
    return jacksonObjectMapper().readValue(this, clazz)
}

internal fun <T : Any> String.fromJsonTo(clazz: KClass<T>): T {
    return jacksonObjectMapper().readValue(this, clazz.java)
}

internal fun <T : Any> ByteArray.fromJsonTo(clazz: KClass<T>): T {
    return jacksonObjectMapper().readValue(this, clazz.java)
}

internal fun <T> String.fromJsonTo(typeReference: TypeReference<T>): T {
    return jacksonObjectMapper().readValue(this, typeReference)
}

internal fun <T> ByteArray.fromJsonTo(typeReference: TypeReference<T>): T {
    return jacksonObjectMapper().readValue(this, typeReference)
}