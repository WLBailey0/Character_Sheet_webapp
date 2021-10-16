package com.dndCharSheet.dao;

import com.dndCharSheet.model.Spell;

import java.util.List;

public interface SpellDao {
    List<Spell> listSpells(int id);

    Spell getSpell(int id);

    void updateSpellAmount(Spell spell);

    void deleteSpell(int id);

    Spell createSpell(Spell spell);

    List<Spell> getCantrip(int id);

    void changeUsable(int id);


}
