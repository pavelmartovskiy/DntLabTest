package com.pm.dntlabtest.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pm.dntlabtes.domain.usecase.GetCategoryUseCase

class ViewModelFactory(
        private val getCategoryUseCase: GetCategoryUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainModel(getCategoryUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}