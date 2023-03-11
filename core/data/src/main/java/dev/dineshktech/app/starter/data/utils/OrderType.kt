package dev.dineshktech.app.starter.data.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
