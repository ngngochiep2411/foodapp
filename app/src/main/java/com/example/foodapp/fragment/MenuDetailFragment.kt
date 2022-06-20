package com.example.foodapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMenuDetailBinding
import com.example.foodapp.model.Data

class MenuDetailFragment : Fragment() {

    lateinit var binding : FragmentMenuDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu_detail, container, false)

        val bundle = arguments
        val data : Data = bundle?.get("object_data_menu") as Data
        Log.d("object_data_menu",data.toString())

        binding.btnBack.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        return binding.root
    }
}