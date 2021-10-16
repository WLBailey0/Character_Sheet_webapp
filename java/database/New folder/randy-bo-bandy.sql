begin transaction;

insert into person (person_id, name, spell_slots, health, initiative, speed, hit_dice, armor_class, proficiency, char_class, level)
values(1, 'Randy Bo-Bandy', 12, 47, 2, 25, '7d6', 13, 3, 'Wizard', 7);

insert into spells(char_id, spell_name, spell_level, spell_dice, spell_amount, is_cantrip, is_usable)
        values(1, 'Magic Missile', 1, '3d4', 1, false, true);
insert into spells(char_id, spell_name, spell_level, spell_dice, spell_amount, is_cantrip, is_usable)
        values(1, 'Fire Bolt', 1, '1d10', 1, true, true);
commit transaction;
