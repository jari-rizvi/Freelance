package com.teamx.ui.fragments.previewWallpaper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.teamx.freelance.databinding.ItemViewpagerBinding


class ViewPagerViewHolder(itemViewPagerBinding: ItemViewpagerBinding) :
    RecyclerView.ViewHolder(itemViewPagerBinding.root) {
    val binding = itemViewPagerBinding
}


class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    var fragmentList: ArrayList<Fragment>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}



