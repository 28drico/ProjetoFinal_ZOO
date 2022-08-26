package br.com.zup.projetofinalindividual.viewstate

data class ViewState<out T> (val status:Status,val data:T?,val message:String?){

    companion object{
        fun <T> success(data:T?):ViewState<T> = ViewState(Status.SUCCESS,data,null)
        fun <T> error(data:T?,message: String?):ViewState<T> = ViewState(Status.ERROR,data,message)
        fun <T> loading(data:T?):ViewState<T> = ViewState(Status.LOADING,data,null)
        fun <T> empty(data: T?): ViewState<T> = ViewState(Status.EMPTY,data,"Empty")
    }
//     class Success<T>(val data: T) : ViewState<T>()
//     class Error(val throwable: Throwable) : ViewState<Nothing>()
//     class EmptyList<T>(val data: T) : ViewState<T>()
}