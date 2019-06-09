package br.com.ex_08_lista_mvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.telainicial.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telainicial)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@MainActivity

        viewModel = ViewModelProviders
            .of(this)
            .get(MainActivityViewModel::class.java)

        viewModel.responseList.observe(this, Observer { nomes ->

            lv_nomes.adapter = ArrayAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                nomes
            )
        })

        viewModel.gerarListaNomesUseCase(100)
    }

    private fun initActions() {

    }
}
