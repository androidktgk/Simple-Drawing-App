package com.govind8061.kidsdrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val drawingView=DrawingView(this)
        setContentView(drawingView)
    }
}