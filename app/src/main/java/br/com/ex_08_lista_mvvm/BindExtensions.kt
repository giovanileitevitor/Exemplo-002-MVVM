package br.com.ex_08_lista_mvvm


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

inline fun <reified T: ViewModel> FragmentActivity.bindViewModel() = lazy {
    ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T: ViewModel> Fragment.bindViewModel() = lazy {
    ViewModelProviders.of(this).get(T::class.java)
}