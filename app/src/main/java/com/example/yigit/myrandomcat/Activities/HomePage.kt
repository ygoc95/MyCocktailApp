package com.example.yigit.myrandomcat.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yigit.myrandomcat.R
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        search_button.setOnClickListener {
            val intent = Intent(this, ListPage::class.java)
            val text:String= search_text.text.toString()
            if(text.isNullOrEmpty()){
                Toast.makeText(this,"Search Field is empty :(",Toast.LENGTH_SHORT).show()}
            else{
                intent.putExtra("cocktailname", text)
                startActivity(intent)}


        }

        fav_button.setOnClickListener{


            val intent=Intent(this,FavPage::class.java)
            startActivity(intent)
        }



    }




}
