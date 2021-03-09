package com.pokosho.oopquest

import com.pokosho.oopquest.creature.Fighter
import com.pokosho.oopquest.creature.Magician
import com.pokosho.oopquest.creature.Monster
import com.pokosho.oopquest.spell.Fire

fun main() {
    Battle(listOf(
        Fighter("センシ", 30, 0, 10, 10),
        Magician("マホ", 15, 10, 5, 5, listOf(Fire())),
    ), listOf(
        Monster("カンドタ", 150, 0, 20, 4, listOf()),
    )).startBattle()
}
