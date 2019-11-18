package com.example.yigit.myrandomcat.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity
data class FavDrinks(@PrimaryKey @ColumnInfo(name = "drink_name")var strDrink:String, @ColumnInfo(name = "glass")var strGlass:String, @ColumnInfo(name = "Ingredients")var strIngredients:String, @ColumnInfo(name = "Instructions") var strInstructions:String, @ColumnInfo(name = "image_url") var strImageurl:String) : Serializable