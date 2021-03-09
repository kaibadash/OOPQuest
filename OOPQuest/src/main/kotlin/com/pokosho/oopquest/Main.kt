package com.pokosho.oopquest

import com.pokosho.oopquest.creature.Fighter
import com.pokosho.oopquest.creature.Magician
import com.pokosho.oopquest.creature.Monster
import com.pokosho.oopquest.spell.Fire

fun main() {
    val count = 100
    val results = mutableListOf<Boolean>()
    for (i in 0..count) {
        results.add(Battle(
            listOf(
                Fighter("センシ", 30, 0, 10, 10),
                Fighter("ファイタ", 30, 0, 10, 10),
                Magician("マホ", 15, 6, 5, 5, listOf(Fire())),
            ), listOf(
                Monster("カンドタ", 130, 0, 16, 4, listOf()),
            )
        ).startBattle())
    }
    println("勝率: ${results.filter { it }.count()} / ${count}")
}
