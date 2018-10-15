package com.pm.dntlabtest.main

import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pm.dntlabtest.R
import com.pm.dntlabtest.databinding.AcMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.ac_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var model: MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataBinding = setContentView<AcMainBinding>(this, R.layout.ac_main)
        rvContent.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvContent.adapter = adapter
        dataBinding.model = model
        model.loadCategories()

    }
}
