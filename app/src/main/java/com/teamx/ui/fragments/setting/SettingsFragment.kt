package com.teamx.ui.fragments.setting

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.teamx.freelance.MainActivity
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentSettingsBinding
import com.teamx.freelance.databinding.FragmentTempBinding
import com.teamx.ui.utils.BannerFacebook

class SettingsFragment : Fragment() {
    var navController: NavController? = null
    lateinit var fragmentSettingsBinding: FragmentSettingsBinding

    lateinit var banner : BannerFacebook

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false);

        banner = BannerFacebook()
        banner.loadAppLovInBanner(requireActivity(), fragmentSettingsBinding.bannerAdApplovin, "YOUR_GAID_HERE")

        return fragmentSettingsBinding.root;
    }




}