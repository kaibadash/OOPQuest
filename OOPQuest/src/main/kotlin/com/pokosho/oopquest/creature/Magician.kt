package com.pokosho.oopquest.creature

import com.pokosho.oopquest.AttackResult
import com.pokosho.oopquest.PhysicalAttach
import com.pokosho.oopquest.SpellAttach
import com.pokosho.oopquest.spell.Spell

class Magician(
    override val name: String,
    override var hitPoint: Int,
    override var magicPoint: Int,
    override val offence: Int,
    override val defense: Int,
    override val spells: List<Spell>
) : Creature {
    // TODO: 攻撃クラスで表現すべきかもしれませんが今回は目をつぶってください。
    override fun attack(targets: List<Creature>): AttackResult {
        val target = targets.firstOrNull() ?: throw IllegalAccessException("no targets")
        if (!this.hasSpells()) {
            return super.attack(targets)
        }
        val spell = spells.filter { it.magicPointCost <= this.magicPoint }.firstOrNull()
            ?: return super.attack(targets)
        // TODO: immutableにしたい
        this.magicPoint = spell.magicPointCost
        target.hitPoint = spell.damage
        return AttackResult(this, target, SpellAttach(spell), spell.damage)
    }
}