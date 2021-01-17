package com.mobigods.core.utils.states

sealed class AkwukwoResource<T> (
    val state: AkwukwoState,
    val data: T? = null,
    val message: String? = null) {

    class Success<T>(data: T) : AkwukwoResource<T>(AkwukwoState.SUCCESS, data)
    class Loading<T>(data: T? = null) : AkwukwoResource<T>(AkwukwoState.LOADING, data)
    class Error<T>(message: String?, data: T? = null) : AkwukwoResource<T>(AkwukwoState.ERROR, data, message)
}
