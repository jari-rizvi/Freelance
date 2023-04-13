package com.teamx.ui.fragments.wallpaperlist

import android.R
import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamx.freelance.databinding.FragmentWallpaperListBinding
import com.teamx.ui.utils.BannerFacebook
import com.teamx.ui.utils.DialogHelperClass
import java.io.IOException


class WallpaperListFragment : Fragment(), WallpaperAdapter.CallBack,
    DialogHelperClass.Companion.successWallpaperDialog {

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


//        val bundle = Bundle()
//        bundle.putInt(
//            "imageId", i
//        ).toString()
//        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//        navController?.navigate(R.id.viewPagerFragment, null)

        val wallpaper = (wallpaperlistAdapter as WallpaperAdapter).wallpaperArrayList[i]
        val wallpaperManager = WallpaperManager.getInstance(activity)
        try {
//            wallpaperManager.setResource(wallpaper.Img)

            val icon = BitmapFactory.decodeResource(resources, wallpaper.Img)

//            wallpaperManager.setBitmap(icon, null, true, WallpaperManager.FLAG_SYSTEM);

            wallpaperManager.setBitmap(icon, null, true, WallpaperManager.FLAG_LOCK);

            DialogHelperClass.successWallpaper(requireActivity(), this)

//            Toast.makeText(activity, "Wallpaper changed successfully", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(activity, "Error changing wallpaper", Toast.LENGTH_SHORT).show()
        }


//        DialogHelperClass.setWallpaper(
//            requireContext(),this)


    }


//    @RequiresApi(Build.VERSION_CODES.ECLAIR_MR1)
//    fun setWallpaperFromUrl(context: Context, imageUrl: String) {
//
//    }
//
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun setLockScreenWallpaperFromUrl(context: Context, imageUrl: String) {
//        Thread {
//            var bitmap: Bitmap? = null
//            var connection: HttpURLConnection? = null
//            try {
//                val url = URL(imageUrl)
//                connection = url.openConnection() as HttpURLConnection
//                connection.doInput = true
//                connection.connect()
//                val input: InputStream = connection.inputStream
//                bitmap = BitmapFactory.decodeStream(input)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            } finally {
//                connection?.disconnect()
//            }
//            if (bitmap != null) {
//                val wallpaperManager = WallpaperManager.getInstance(context)
//                try {
//                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        }.start()
//    }


//    override fun onGoHomeButton() {
//    }

    override fun onExitButton() {

    }


}