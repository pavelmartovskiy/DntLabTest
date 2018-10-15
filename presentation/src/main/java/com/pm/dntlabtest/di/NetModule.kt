package com.pm.dntlabtest.di

import com.pm.dntlabtest.data.net.CategoryData
import com.pm.dntlabtest.data.net.NetApi
import dagger.Module
import dagger.Provides
import io.reactivex.Single


@Module
class NetModule {

    @Provides
    @ApplicationScope
    fun provideNetApi(): NetApi = NetApiStub()
}

private class NetApiStub : NetApi {


    val categories =
            (0..50)
                    .map {
                        CategoryData(
                                id = it.toLong(),
                                name = "Category [$it]",
                                icon = "https://placehold.it/512x512&text=C$it"
                        )
                    }


    override fun getCategory() = requireNotNull(Single.just(categories))

}


