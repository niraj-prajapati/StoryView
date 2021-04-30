/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 12:07 PM
 */

package com.niraj.storyviewer.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StoryUser(val username: String, val profilePicUrl: String, val stories: ArrayList<Story>) : Parcelable