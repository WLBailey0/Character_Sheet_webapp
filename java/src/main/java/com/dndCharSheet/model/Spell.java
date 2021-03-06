package com.dndCharSheet.model;

public class Spell {
    private int spellId;
    private int charId;
    private String spellName;
    private int spellLevel;
    private String spellDice;
    private String spellText;
    private boolean isCantrip;
    private boolean isUsable;
    private boolean isAvailable;


    public Spell(int spellId, int charId, String spellName,int spellLevel, String spellDice, String spellText, boolean isCantrip, boolean isUsable, boolean isAvailable) {
        this.spellId = spellId;
        this.charId = charId;
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.spellDice = spellDice;
        this.spellText = spellText;
        this.isCantrip = isCantrip;
        this.isUsable = isUsable;
    }

    public Spell() {

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public int getSpellId() {
        return spellId;
    }

    public void setSpellId(int spellId) {
        this.spellId = spellId;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellDice() {
        return spellDice;
    }

    public void setSpellDice(String spellDice) {
        this.spellDice = spellDice;
    }

    public String getSpellText() {
        return spellText;
    }

    public void setSpellText(String spellText) {
        this.spellText = spellText;
    }

    public boolean isCantrip() {
        return isCantrip;
    }

    public void setCantrip(boolean cantrip) {
        isCantrip = cantrip;
    }
}
