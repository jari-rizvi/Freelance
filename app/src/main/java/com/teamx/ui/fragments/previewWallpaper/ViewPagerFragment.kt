package com.teamx.ui.fragments.previewWallpaper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.viewpager2.widget.ViewPager2
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentViewPagerBinding
import com.teamx.ui.fragments.wallpaperlist.WallpaperListFragment


class ViewPagerFragment : Fragment(),  ClickOnViewPagerCallBack {
    lateinit var fragmentViewPagerBinding: FragmentViewPagerBinding



    lateinit var featureProductAdapter: ViewPagerAdapter
    lateinit var featureProductArrayList: ArrayList<Fragment>

    private lateinit var options: NavOptions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        initializeFeatureProducts()

    }


    private fun initializeFeatureProducts() {

        featureProductArrayList = ArrayList()

        featureProductArrayList.add(PreviewWallpaperFragment())
        featureProductArrayList.add(WallpaperListFragment())
//        featureProductArrayList.add(
//            OrderCompleteFragment(
//                this
//            )


        featureProductAdapter =
            ViewPagerAdapter(
                requireActivity().supportFragmentManager,
                requireActivity().lifecycle,
                featureProductArrayList
            )




        fragmentViewPagerBinding.viewPager.adapter = featureProductAdapter
        fragmentViewPagerBinding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        /* fragmentViewPagerBinding.viewPager.setOnTouchListener { _, _ ->
             true
         }*/
        fragmentViewPagerBinding.viewPager.isUserInputEnabled = false


    }

    override fun onClickPage(position: Int) {

        when (position) {
            0 -> {
                fragmentViewPagerBinding.viewPager.setCurrentItem(1, false)
            }
            1 -> {
                fragmentViewPagerBinding.viewPager.setCurrentItem(2, false)
            }
            2 -> {
                fragmentViewPagerBinding.viewPager.setCurrentItem(3, false)
            }

        }


    }

}

interface ClickOnViewPagerCallBack {
    fun onClickPage(position: Int)
}


