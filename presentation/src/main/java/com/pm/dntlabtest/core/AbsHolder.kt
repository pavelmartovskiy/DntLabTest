package com.pm.dntlabtest.core

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.pm.dntlabtest.core.extension.inflate

abstract class AbsHolder<T : ViewDataBinding>(parent: ViewGroup, @LayoutRes id: Int) :
        RecyclerView.ViewHolder(parent.inflate(id)) {
    val dataBinding : T = requireNotNull(DataBindingUtil.bind<T>(itemView))
}