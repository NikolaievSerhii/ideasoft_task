package org.ideasoft.test.reader

import org.ideasoft.test.converter.JsonParser
import org.ideasoft.test.domain.Bid
import org.ideasoft.test.mapper.BidsMapper

class BidsReader {

    private val fileName = "bids.json"

    fun read(): List<Bid> = BidsMapper.map(
        JsonParser.toJsonArray(FileReader().read(fileName))
    )
}