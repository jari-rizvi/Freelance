package com.teamx.ui.fragments.temp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import com.teamx.freelance.R
import com.teamx.freelance.databinding.FragmentTempBinding

class TempFragment : Fragment() {
    var navController: NavController? = null
    lateinit var fragmentLoginBinding: FragmentTempBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding = FragmentTempBinding.inflate(inflater,container,false);

        Handler(Looper.getMainLooper()).postDelayed({
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            navController?.navigate(R.id.wallpaperListFragment, null,)

        }, 2000)

        return fragmentLoginBinding.root;
    }


}