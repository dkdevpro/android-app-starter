package dev.dineshktech.app.starter.core.result

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Failure(val exception: Throwable? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}
