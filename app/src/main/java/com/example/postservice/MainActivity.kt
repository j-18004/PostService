package com.example.postservice


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.postservice.R.id.button

class MainActivity : AppCompatActivity() {

    internal lateinit var b1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById<View>(button) as Button
        b1.setOnClickListener {
            val post = AsyncHttp("Android", 10.11)
            post.execute()
        }

    }

}