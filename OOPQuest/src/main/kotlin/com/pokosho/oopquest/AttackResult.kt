package com.pokosho.oopquest

import com.pokosho.oopquest.creature.Creature

class AttackResult(
    val attacker: Creature,
    val target: Creature,
    val attack: Attack,
    val damage: Int
) {
    override fun toString(): String {
        return "${attacker.name} は ${attack.description()}！ ${target.name} に ${damage} のダメージ！"
    }
}