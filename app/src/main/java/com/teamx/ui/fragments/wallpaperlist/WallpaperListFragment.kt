package com.teamx.ui.fragments.wallpaperlist

import android.R
import android.app.WallpaperManager
import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.Contacts.Settings
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamx.freelance.databinding.FragmentWallpaperListBinding
import com.teamx.ui.utils.BannerFacebook
import com.teamx.ui.utils.DialogHelperClass
import java.io.IOException


class WallpaperListFragment : Fragment(), WallpaperAdapter.CallBack,
    DialogHelperClass.Companion.successWallpaperDialog, DialogHelperClass.Companion.setWallpaperDialog {

    lateinit var fragmentListBinding: FragmentWallpaperListBinding
    var navController: NavController? = null

    lateinit var wallpaperlistAdapter: WallpaperAdapter
    lateinit var wallpaperlistArrayList: ArrayList<WallpaperListData>

    lateinit var banner : BannerFacebook

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListBinding = FragmentWallpaperListBinding.inflate(inflater, container, false);

        listAdapter()


//        banner.loadAppLovInBanner(this, bannerAd, PrefHelper.getPrefInstance(this).getFacebook_banner_history(),bannerAdApplovin,PrefHelper.getPrefInstance(this).getApplovin_banner_history() );
//        banner.loadAppLovInBanner(this, bannerAd, "YOUR_GAID_HERE",bannerAdApplovin,"YOUR_GAID_HERE" );
        banner = BannerFacebook()
        banner.loadAppLovInBanner(requireActivity(), fragmentListBinding.bannerAdApplovin, "YOUR_GAID_HERE")

        return fragmentListBinding.root;
    }

    private fun listAdapter() {
        wallpaperlistArrayList = ArrayList()

        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_1))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_2))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_3))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_4))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_6))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_5))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_7))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_8))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_9))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_10))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_11))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_12))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_13))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_14))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_15))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_16))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_17))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_18))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_19))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_20))
        wallpaperlistArrayList.add(WallpaperListData(com.teamx.freelance.R.drawable.w_21))


        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        fragmentListBinding.recyclerList.layoutManager = linearLayoutManager

        wallpaperlistAdapter = WallpaperAdapter(wallpaperlistArrayList, this)
        fragmentListBinding.recyclerList.adapter = wallpaperlistAdapter

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onItemClickFavourite(i: Int) {


        pos = i

        DialogHelperClass.setWallpaper(requireActivity(), this)

    }

    var pos : Int = 0

    override fun onExitButton() {

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onHomeScreenButton() {
        val wallpaper = (wallpaperlistAdapter as WallpaperAdapter).wallpaperArrayList[pos]
        val wallpaperManager = WallpaperManager.getInstance(activity)
        try {

            wallpaperManager.setResource(wallpaper.Img, WallpaperManager.FLAG_SYSTEM)

            DialogHelperClass.successWallpaper(requireActivity(), this)

        } catch (e: IOException) {
            Toast.makeText(activity, "Error changing wallpaper", Toast.LENGTH_SHORT).show()
        }

    }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onLockScreenButton() {
        val wallpaper = (wallpaperlistAdapter as WallpaperAdapter).wallpaperArrayList[pos]
        val wallpaperManager = WallpaperManager.getInstance(activity)
        try {

            wallpaperManager.setResource(wallpaper.Img, WallpaperManager.FLAG_LOCK)

            DialogHelperClass.successWallpaper(requireActivity(), this)

        } catch (e: IOException) {
            Toast.makeText(activity, "Error changing wallpaper", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onbothButton() {

        val wallpaper = (wallpaperlistAdapter as WallpaperAdapter).wallpaperArrayList[pos]
        val wallpaperManager = WallpaperManager.getInstance(activity)
        try {
            wallpaperManager.setResource(wallpaper.Img)

            DialogHelperClass.successWallpaper(requireActivity(), this)

        } catch (e: IOException) {
            Toast.makeText(activity, "Error changing wallpaper", Toast.LENGTH_SHORT).show()
        }

    }


}