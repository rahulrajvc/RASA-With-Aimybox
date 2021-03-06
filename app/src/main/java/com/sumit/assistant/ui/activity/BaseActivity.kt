package com.sumit.assistant.ui.activity

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sumit.assistant.util.AppUtil
import kotlinx.android.synthetic.main.layout_activity_main.*

open class BaseActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this
    }

    override fun onStart() {
        super.onStart()

        initUICustomization()
    }

    private fun initUICustomization() {

        AppUtil.makeStatusbarTransparent(this)

        // Start gradient animation
        Handler().postDelayed({
            if (fl_container != null)
                AppUtil.toggleAnimationBackground(fl_container, true)
        }, 2000)

    }

    override fun onStop() {

        if (fl_container != null)
            AppUtil.toggleAnimationBackground(fl_container, false)

        super.onStop()
    }
}