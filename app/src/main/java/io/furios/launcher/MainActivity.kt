package io.furios.launcher

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.app.ActivityManager
import android.content.Intent

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (getSystemService(ACTIVITY_SERVICE) as ActivityManager).let { am ->
            am.memoryClass
        }

        View(this).apply {
            setBackgroundColor(0xFF000000.toInt())
            systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
        }.also { setContentView(it) }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        if (intent.categories?.contains(Intent.CATEGORY_LAUNCHER) == true) {
            startActivity(intent)
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        System.gc()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        System.gc()
    }
}