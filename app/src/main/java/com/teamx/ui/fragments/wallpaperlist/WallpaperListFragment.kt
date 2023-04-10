package com.teamx.ui.fragments.wallpaperlist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentTempBinding
import com.teamx.freelance.databinding.FragmentWallpaperListBinding

class WallpaperListFragment : Fragment(), WallpaperAdapter.CallBack {

    lateinit var fragmentListBinding: FragmentWallpaperListBinding

    lateinit var wallpaperlistAdapter: WallpaperAdapter
    lateinit var wallpaperlistArrayList: ArrayList<WallpaperListData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListBinding = FragmentWallpaperListBinding.inflate(inflater,container,false);

        listAdapter()

        return fragmentListBinding.root;
    }

    private fun listAdapter() {
        wallpaperlistArrayList = ArrayList()
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_1))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_2))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_3))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_4))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_6))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_5))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_7))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_8))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_9))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_10))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_11))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_12))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_13))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_14))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_15))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_16))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_17))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_18))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_19))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_20))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.w_21))


        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        fragmentListBinding.recyclerList.layoutManager = linearLayoutManager

        wallpaperlistAdapter = WallpaperAdapter(wallpaperlistArrayList, this)
        fragmentListBinding.recyclerList.adapter = wallpaperlistAdapter

    }

    override fun onItemClickFavourite(i: Int) {


    }

}