package com.example.yigit.myrandomcat.Activities

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.yigit.myrandomcat.Adapters.FavRCViewAdapter
import com.example.yigit.myrandomcat.Database.AppDatabase
import com.example.yigit.myrandomcat.Models.FavDrinks
import com.example.yigit.myrandomcat.R
import kotlinx.android.synthetic.main.activity_fav_page.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class FavPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_page)
        val db: AppDatabase = Room.databaseBuilder(this, AppDatabase::class.java,"fav_database").build()
        val mExecutor: Executor = Executors.newSingleThreadExecutor()
        mExecutor.execute{
            var favlist:List<FavDrinks> = db.favDao().getAll()
            fav_recyclerview.layoutManager=LinearLayoutManager(this)
            fav_recyclerview.adapter=FavRCViewAdapter(favlist,this,this)

        }



    }

    }




