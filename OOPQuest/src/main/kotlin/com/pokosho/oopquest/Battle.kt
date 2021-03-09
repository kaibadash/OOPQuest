package com.pokosho.oopquest

import com.pokosho.oopquest.creature.Creature

class Battle(val members: List<Creature>, val monsters: List<Creature>) {
    fun startBattle() {
        val activeMembers = members.filter { it.hitPoint > 0 }
        var activeMonsters = monsters.filter { it.hitPoint > 0 }
        while (activeMembers.isNotEmpty() && activeMonsters.isNotEmpty()) {
            activeMembers.forEach {
                val target = it.attack(activeMonsters)
                println("${it.name} は ${target.name} を攻撃した")
                if (target.hitPoint <= 0) {
                    println("${target.name} を倒した")
                }
            }
            activeMonsters = monsters.filter { it.hitPoint > 0 }
            activeMonsters.forEach {
                val target = it.attack(members)
                println("${it.name} は ${target.name} を攻撃した")
                if (target.hitPoint <= 0) {
                    println("${target.name} は死んでしまった")
                }
            }
        }

        if (members.filter { it.hitPoint > 0 }.isNotEmpty()) {
            println("モンスターをやっつけた！")
            return
        }
        println("モンスターにやられてしまった…")
    }
}