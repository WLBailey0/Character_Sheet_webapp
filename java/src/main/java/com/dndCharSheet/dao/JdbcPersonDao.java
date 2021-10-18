package com.dndCharSheet.dao;

import com.dndCharSheet.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcPersonDao implements PersonDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcPersonDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPersonList(int id) {
        List<Person> person = new ArrayList<>();
        String sql = "select * from person " +
                "join users on person.person_id = users.user_id " +
                "where user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            person.add(mapRowToPerson(results));
        }
        return person;
    }

    @Override
    public Person getCharacter(int id) {
        Person person = null;
        String sql = "select * from person where char_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            person = mapRowToPerson(result);
        }
        return person;
    }

    @Override
    public Person createPerson(Person person) {
        String sql = "insert into person(person_id, name, health, base_health, initiative, speed, hit_dice, " +
                "armor_class, proficiency, char_class, level) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, person.getUserId(), person.getName(),
                person.getHealth(), person.getHealth(), person.getInititave(), person.getSpeed(),
                person.getHitDice(), person.getArmorClass(), person.getProficiency(), person.getCharClass(),
                person.getLevel());
        return getCharacter(id);
    }

    @Override
    public void deletePerson(int id) {
        String sql = "delete from person where char_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void healthUp(int id) {
        Person person = getCharacter(id);
        String sql = "update person set health = ? where char_id = ?";
        jdbcTemplate.update(sql, person.getHealth() + 1, id);

    }

    @Override
    public void healthDown(int id) {
        Person person = getCharacter(id);
        String sql = "update person set health = ? where char_id = ?";
        jdbcTemplate.update(sql, person.getHealth() - 1, id);
    }

    public Person mapRowToPerson(SqlRowSet results) {
        Person person = new Person();
        person.setCharId(results.getInt("char_id"));
        person.setUserId(results.getInt("person_id"));
        person.setName(results.getString("name"));
        person.setHealth(results.getInt("health"));
        person.setBaseHealth(results.getInt("base_health"));
        person.setInititave(results.getInt("initiative"));
        person.setSpeed(results.getInt("speed"));
        person.setHitDice(results.getString("hit_dice"));
        person.setArmorClass(results.getInt("armor_class"));
        person.setProficiency(results.getInt("proficiency"));
        person.setCharClass(results.getString("char_class"));
        person.setLevel(results.getInt("level"));
        return person;
    }
}

