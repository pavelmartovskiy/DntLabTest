package com.pm.dntlabtest.data.net

import com.pm.dntlabtes.domain.model.Category

fun CategoryData.map()  = Category(
                id = requireNotNull(id),
                name = requireNotNull(name),
                icon = requireNotNull(icon)
        )

fun List<CategoryData>.mapCategoryDataList() = map { it.map() }

