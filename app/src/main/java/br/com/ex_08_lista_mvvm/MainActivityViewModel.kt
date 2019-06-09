package br.com.ex_08_lista_mvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var responseList = MutableLiveData<
            ArrayList<String>
            >()

    fun gerarListaNomesUseCase(quantidade: Int) {
        var nomes = ArrayList<String>()

        for (i in 1..quantidade) {
            nomes.add("Nome - $i")
        }

        responseList.value = nomes
    }
}