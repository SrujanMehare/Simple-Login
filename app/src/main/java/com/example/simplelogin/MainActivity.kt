package com.example.simplelogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = AdapterMain()

        fetchJson()
    }

    fun fetchJson() {
        val url = "http://139.162.53.200:3000/"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            //not getting proper response from onres fun
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
            }
        })
    }
}