package com.example.yigit.myrandomcat.Models

import java.io.Serializable


data class BaseModel(val drinks: List<Drinks>?):Serializable



data class Drinks(val idDrink: String?, val strDrink: String?, val strDrinkAlternate: Any?, val strDrinkES: Any?, val strDrinkDE: Any?, val strDrinkFR: Any?, val strTags: String?, val strVideo: Any?, val strCategory: String?, val strIBA: Any?, val strAlcoholic: String?, val strGlass: String?, val strInstructions: String?, val strInstructionsES: Any?, val strInstructionsDE: Any?, val strInstructionsFR: Any?, val strDrinkThumb: String?, val strIngredient1: String?, val strIngredient2: String?, val strIngredient3: String?, val strIngredient4: String?, val strIngredient5: String?, val strIngredient6: String?, val strIngredient7: String?, val strIngredient8: Any?, val strIngredient9: Any?, val strIngredient10: Any?, val strIngredient11: Any?, val strIngredient12: Any?, val strIngredient13: Any?, val strIngredient14: Any?, val strIngredient15: Any?, val strMeasure1: String?, val strMeasure2: String?, val strMeasure3: String?, val strMeasure4: String?, val strMeasure5: String?, val strMeasure6: String?, val strMeasure7: String?, val strMeasure8: Any?, val strMeasure9: Any?, val strMeasure10: Any?, val strMeasure11: Any?, val strMeasure12: Any?, val strMeasure13: Any?, val strMeasure14: Any?, val strMeasure15: Any?, val strCreativeCommonsConfirmed: String?, val dateModified: Any?):Serializable
