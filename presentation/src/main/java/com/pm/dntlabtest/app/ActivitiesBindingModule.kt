package com.pm.dntlabtest.app

import com.pm.dntlabtest.di.ActivityScope
import com.pm.dntlabtest.main.MainActivity
import com.pm.dntlabtest.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesBindingModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = [MainModule::class])
  fun contributeMainActivity(): MainActivity
}