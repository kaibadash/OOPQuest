package com.pokosho.oopquest.creature

import com.pokosho.oopquest.spell.Spell

class Fighter(
    override val name: String,
    override var hitPoint: Int,
    override var magicPoint: Int,
    override val offence: Int,
    override val defense: Int,
    override val spells: List<Spell> = emptyList()
) : Creature