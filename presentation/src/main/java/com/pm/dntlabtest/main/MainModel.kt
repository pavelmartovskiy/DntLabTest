package com.pm.dntlabtest.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.pm.dntlabtes.domain.usecase.GetCategoryUseCase
import com.pm.dntlabtest.BR


class MainModel(
        private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel(), Observable {

    @Transient
    private val callbacks = PropertyChangeRegistry()

    val items = MutableLiveData<List<CategoryItem>>()

    var refreshing: Boolean = false
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.refreshing)
        }

    var layoutsVisibility: LayoutVisibility = LayoutVisibility.Loading
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.layoutsVisibility)
        }

    fun loadCategories() {
        getCategoryUseCase.execute(
                Unit,
                {
                    refreshing = false
                    layoutsVisibility = LayoutVisibility.Content
                    items.value = it.toCategoryItemList()
                },
                {
                    refreshing = false
                    layoutsVisibility = LayoutVisibility.Error
                })
    }


    fun refreshCategories() {
        refreshing = true
        loadCategories()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    private fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }


}

enum class LayoutVisibility {
    Loading, Content, Error
}