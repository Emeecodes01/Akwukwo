package com.mobigods.core.base

interface BaseMapper<F, T> {
    fun mapTo(to: T): F
    fun mapFrom(from: F): T
}