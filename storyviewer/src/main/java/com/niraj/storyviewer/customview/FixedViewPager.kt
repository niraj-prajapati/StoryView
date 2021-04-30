/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 10:57 AM
 */

package com.niraj.storyviewer.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

import androidx.viewpager.widget.ViewPager

class FixedViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ViewPager(context, attrs) {
    // prevent NPE if fake dragging and touching ViewPager
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (isFakeDragging) {
            false
        } else try {
            super.onInterceptTouchEvent(ev)
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}