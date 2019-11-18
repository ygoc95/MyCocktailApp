package com.example.yigit.myrandomcat.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.yigit.myrandomcat.Models.FavDrinks

@Database(entities = [FavDrinks::class],version = 1)
abstract class AppDatabase:RoomDatabase(){

    abstract fun favDao():FavDAO




}