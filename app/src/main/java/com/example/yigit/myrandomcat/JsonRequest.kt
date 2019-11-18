package com.example.yigit.myrandomcat

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.yigit.myrandomcat.Adapters.RCViewAdapter
import com.example.yigit.myrandomcat.Models.BaseModel
import com.example.yigit.myrandomcat.Models.Drinks
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class JsonRequest {


    fun jsonparse(activity:Activity,url:String,recyclerView: RecyclerView){
        val client= OkHttpClient()
        val request= Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Call Failed because"+ e.localizedMessage)
            }

            override fun onResponse(call: Call, response: Response) {

                println("Response Recieved")
                val gson = GsonBuilder().create()
                val body = response.body?.string()
                val drinkList: List<Drinks>? = gson.fromJson(body, BaseModel::class.java).drinks
                if (drinkList.isNullOrEmpty()){
                    activity.runOnUiThread(Runnable {

                    activity.setContentView(R.layout.fail_view)

                    })


                }

                else{

                    println(drinkList[0].strMeasure1.toString() +" Succesfull Parsing")
                    activity.runOnUiThread(Runnable {

                        recyclerView.adapter= RCViewAdapter(drinkList, activity.applicationContext)

                    })
                }




            }
        })
    }
}