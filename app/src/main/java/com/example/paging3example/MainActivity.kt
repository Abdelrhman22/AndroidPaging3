package com.example.paging3example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paging3example.databinding.ActivityMainBinding
import com.example.paging3example.paging.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter: ProductAdapter = ProductAdapter()
    private lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        binding.rvProducts.adapter = adapter


        lifecycleScope.launch {
            productViewModel.getProducts().collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

    }
}