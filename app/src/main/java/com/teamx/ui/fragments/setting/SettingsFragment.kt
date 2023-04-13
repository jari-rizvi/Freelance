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

class SettingsFragment : Fragment() {
    var navController: NavController? = null
    lateinit var fragmentSettingsBinding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false);


        return fragmentSettingsBinding.root;
    }




}