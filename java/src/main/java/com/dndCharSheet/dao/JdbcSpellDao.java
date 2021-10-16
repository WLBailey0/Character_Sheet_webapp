package com.dndCharSheet.dao;

import com.dndCharSheet.model.Spell;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcSpellDao implements SpellDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcSpellDao(DataSource datasource){
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Spell> listSpells(int id) {
        List<Spell> spells = new ArrayList<>();
        String sql = "select * from spells where char_id = ? and is_cantrip = false";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()){
            spells.add(mapSpellToRow(results));
        }
        return spells;
    }

    public Spell getSpell(int id){
        Spell spell = new Spell();
        String sql = "select * from spells where spell_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            spell = mapSpellToRow(results);
        }
        return spell;
    }
    public void updateSpellAmount(Spell spell){
        String sql = "update spells set spell_amount = ? where spell_id = ?";
        jdbcTemplate.update(sql, spell.getSpellAmount(), spell.getSpellId());
    }

    @Override
    public void deleteSpell(int id) {
        String sql = "delete from spells where spell_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Spell createSpell(Spell spell) {
        String sql = "insert into spells(char_id, spell_name, spell_level, spell_dice, is_cantrip, is_usable) " +
                "values(?,?,?,?,?,?) returning spell_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class,spell.getCharId(), spell.getSpellName(), spell.getSpellLevel(), spell.getSpellDice(), spell.isCantrip(), spell.isUsable());

        return getSpell(id);
    }

    @Override
    public List<Spell> getCantrip(int id) {
        List<Spell> cantrips = new ArrayList<>();
        String sql = "Select * from spells where char_id = ? and is_cantrip = true";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        while(result.next()){
            cantrips.add(mapSpellToRow(result));
        }
        return cantrips;
    }

    @Override
    public void changeUsable(int id) {
        Spell spell = getSpell(id);

        String sql = "update spells set is_usable = ? where spell_id = ?";
        jdbcTemplate.update(sql, spell.isUsable()? false : true,  id);
    }

    private Spell mapSpellToRow(SqlRowSet results) {
        Spell spell = new Spell();
        spell.setSpellId(results.getInt("spell_id"));
        spell.setCharId(results.getInt("char_id"));
        spell.setSpellName(results.getString("spell_name"));
        spell.setSpellLevel(results.getInt("spell_level"));
        spell.setSpellAmount(results.getInt("spell_amount"));
        spell.setSpellDice(results.getString("spell_dice"));
        spell.setCantrip(results.getBoolean("is_cantrip"));
        spell.setUsable(results.getBoolean("is_usable"));
        return spell;
    }
}