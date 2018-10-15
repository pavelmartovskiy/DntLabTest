package com.pm.dntlabtest.di

import com.pm.dntlabtes.domain.repository.CategoryRepository
import com.pm.dntlabtest.data.net.NetApi
import com.pm.dntlabtest.data.repository.NetCategoryRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @ApplicationScope
    fun provideCategoryRepository(netApi: NetApi):CategoryRepository =
            NetCategoryRepository(netApi)

}