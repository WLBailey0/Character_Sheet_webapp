
drop table if exists spells cascade;
drop table if exists person cascade;
drop table if exists backpack cascade;
drop table if exists weapons cascade;


begin transaction;
create table person
(
        char_id serial unique,
        person_id int,
        name varchar(64) not null,
        health int,
        base_health int,
        initiative int,
        speed int,
        hit_dice varchar(64),
        armor_class int,
        proficiency int,
        char_class varchar(64),
        level int,
        
        --constraint pk_char_id primary key (char_id),
        constraint pk_person_id primary key (person_id),
        constraint fk_person_id foreign key (person_id) references users (user_id)
);
create table spells
(
        spell_id serial,
        char_id int,
        spell_class varchar(255),
        spell_name varchar(255),
        spell_level int,
        spell_dice varchar(255),
        spell_text text,
        is_cantrip boolean,
        is_usable boolean,
        is_available boolean,
            
        constraint pk_spell_id primary key (spell_id),
        constraint fk_char_user foreign key (char_id) references person (person_id)
);
create table backpack
(
        backpack_id serial,
        char_id int,
        contents text,
        
        constraint pk_bp_id primary key (backpack_id),
        constraint fk_char_bp foreign key (char_id) references person (person_id)
);
create table weapons
(
        weapon_id serial,
        char_id int,
        hit_dice varchar(64),
        hands int,
        
        constraint pk_weap_id primary key (weapon_id),
        constraint fk_char_weap foreign key (char_id) references person (person_id)
);


        
commit transaction;

--insert into spells (spell_name, spell_dice, spell_amount, is_cantrip)
--values('Fire Bolt', '2d10', 3, true);
        
        
