package com.pm.dntlabtest.data.repository

import com.pm.dntlabtes.domain.model.Category
import com.pm.dntlabtes.domain.repository.CategoryRepository
import com.pm.dntlabtest.data.net.NetApi
import com.pm.dntlabtest.data.net.mapCategoryDataList
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class NetCategoryRepository(api: NetApi) : AbsNetRepository(api), CategoryRepository {
    override fun get(): Single<List<Category>> = api
            .getCategory()
            .delay(5, TimeUnit.SECONDS)
            .map { it.mapCategoryDataList() }
}