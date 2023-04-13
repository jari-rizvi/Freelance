package com.teamx.ui.fragments.temp

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
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




        val simpleProgressBar: ProgressBar = fragmentLoginBinding.simpleProgressBar


        InterstitialFacebook.Companion.loadInterstitialAppLovin(requireActivity(), "YOUR_GAID_HERE")

        object : CountDownTimer(8000.toLong(), 50) {

            override fun onTick(millisUntilFinished: Long) {
                val progress = 8000 - millisUntilFinished
                val progressBarPercentage = (progress.toFloat() / 8000.toFloat() * 100).toInt()
                simpleProgressBar.progress = progressBarPercentage
            }

            override fun onFinish() {
                simpleProgressBar.visibility = View.GONE
            }

        }.start()


        Handler(Looper.getMainLooper()).postDelayed({


            InterstitialFacebook.Companion.showInterstitialAppLovin(this, requireActivity())



        }, 8000)

        return fragmentLoginBinding.root;
    }

    override fun onAdClosed() {
        navController = Navigation.findNavController(requireActivity(), com.teamx.freelance.R.id.nav_host_fragment)
        navController?.navigate(com.teamx.freelance.R.id.wallpaperListFragment, null)
    }


}