package com.mobigods.core.utils

import com.mobigods.core.R

object Tools {

    /**
     * I did this because the icon coming back from the server makes my UI look horrible
     */
    fun getSubjectIconFromName(name: String): Int {
        return when(name) {
            "Mathematics" -> R.drawable.ic_math
            "English" -> R.drawable.ic_english
            "Physics" -> R.drawable.ic_physics
            "Chemistry" -> R.drawable.ic_chemistry
            "Biology" -> R.drawable.ic_biology
            else -> 0
        }
    }


    fun getSubjectBackgroundFromName(name: String): Int {
        return when(name) {
            "Mathematics" -> R.drawable.mathematics_backdrop
            "English" -> R.drawable.english_backdrop
            "Physics" -> R.drawable.physics_backdrop
            "Chemistry" -> R.drawable.chemistry_backdrop
            "Biology" -> R.drawable.biology_backdrop
            else -> 0
        }
    }

    fun getCardColorFromName(name: String): Int {
        return  when(name) {
            "Mathematics" -> R.color.burnt_sienna
            "English" -> R.color.waikawa_gray
            "Physics" -> R.color.chetwode_bluw
            "Chemistry" -> R.color.rajah
            "Biology" -> R.color.silver_tree
            else -> 0
        }
    }
}