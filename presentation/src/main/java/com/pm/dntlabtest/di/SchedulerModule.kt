package com.pm.dntlabtest.di

import com.pm.dntlabtest.core.NamedConstants.IO
import com.pm.dntlabtest.core.NamedConstants.UI
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class SchedulerModule {

    @Provides
    @ApplicationScope
    @Named(IO)
    fun provideIoScheduler() = Schedulers.io()

    @Provides
    @ApplicationScope
    @Named(UI)
    fun provideUiScheduler() = AndroidSchedulers.mainThread()

}