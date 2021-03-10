package com.pokosho.oopquest.creature

import com.pokosho.oopquest.AttackResult
import com.pokosho.oopquest.PhysicalAttach
import com.pokosho.oopquest.spell.Spell

interface Creature {
    val name: String
    var hitPoint: Int
    var magicPoint: Int
    val offence: Int
    val defense: Int
    val spells: List<Spell>

    fun attack(targets: List<Creature>): AttackResult {
        val target = this.target(targets)
        val damage = this.offence - target.defense
        target.hitPoint -= if (damage < 0) { 0 } else { damage }
        return AttackResult(this, target, PhysicalAttach(), damage)
    }

    fun hasSpells(): Boolean {
        return spells.isNotEmpty()
    }

    fun target(targets: List<Creature>): Creature {
        return targets.shuffled().firstOrNull() ?: throw IllegalAccessException("no targets")
    }
}