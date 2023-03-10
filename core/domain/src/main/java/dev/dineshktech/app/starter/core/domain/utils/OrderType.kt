package dev.dineshktech.app.starter.core.domain.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}