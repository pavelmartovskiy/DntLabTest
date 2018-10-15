package com.pm.dntlabtest.main

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.pm.dntlabtest.R
import com.pm.dntlabtest.core.AbsHolder
import com.pm.dntlabtest.databinding.RvMainCategoryBinding

class MainAdapter : ListAdapter<CategoryItem, CategoryHolder>(ItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int) =  CategoryHolder(parent)

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CategoryHolder(parent:ViewGroup) : AbsHolder<RvMainCategoryBinding>(
        parent,
        R.layout.rv_main_category
) {
    fun bind(item: CategoryItem) {
        dataBinding.model = item
    }
}

private class ItemCallback : DiffUtil.ItemCallback<CategoryItem>() {

    override fun areItemsTheSame(i1: CategoryItem, i2: CategoryItem) = i1.id == i2.id

    override fun areContentsTheSame(i1: CategoryItem, i2: CategoryItem) = i1 == i2

}