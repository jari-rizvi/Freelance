package com.teamx.freelance

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null

    private var mainDrawer: DrawerLayout? = null
    private var sideDrawerMenu: ImageView? = null
    private var toolbarMainAct: ConstraintLayout? = null
    lateinit var progress_bar: ProgressBar
    private var navView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialising()

        addDrawer()
        setHeader()


        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.tempFragment -> {
                    toolbarMainAct?.visibility = View.GONE
                }

                else -> {
                    toolbarMainAct?.visibility = View.GONE


                }
            }
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

    }

    fun addDrawer() {
        sideDrawerMenu!!.setOnClickListener {
            mainDrawer!!.openDrawer(GravityCompat.START)
        }

        val dp1 = 2
        val params = LinearLayout.LayoutParams(
            dp1 * 50, dp1 * 35
        )
        params.gravity = Gravity.CENTER
        params.topMargin = 35


        navView!!.setNavigationItemSelectedListener { item ->
            Handler(Looper.getMainLooper()).postDelayed({

                // Your Code

                navController = Navigation.findNavController(this, R.id.nav_host_fragment)
                when (item.itemId) {
                    R.id.home -> {


                        navController!!.navigate(R.id.wallpaperListFragment, null, null)

//                        navigateFragmentMethod(R.id.shippingAddressFragment, true)
                    }
                    R.id.settings -> {


//                        navController!!.navigate(R.id.settingFragment, null, null)

//                        navigateFragmentMethod(R.id.shippingAddressFragment, true)
                    }


                }


            }, 200)
            false
        }
//
    }


    private fun initialising() {
        progress_bar = findViewById(R.id.progress_bar)
        navView = findViewById(R.id.nav_view)
        mainDrawer = findViewById(R.id.mainDrawer)
        sideDrawerMenu = findViewById(R.id.menu)

    }

    private fun setHeader() {

        val navigationView = navView
        val hView = navigationView?.getHeaderView(0)


    }


}