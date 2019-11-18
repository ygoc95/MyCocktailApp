package com.example.yigit.myrandomcat.Database

import android.arch.persistence.room.*
import com.example.yigit.myrandomcat.Models.FavDrinks


@Dao
interface FavDAO {

    @Query("SELECT * FROM FavDrinks")
    fun getAll():List<FavDrinks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(favDrinks: FavDrinks)

    @Query("DELETE FROM FavDrinks WHERE drink_name = :drinkname ")
    fun deletebyId(drinkname:String)

    @Delete
    fun delete(favDrinks: FavDrinks)




}