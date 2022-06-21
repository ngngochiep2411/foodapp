package com.example.foodapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.foodapp.R
import com.example.foodapp.SplashScreenActivity
import com.example.foodapp.ViewModel.SharedViewModel
import com.example.foodapp.databinding.FragmentProductDetail2Binding

class FragmentProductDetail : Fragment() {

    lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: FragmentProductDetail2Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail2, container, false)
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        sharedViewModel.menuItemDetailSelected.observe(requireActivity(),{
           binding.data=it
        })

        binding.add.setOnClickListener {

        }

        (activity as SplashScreenActivity).supportActionBar?.hide()
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        (activity as SplashScreenActivity).supportActionBar?.show()
    }
}