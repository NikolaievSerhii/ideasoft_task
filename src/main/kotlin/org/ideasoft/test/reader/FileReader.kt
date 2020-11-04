package org.ideasoft.test.reader

class FileReader {

    fun read(fileName: String) = this::class.java.classLoader.getResource(fileName).readText()
}