package com.example.foodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.SplashScreenActivity
import com.example.foodapp.adapter.MenuAdapter
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.model.Data


class HomeFragment : Fragment(),MenuAdapter.IOnItemClickListener{

    lateinit var adapter: MenuAdapter
    lateinit var binding: FragmentHomeBinding
    var mActivity : SplashScreenActivity? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        mActivity = activity as SplashScreenActivity?
        setuprcv()
        return binding.root
    }


    private fun setuprcv() {
        binding.rvListCategory.layoutManager = LinearLayoutManager(context)
        adapter = MenuAdapter(createData(),this)
        adapter.list = createData()
        binding.rvListCategory.adapter = adapter
        binding.rvListCategory.setHasFixedSize(true)

    }

    private fun createData(): MutableList<Data> {
        val list = mutableListOf<Data>()
        list.add(Data(R.drawable.monan, "Main Dishes","description 1"))
        list.add(Data(R.drawable.monan, "Best Sellers","description 2"))
        list.add(Data(R.drawable.monan, "Discounted Offers","description 3"))
        list.add(Data(R.drawable.monan, "Discounted Offers","description 4"))
        return list

    }

    override fun onItemClick(data: Data) {
        mActivity?.gotoDetailMenuFragment(data)
    }


}