package com.learn.allaboutcoroutines.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.learn.allaboutcoroutines.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val catAdapter: CatAdapter by lazy { CatAdapter() }
    private val catViewModel: CatViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.VISIBLE
        setUpAdapterToRecyclerView()
        observeLiveData()
    }

    private fun setUpAdapterToRecyclerView() {
        rvCats.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = catAdapter
        }
    }

    private fun observeLiveData() {
        catViewModel.catList.observe(this, {
            catAdapter.updateData(it)
            progressBar.visibility = View.GONE

        })

        catViewModel.error.observe(this, {
            progressBar.visibility = View.GONE
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        catViewModel.loadCats()
    }
}