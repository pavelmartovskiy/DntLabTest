package com.pm.dntlabtest.data.net

import io.reactivex.Single

interface NetApi {
    fun getCategory() : Single<List<CategoryData>>
}