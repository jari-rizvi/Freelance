package com.teamx.ui.fragments.previewWallpaper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentPreviewWallpaperBinding
import com.teamx.freelance.databinding.FragmentTempBinding
import com.teamx.ui.utils.DialogHelperClass


class PreviewWallpaperFragment : Fragment(), DialogHelperClass.Companion.setWallpaperDialog {

    lateinit var fragmentPreviewWallpaperBinding: FragmentPreviewWallpaperBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentPreviewWallpaperBinding.btnApply.setOnClickListener {
            DialogHelperClass.setWallpaper(
                requireContext(),this)

        }


    }

    override fun onHomeScreenButton() {

    }

    override fun onLockScreenButton() {

    }

    override fun onbothButton() {

    }


}