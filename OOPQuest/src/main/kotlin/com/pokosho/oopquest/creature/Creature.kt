package com.pokosho.oopquest.creature

import com.pokosho.oopquest.spell.Spell

interface Creature {
    val name: String
    var hitPoint: Int
    var magicPoint: Int
    val offence: Int
    val defense: Int
    val spells: List<Spell>

    // TODO: 攻撃クラスで表現すべきかもしれませんが今回は目をつぶってください。
    fun attack(targets: List<Creature>): Creature {
        val target = targets.firstOrNull() ?: throw IllegalAccessException("no targets")
        val damage = this.offence - target.defense
        target.hitPoint -= if (damage < 0) { 0 } else { damage }
        return target
    }

    fun hasSpells(): Boolean {
        return spells.isEmpty()
    }
}