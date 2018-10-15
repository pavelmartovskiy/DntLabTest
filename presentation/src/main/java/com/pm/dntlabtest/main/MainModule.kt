package com.pm.dntlabtest.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.pm.dntlabtes.domain.usecase.GetCategoryUseCase
import com.pm.dntlabtest.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun provideAdapter(
            activity: MainActivity,
            model: MainModel
    ) = MainAdapter()
            .apply { model.items.observe(activity, Observer { this.submitList(it) }) }

    @Provides
    @ActivityScope
    fun provideModel(
            activity: MainActivity,
            factory: ViewModelFactory
    ) = ViewModelProviders.of(activity,factory).get(MainModel::class.java)


    @Provides
    @ActivityScope
    fun provideModelFactory(
            getCategoryUseCase: GetCategoryUseCase
    ) = ViewModelFactory(getCategoryUseCase)
}