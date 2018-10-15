package com.pm.dntlabtes.domain.repository

import com.pm.dntlabtes.domain.model.Category
import io.reactivex.Single

interface CategoryRepository : Repository {
    fun get() : Single<List<Category>>
}