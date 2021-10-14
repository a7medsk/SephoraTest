package com.example.sephoratest.ui.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.sephoratest.R
import com.example.sephoratest.BR
import com.example.sephoratest.data.local.Product
import com.example.sephoratest.ui.MainActivity


/**
 *Created by haskhiri on 14/10/2021
 */


class ProductListAdapter(private val parentActivity: MainActivity, private val values: List<Product>,
                         private val itemClickListener: (Product) -> Unit) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val fruit = v.tag as Product
            itemClickListener(fruit)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater,
            R.layout.product_list_content,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = values[position]
        holder.bind(fruit)

        with(holder.itemView) {
            tag = fruit
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product?) {
            binding.setVariable(BR.product, product)
            binding.executePendingBindings()
        }
    }

}