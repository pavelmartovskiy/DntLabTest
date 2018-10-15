package com.pm.dntlabtest.main

import android.databinding.BindingAdapter
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pm.dntlabtest.R

@BindingAdapter("app:layoutVisibility")
fun setPaddingLeft(view: View, visibility: LayoutVisibility) {
    view.visibility = if (when (view.id) {
                R.id.pb -> visibility == LayoutVisibility.Loading
                R.id.rvContent -> visibility == LayoutVisibility.Content
                R.id.clError -> visibility == LayoutVisibility.Error
                else -> throw IllegalArgumentException()
            }) VISIBLE else GONE
}


@BindingAdapter("app:iconUrl")
fun setIconUrl(view: ImageView, url: String) {
    Glide.with(view).load(url).into(view)
}
