package com.ibotta.gradle.aop.brokenkapt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibotta.gradle.aop.brokenkapt.logic.Controller

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        aopTarget(Controller())
    }

    fun aopTarget(controller: Controller) {
        controller.process()
    }
}