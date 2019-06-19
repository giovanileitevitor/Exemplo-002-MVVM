package br.com.ex_08_lista_mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.lang.IllegalArgumentException

internal class SampleLoginViewModel : ViewModel() {

    private val _sampleLoginState = MutableLiveData<SampleLoginViewState>()

    val sampleLoginState: LiveData<SampleLoginViewState>
        get() = _sampleLoginState

    fun fetchLogin(
        user: String,
        pass: String
    ) {
        _sampleLoginState.value = when {
            user.isEmpty() || pass.isEmpty() -> {
                SampleLoginViewState.ShowError(IllegalArgumentException("Invalid login!"))
            }
            else -> SampleLoginViewState.RedirectOnSuccess
        }
    }

    override fun onCleared() {
        super.onCleared()
        //TODO: kill threads or disposables
    }
}