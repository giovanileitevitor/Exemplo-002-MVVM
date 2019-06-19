package br.com.ex_08_lista_mvvm

internal sealed class SampleLoginViewState {

    data class ShowError(val error: Throwable): SampleLoginViewState()

    object ShowLoading: SampleLoginViewState()
    object HideLoading: SampleLoginViewState()
    object RedirectOnSuccess: SampleLoginViewState()

}