package com.pm.dntlabtest.main

import com.pm.dntlabtes.domain.model.Category

fun Category.toItem() = CategoryItem(
        id = id,
        name = name,
        icon = icon
)

fun List<Category>.toCategoryItemList() = map { it.toItem() }
