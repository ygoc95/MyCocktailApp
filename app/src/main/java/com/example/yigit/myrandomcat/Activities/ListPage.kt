package com.example.yigit.myrandomcat.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.yigit.myrandomcat.JsonRequest
import com.example.yigit.myrandomcat.R
import kotlinx.android.synthetic.main.activity_list_page.*

class ListPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_page)
        var ss:String = intent.getStringExtra("cocktailname")
        ss = ss.replace("\\s".toRegex(), "_")
        println(ss)

        val jsonRequest = JsonRequest()
        recyclerview_search.layoutManager=LinearLayoutManager(this)
       jsonRequest.jsonparse(this,"https://www.thecocktaildb.com/api/json/v1/YOURAPIKEY/search.php?s="+ss,recyclerview_search)

    }

}
