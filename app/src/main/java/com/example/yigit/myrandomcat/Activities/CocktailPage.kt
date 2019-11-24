package com.example.yigit.myrandomcat.Activities

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.yigit.myrandomcat.Adapters.FavRCViewAdapter
import com.example.yigit.myrandomcat.Database.AppDatabase
import com.example.yigit.myrandomcat.Models.Drinks
import com.example.yigit.myrandomcat.Models.FavDrinks
import com.example.yigit.myrandomcat.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cocktail_page.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class CocktailPage : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_page)
        val db: AppDatabase = Room.databaseBuilder(this, AppDatabase::class.java,"fav_database").build()
        val mExecutor: Executor = Executors.newSingleThreadExecutor()

        if(intent.getStringExtra("from")=="RCViewAdapter"){

        val drink: Drinks? = intent.getSerializableExtra("cocktailobject") as? Drinks


        textview_cocktail_indregient.setText(indregientTextMaker(drink))
        Picasso.get().load(drink?.strDrinkThumb).fit().centerCrop().into(cocktail_imageview)
        textview_cocktail_instructions.setText("Instructions:"+"\n"+drink?.strInstructions)
        textview_cocktail_name.setText(drink?.strDrink)

        favbutton.setOnClickListener{
            favAction(mExecutor,db,intent.getSerializableExtra("cocktailobject") as? Drinks)
            Toast.makeText(this,drink?.strDrink+" saved to favourites!",Toast.LENGTH_SHORT).show()

        }
        }

        else if(intent.getStringExtra("from")=="FavRCViewAdapter"){

            val drink:FavDrinks?=intent.getSerializableExtra("cocktailobject") as FavDrinks

            textview_cocktail_indregient.setText(drink?.strIngredients)
            textview_cocktail_instructions.setText(drink?.strInstructions)
            textview_cocktail_name.setText(drink?.strDrink)
            Picasso.get().load(drink?.strImageurl).fit().centerCrop().into(cocktail_imageview)
            favbutton.visibility= View.GONE

        }




        }


    fun favAction(execute:Executor, appDatabase: AppDatabase, drinks: Drinks?) {

        execute.execute{


                appDatabase.favDao().insertAll(FavDrinks(drinks?.strDrink.toString(), drinks?.strGlass.toString(), indregientTextMaker(drinks), drinks?.strInstructions.toString(), drinks?.strDrinkThumb.toString()))

        }


    }

fun indregientTextMaker( drinks: Drinks?):String{


        //var indreigients:String = "Ingredients "+drinks?.strMeasure1+" "+drinks?.strIngredient1+"\n"+drinks?.strMeasure2+" "+drinks?.strIngredient2+"\n"+drinks?.strMeasure3+" "+drinks?.strIngredient3+"\n"+drinks?.strMeasure4+" "+drinks?.strIngredient4+"\n"+drinks?.strMeasure5+" "+drinks?.strIngredient5+"\n"+drinks?.strMeasure6+" "+drinks?.strIngredient6+"\n"+drinks?.strMeasure7+" "+drinks?.strIngredient7+"\n"+drinks?.strMeasure8+" "+drinks?.strIngredient8+"\n"
        //indreigients=indreigients.replace("null","")

        var ingredients:String="Ingredients:"+"\n"
        if(drinks?.strIngredient1.isNullOrEmpty()==false&&drinks?.strIngredient1!=="null"){

            if (drinks?.strMeasure1.isNullOrEmpty()==false&&drinks?.strIngredient1!=="null"){
                ingredients=ingredients+drinks?.strMeasure1+" "+drinks?.strIngredient1+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient1+"\n"


            }

        }
        if(drinks?.strIngredient2.isNullOrEmpty()==false&&drinks?.strIngredient2!=="null"){

            if (drinks?.strMeasure2.isNullOrEmpty()==false&&drinks?.strIngredient2!=="null"){
                ingredients=ingredients+drinks?.strMeasure2+" "+drinks?.strIngredient2+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient2+"\n"


            }
        }
        if(drinks?.strIngredient3.isNullOrEmpty()==false&&drinks?.strIngredient3!=="null"){

            if (drinks?.strMeasure3.isNullOrEmpty()==false&&drinks?.strIngredient3!=="null"){
                ingredients=ingredients+drinks?.strMeasure3+" "+drinks?.strIngredient3+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient3+"\n"


            }
        }
        if(drinks?.strIngredient4.isNullOrEmpty()==false&&drinks?.strIngredient4!=="null"){

            if (drinks?.strMeasure4.isNullOrEmpty()==false&&drinks?.strIngredient4!=="null"){
                ingredients=ingredients+drinks?.strMeasure4+" "+drinks?.strIngredient4+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient4+"\n"


            }
        }
        if(drinks?.strIngredient5.isNullOrEmpty()==false&&drinks?.strIngredient5!=="null"){

            if (drinks?.strMeasure5.isNullOrEmpty()==false&&drinks?.strIngredient5!=="null"){
                ingredients=ingredients+drinks?.strMeasure5+" "+drinks?.strIngredient5+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient5+"\n"


            }
        }
        if(drinks?.strIngredient6.isNullOrEmpty()==false&&drinks?.strIngredient6!=="null"){

            if (drinks?.strMeasure6.isNullOrEmpty()==false&&drinks?.strIngredient6!=="null"){
                ingredients=ingredients+drinks?.strMeasure6+" "+drinks?.strIngredient6+"\n"

            }
            else{
                ingredients=ingredients+drinks?.strIngredient6+"\n"


            }
        }
        if(drinks?.strIngredient7.isNullOrEmpty()==false&&drinks?.strIngredient7!==null){

            ingredients=ingredients+drinks?.strMeasure7+" "+drinks?.strIngredient7+"\n"

        }
        if(drinks?.strIngredient8.toString().isNullOrEmpty()==false&&drinks?.strIngredient8.toString()!=="null"){

            ingredients=ingredients+drinks?.strMeasure8.toString()+" "+drinks?.strIngredient8.toString()

        }



        return ingredients

    }}


