package com.teamx.ui.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.TextView
import com.teamx.freelance.R

class DialogHelperClass {
    companion object {

        interface setWallpaperDialog {
            fun onHomeScreenButton()
            fun onLockScreenButton()
            fun onbothButton()
        }

        fun setWallpaper(context: Context, dialogCallBack: setWallpaperDialog) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_set_wallpaper)
            dialog.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT
            )

            val HomeBtn = dialog.findViewById<TextView>(R.id.btnHome)
            HomeBtn.text = "btnHome"
            HomeBtn.setOnClickListener {
                dialogCallBack.onHomeScreenButton()
            }

             val btnLock = dialog.findViewById<TextView>(R.id.btnLock)
            btnLock.text = "btnHome"
            btnLock.setOnClickListener {
                dialogCallBack.onLockScreenButton()
            }

              val btnLockHome = dialog.findViewById<TextView>(R.id.btnLockHome)
            btnLockHome.text = "btnHome"
            btnLockHome.setOnClickListener {
                dialogCallBack.onbothButton()
            }


            val cancelBtn = dialog.findViewById<TextView>(R.id.btncncl)

            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }

            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }


    }


}