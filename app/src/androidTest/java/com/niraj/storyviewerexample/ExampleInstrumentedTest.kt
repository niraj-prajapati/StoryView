/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 12:07 PM
 */

package com.niraj.storyviewerexample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.niraj.storyviewer", appContext.packageName)
    }
}