package com.pm.dntlabtest.main

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.pm.dntlabtest.R
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)




    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.pm.dntlabtest", appContext.packageName)
    }

    @Test
    fun checkLayoutVisibility() {
        onView(withId(R.id.rvContent)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.pb)).check(matches(isDisplayed()))
        onView(withId(R.id.clError)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }
}
