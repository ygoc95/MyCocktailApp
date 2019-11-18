package com.example.yigit.myrandomcat.Adapters

import android.app.Activity
import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.yigit.myrandomcat.Activities.CocktailPage
import com.example.yigit.myrandomcat.Database.AppDatabase
import com.example.yigit.myrandomcat.Models.FavDrinks
import com.example.yigit.myrandomcat.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fav_item.view.*
import kotlinx.android.synthetic.main.search_item.view.search_category_textview
import kotlinx.android.synthetic.main.search_item.view.search_glass_textview
import kotlinx.android.synthetic.main.search_item.view.search_imageView
import kotlinx.android.synthetic.main.search_item.view.searchname_textView
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class FavRCViewAdapter (var drinklist: List<FavDrinks>, val context: Context,val activity: Activity): RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(com.example.yigit.myrandomcat.R.layout.fav_item,parent,false)

            if(drinklist.isNullOrEmpty()){
                activity.setContentView(R.layout.fail_view)
        }
        return CustomViewHolder(cellForRow)

    }

    override fun getItemCount(): Int {
        return drinklist.size

        0    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {

        p0.view.searchname_textView.setText(drinklist[p1].strDrink)
        p0.view.search_category_textview.setText("") //TAKE A LOOK HERE LATER
        p0.view.search_glass_textview.setText(drinklist[p1].strGlass)
        Picasso.get().load(drinklist[p1].strImageurl).fit().centerCrop().into(p0.view.search_imageView)
        p0.view.setOnClickListener(){

            val intent = Intent(context, CocktailPage::class.java)
            intent.putExtra("cocktailobject",drinklist[p1])
            intent.putExtra("from","FavRCViewAdapter")
            context.startActivity(intent)


        }

        p0.view.delete_button.setOnClickListener{
            val db:AppDatabase= Room.databaseBuilder(context,AppDatabase::class.java,"fav_database").build()
            val mExecutor: Executor = Executors.newSingleThreadExecutor()
            mExecutor.execute{
                db.favDao().deletebyId(drinklist[p1].strDrink)


            }
            Toast.makeText(context,"Deleted: "+drinklist[p1].strDrink,Toast.LENGTH_SHORT).show()



        }



    }


}

