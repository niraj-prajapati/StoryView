/*
 * Created by Niraj Prajapati on 30/4/21 2:01 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 2:01 PM
 */

package com.niraj.storyviewer.utils

import android.content.Context
import android.content.Intent
import com.niraj.storyviewer.data.StoryUser
import com.niraj.storyviewer.screen.StoryViewActivity

class StoryView private constructor(
    private val context: Context,
    private val storyUserList: ArrayList<StoryUser>,
    private val currentPage: Int
) {

    fun showStories() {
        val payIntent = Intent(context, StoryViewActivity::class.java)
        payIntent.putExtra("storyUserList", storyUserList)
        payIntent.putExtra("currentPage", currentPage)
        context.startActivity(payIntent)
    }

    class Builder {
        private var context: Context? = null
        private var storyUserList: ArrayList<StoryUser>? = null
        private var currentPage: Int = 0

        fun with(context: Context): Builder {
            this.context = context
            storyUserList = ArrayList()
            return this
        }

        fun setStoryUserList(storyUserList: ArrayList<StoryUser>): Builder {
            check(storyUserList.isNotEmpty()) { "storyUserList should not be empty" }
            this.storyUserList = storyUserList
            return this
        }

        fun setCurrentPage(currentPage: Int): Builder {
            this.currentPage = currentPage
            return this
        }

        fun build(): StoryView {
            checkNotNull(context) { "Activity must be specified using with() call before build()" }
            checkNotNull(storyUserList) { "storyUserList must be specified using setStoryUserList() call before build()" }
            return StoryView(context!!, storyUserList!!, currentPage)
        }
    }
}