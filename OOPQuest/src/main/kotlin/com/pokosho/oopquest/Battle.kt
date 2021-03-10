package com.pokosho.oopquest

import com.pokosho.oopquest.creature.Creature

class Battle(val members: List<Creature>, val monsters: List<Creature>) {
    fun startBattle(): Boolean {
        var activeMembers = members.filter { it.hitPoint > 0 }
        var activeMonsters = monsters.filter { it.hitPoint > 0 }
        while (activeMembers.isNotEmpty() && activeMonsters.isNotEmpty()) {
            activeMembers.forEach {
                val attackResult = it.attack(activeMonsters)
                println(attackResult)
                if (attackResult.target.hitPoint <= 0) {
                    println("${attackResult.target} を倒した")
                }
            }
            activeMonsters = monsters.filter { it.hitPoint > 0 }
            activeMonsters.forEach {
                val attackResult = it.attack(activeMembers)
                println(attackResult)
                if (attackResult.target.hitPoint <= 0) {
                    println("${attackResult.target.name} は死んでしまった")
                }
            }
            activeMembers = members.filter { it.hitPoint > 0 }
        }

        if (members.filter { it.hitPoint > 0 }.isNotEmpty()) {
            println("モンスターをやっつけた！")
            return true
        }
        println("モンスターにやられてしまった…")
        return false
    }
}