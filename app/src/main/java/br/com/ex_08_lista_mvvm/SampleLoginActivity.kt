package br.com.ex_08_lista_mvvm

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SampleLoginActivity : AppCompatActivity() {

    private val viewModel: SampleLoginViewModel by bindViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.sampleLoginState.observe(this, Observer {
            when (it) {
                is SampleLoginViewState.RedirectOnSuccess -> {
                    //TODO: redirect on success
                }
                is SampleLoginViewState.ShowLoading -> {
                    //TODO: show loading
                }
                is SampleLoginViewState.HideLoading -> {
                    //TODO: hide loading
                }
                is SampleLoginViewState.ShowError -> {
                    //TODO: show error
                }
            }
        })
    }

    private fun doLogin() {
        viewModel.fetchLogin("any@any.com", "Us3r")
    }
}