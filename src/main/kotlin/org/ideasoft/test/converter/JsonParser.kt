package org.ideasoft.test.converter

import com.google.gson.JsonArray
import com.google.gson.JsonParser as GsonParser

object JsonParser {

    private val gson = GsonParser()

    fun toJsonArray(source: String): JsonArray = gson.parse(source).asJsonArray
}