package com.example.paging3example.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3example.databinding.ProductItemBinding
import com.example.paging3example.models.Product

class ProductAdapter : PagingDataAdapter<Product, ProductAdapter.ProductViewHolder>(DIFF) {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItem(getItem(position) , position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ProductItemBinding =
            ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    class ProductViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(product: Product? , position : Int) {
            product?.let {
                binding.productName.text = product.title
                binding.productPrice.text = "Price is ${product.price} $"
                var num = position
                binding.number.text = "${++num}"
            }
        }
    }

    companion object {

        val DIFF = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product) =
                oldItem.Id == newItem.Id

            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        }

    }

}