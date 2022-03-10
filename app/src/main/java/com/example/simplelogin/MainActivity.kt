package com.example.simplelogin

import UserAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplelogin.Model.Users
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val jsonString = getJSONFromAssets()!!
            val users = Gson().fromJson(jsonString, Users::class.java)

            // Set the LayoutManager that this RecyclerView will use.
            rvUsersList.layoutManager = LinearLayoutManager(this)
            // Adapter class is initialized and list is passed in the param.
            val itemAdapter = UserAdapter(this, users.users)
            // adapter instance is set to the recyclerview to inflate the items.
            rvUsersList.adapter = itemAdapter


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun getJSONFromAssets(): String? {

        val json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Users.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
//fetchJson()

//    fun fetchJson() {
//        val url = "http://139.162.53.200:3000/?child=false"
//        val request = Request.Builder().url(url).build()
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute request")
//            }
//
//            //not getting proper response from onres fun
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body()?.string()
//                println(body)
//            }
//        })
