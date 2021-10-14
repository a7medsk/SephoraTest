package com.example.sephoratest.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.sephoratest.R
import com.example.sephoratest.data.local.Product
import com.example.sephoratest.ui.MainActivity
import com.example.sephoratest.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 *Created by haskhiri on 14/10/2021
 */
@AndroidEntryPoint
class ProductListFragment :Fragment(){

    private val viewModel: ProductViewModel by navGraphViewModels(R.id.nested_graph) {
        defaultViewModelProviderFactory
    }


    companion object {
        fun newInstance(): ProductListFragment {
            return ProductListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.item_list)

        viewModel.getProducts().observe(viewLifecycleOwner, Observer<List<Product>>{ products ->
            recyclerView.adapter = ProductListAdapter(activity as MainActivity, products.sortedBy {
                it.id }) {
                viewModel.select(it)
                findNavController().navigate(R.id.action_productListFragment_to_productDeatilFragment)
            }
        })

        return view
    }
}