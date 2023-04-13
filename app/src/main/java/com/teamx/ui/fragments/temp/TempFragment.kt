package com.teamx.ui.fragments.temp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentTempBinding
import com.teamx.ui.utils.InterstitialFacebook
import com.teamx.ui.utils.OnClosed

class TempFragment : Fragment(), OnClosed {
    var navController: NavController? = null
    lateinit var fragmentLoginBinding: FragmentTempBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding = FragmentTempBinding.inflate(inflater, container, false);


        InterstitialFacebook.Companion.loadInterstitialAppLovin(requireActivity(), "YOUR_GAID_HERE")

        Handler(Looper.getMainLooper()).postDelayed({

            InterstitialFacebook.Companion.showInterstitialAppLovin(this, requireActivity())



        }, 8000)

        return fragmentLoginBinding.root;
    }

    override fun onAdClosed() {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        navController?.navigate(R.id.wallpaperListFragment, null)
    }


}