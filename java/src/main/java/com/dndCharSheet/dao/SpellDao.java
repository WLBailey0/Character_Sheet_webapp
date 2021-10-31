package com.dndCharSheet.dao;

import com.dndCharSheet.model.Spell;

import java.util.List;

public interface SpellDao {
    List<Spell> listSpells(int id);

    List<Spell> getCantrip(int id);

    List<Spell> availiableSpells(int id);

    List<Spell> availableCantrips(int id);

    Spell getSpell(int id);


    void deleteSpell(int id);

    Spell createSpell(Spell spell);

    void changeUsable(int id);

    void changeAvailable(int id);

    void longRestSpells(int id);




}
