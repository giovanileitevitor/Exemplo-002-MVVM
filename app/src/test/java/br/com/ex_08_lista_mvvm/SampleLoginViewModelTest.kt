package br.com.ex_08_lista_mvvm

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SampleLoginViewModelTest {

    private lateinit var viewModel: SampleLoginViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setupTest() {
        viewModel = SampleLoginViewModel()
    }


    @Test
    fun `With empty user and pass, assert that throws exception`() {
        val user = ""
        val pass = ""

        viewModel.fetchLogin(user, pass)

        assertThat(
            viewModel.sampleLoginState.value,
            IsInstanceOf(SampleLoginViewState.ShowError::class.java)
        )
    }

    @Test
    fun `With not empty user and pass, assert that get state success`() {
        val user = "anyUser"
        val pass = "12345"

        viewModel.fetchLogin(user, pass)

        assertThat(
            viewModel.sampleLoginState.value,
            IsInstanceOf(SampleLoginViewState.RedirectOnSuccess::class.java)
        )
    }
}