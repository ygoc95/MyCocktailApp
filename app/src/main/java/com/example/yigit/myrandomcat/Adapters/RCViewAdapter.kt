package com.example.yigit.myrandomcat.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yigit.myrandomcat.Activities.CocktailPage
import com.example.yigit.myrandomcat.Models.Drinks
import com.example.yigit.myrandomcat.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search_item.view.*

class RCViewAdapter (val drinklist: List<Drinks>, val context:Context):RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.search_item,parent,false)
        return CustomViewHolder(cellForRow)

    }

    override fun getItemCount(): Int {
        return drinklist.size

0    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {

        p0.view.searchname_textView.setText(drinklist[p1].strDrink)
        p0.view.search_category_textview.setText(drinklist[p1].strCategory)
        p0.view.search_glass_textview.setText(drinklist[p1].strGlass)
        Picasso.get().load(drinklist[p1].strDrinkThumb).fit().centerCrop().into(p0.view.search_imageView)
        p0.view.setOnClickListener(){

            val intent = Intent(context, CocktailPage::class.java)
            intent.putExtra("cocktailobject",drinklist[p1])
            intent.putExtra("from","RCViewAdapter")
            context.startActivity(intent)


        }



    }


}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view){}