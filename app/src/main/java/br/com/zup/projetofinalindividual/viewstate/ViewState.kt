package br.com.zup.projetofinalindividual.viewstate

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val throwable: Throwable) : ViewState<Nothing>()
    data class EmptyList<T>(val data: T) : ViewState<T>()
}
//     class Success<T>(val data: T) : ViewState<T>()
//     class Error(val throwable: Throwable) : ViewState<Nothing>()
//     class EmptyList<T>(val data: T) : ViewState<T>()
