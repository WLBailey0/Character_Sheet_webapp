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
    @GetMapping("/spells/available/spells/{id}")
    public List<Spell> getAvailableSpells(@PathVariable int id){
        return spellDao.availiableSpells(id);
    }
    @GetMapping("/spells/available/cantrips/{id}")
    public List<Spell> getAvailableCantrip(@PathVariable int id){
        return spellDao.availableCantrips(id);
    }
    @PutMapping("/spells/usable/{id}")
    public void changeUsable(@RequestBody @PathVariable int id){
        spellDao.changeUsable(id);
    }
    @PutMapping("/spells/available/{id}")
    public void changeAvailable(@RequestBody @PathVariable int id){
        spellDao.changeAvailable(id);
    }
    @PostMapping("/spells/{id}")
    public Spell addSpell(@RequestBody Spell spell){
        return spellDao.createSpell(spell);
    }
    @DeleteMapping("/spells/delete/{id}")
    public void delete(@PathVariable int id){
        spellDao.deleteSpell(id);
    }
    @PutMapping("/spells/long-rest/{id}")
    public void spellLongRest(@RequestBody @PathVariable int id){
        spellDao.longRestSpells(id);
    }
}
