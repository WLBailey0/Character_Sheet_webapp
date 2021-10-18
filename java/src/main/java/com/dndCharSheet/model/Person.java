package com.dndCharSheet.model;

public class Person {
    private int charId; // serial character id
    private int userId; // person_id
    private String name;
    private int health;
    private int baseHealth;
    private int inititave;
    private int speed;
    private String hitDice;
    private int armorClass;
    private int proficiency;
    private String charClass;
    private int level;

    public Person() {
    }

    public Person(int charId, int userId, String name, int health, int baseHealth, int inititave,
                  int speed, String hitDice, int armorClass, int proficiency, String charClass, int level) {
        this.charId = charId;
        this.userId = userId;
        this.name = name;
        this.health = health;
        this.baseHealth = baseHealth;
        this.inititave = inititave;
        this.speed = speed;
        this.hitDice = hitDice;
        this.armorClass = armorClass;
        this.proficiency = proficiency;
        this.charClass = charClass;
        this.level = level;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getInititave() {
        return inititave;
    }

    public void setInititave(int inititave) {
        this.inititave = inititave;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
