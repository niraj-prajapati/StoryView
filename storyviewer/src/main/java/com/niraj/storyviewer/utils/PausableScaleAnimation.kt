/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 10:57 AM
 */

package com.niraj.storyviewer.utils

import android.view.animation.ScaleAnimation
import android.view.animation.Transformation

class PausableScaleAnimation internal constructor(
    fromX: Float, toX: Float, fromY: Float,
    toY: Float, pivotXType: Int, pivotXValue: Float, pivotYType: Int,
    pivotYValue: Float
) : ScaleAnimation(
    fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType,
    pivotYValue
) {
    private var elapsedAtPause: Long = 0
    private var isPaused = false
    override fun getTransformation(
        currentTime: Long,
        outTransformation: Transformation,
        scale: Float
    ): Boolean {
        if (isPaused && elapsedAtPause == 0L) {
            elapsedAtPause = currentTime - startTime
        }
        if (isPaused) {
            startTime = currentTime - elapsedAtPause
        }
        return super.getTransformation(currentTime, outTransformation, scale)
    }

    fun pause() {
        if (isPaused) return
        elapsedAtPause = 0
        isPaused = true
    }

    fun resume() {
        isPaused = false
    }
}