package com.pokosho.oopquest

import com.pokosho.oopquest.spell.Spell

class SpellAttach(val spell: Spell): Attack {
    override fun description(): String {
        return "${spell.name} を唱えた"
    }
}