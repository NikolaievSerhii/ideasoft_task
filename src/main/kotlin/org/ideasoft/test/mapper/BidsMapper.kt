package org.ideasoft.test.mapper

import com.google.gson.JsonArray
import org.ideasoft.test.domain.Bid
import org.ideasoft.test.domain.BidType

object BidsMapper {
    fun map(source: JsonArray): List<Bid> = source.map {
        it.asJsonObject.get("bid").asJsonObject.let { bid ->
            Bid(
                bid.get("id").asString,
                bid.get("ts").asLong,
                BidType.from(bid.get("ty").asString),
                bid.get("pl").asString,
            )
        }
    }
}