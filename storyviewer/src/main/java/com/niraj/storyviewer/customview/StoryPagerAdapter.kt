/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 10:57 AM
 */

package com.niraj.storyviewer.customview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.niraj.storyviewer.data.StoryUser
import com.niraj.storyviewer.screen.StoryDisplayFragment

class StoryPagerAdapter constructor(fragmentManager: FragmentManager, private val storyList: ArrayList<StoryUser>)
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = StoryDisplayFragment.newInstance(position, storyList[position])

    override fun getCount(): Int {
        return storyList.size
    }

    fun findFragmentByPosition(viewPager: ViewPager, position: Int): Fragment? {
        try {
            val f = instantiateItem(viewPager, position)
            return f as? Fragment
        } finally {
            finishUpdate(viewPager)
        }
    }
}