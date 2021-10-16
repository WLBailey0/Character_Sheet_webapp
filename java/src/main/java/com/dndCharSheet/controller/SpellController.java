package com.dndCharSheet.controller;

import com.dndCharSheet.dao.SpellDao;
import com.dndCharSheet.model.Spell;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SpellController {

    private SpellDao spellDao;

    public SpellController(SpellDao spellDao){
        this.spellDao = spellDao;
    }
    @GetMapping("/spells/cantrip/{id}")
    public List<Spell> getCantrip(@PathVariable int id){
        return spellDao.getCantrip(id);
    }
    @GetMapping("/spells/{id}")
    public List<Spell> getSpells(@PathVariable int id){
        return spellDao.listSpells(id);
    }
    @PutMapping("/spells/usable/{id}")
    public void changeUsable(@RequestBody @PathVariable int id){
        spellDao.changeUsable(id);
    }
    @PostMapping("/spells/{id}")
    public Spell addSpell(@RequestBody Spell spell){
        return spellDao.createSpell(spell);
    }
    @DeleteMapping("/spells/delete/{id}")
    public void delete(@PathVariable int id){
        spellDao.deleteSpell(id);
    }
}
