package com.pm.dntlabtest.app

import android.app.Application
import com.pm.dntlabtest.di.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            NetModule::class,
            RepositoryModule::class,
            ActivitiesBindingModule::class,
            SchedulerModule::class,
            UseCaseModule::class,
            AppModule::class])
interface AppComponent : AndroidInjector<DntLabTestApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}