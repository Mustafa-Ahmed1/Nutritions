package com.example.nutritionapp.util

fun String.toPureNumber(): Double {
    return when {
        this.contains(" g") -> {
            this.replace(" g","").toDouble()
        }
        this.contains(" mg") -> {
            this.replace(" mg","").toDouble()
        }
        this.contains(" mcg") -> {
            this.replace(" mcg","").toDouble()
        }

        this.contains(" IU") -> {
            this.replace(" IU","").toDouble()
        }
        else -> 0.0
    }
}