package com.pokosho.oopquest.spell

/**
 * NOTE: 今回の設計の対象にはしないため、この設計は目をつぶってください。
 */
interface Spell {
    val damage: Int
        get() = 10
    val magicPointCost: Int
        get() = 2
}