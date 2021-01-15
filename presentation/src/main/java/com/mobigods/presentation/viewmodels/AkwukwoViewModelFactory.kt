package com.mobigods.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class AkwukwoViewModelFactory @Inject constructor (
    private val vmProviders:
    @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = vmProviders[modelClass]
            ?: throw IllegalStateException("Invalid view model, view model class wasn't found..")
        return viewModel.get() as T
    }

}