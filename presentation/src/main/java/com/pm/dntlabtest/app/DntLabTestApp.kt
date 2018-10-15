package com.pm.dntlabtest.app

import dagger.android.support.DaggerApplication

class DntLabTestApp : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
    .application(this)
    .build()
}