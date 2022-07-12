package com.example.nutritionapp.util

import java.io.File
import java.io.InputStreamReader

object ReadFiles {
    fun readFile(path: String): File {
        return File(path)
    }
}