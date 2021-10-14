package com.example.sephoratest.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.sephoratest.R
import com.example.sephoratest.databinding.FragmentProductDetailBinding
import com.example.sephoratest.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 *Created by haskhiri on 14/10/2021
 */
@AndroidEntryPoint
class ProductDeatilFragment : Fragment(){

    private val viewModel: ProductViewModel by navGraphViewModels(R.id.nested_graph) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentProductDetailBinding  = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_detail,
            container,
            false)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        // Change the Activity toolbar title. Need to manage this with nav_graph component.
        //activity?.findViewById<Toolbar>(R.id.toolbar)?.title = item?.name

        return binding.root
    }

}