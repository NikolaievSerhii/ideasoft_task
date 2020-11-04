package org.ideasoft.test.domain

data class Bid(
    val id: String,
    val timestamp: Long,
    val type: BidType,
    val payload: String
)

enum class BidType {
    ZU, AQ, UNDEFINED;

    companion object {
        fun from(source: String) = values().find { it.name.equals(source, true) } ?: UNDEFINED
    }
}