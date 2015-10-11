/*
Created		10. 10. 2015
Modified		10. 10. 2015
Project		
Model		
Company		
Author		
Version		
Database		Oracle 10g 
*/


-- Create Types section


-- Create Tables section


Create table katastralny_urad (
	id_uradu Number NOT NULL ,
primary key (id_uradu) 
) 
/

insert into KATASTRALNY_URAD (ID_URADU)
values (1);
/

Create table katastralne_uzemie (
	id_katastralny_urad Number NOT NULL ,
	id_uradu Number NOT NULL ,
	nazov_katastralneho_uzemia Varchar2 (30) NOT NULL  UNIQUE ,
primary key (id_katastralny_urad,id_uradu) 
) 
/

insert into KATASTRALNE_UZEMIE (ID_KATASTRALNY_URAD,ID_URADU,nazov_katastralneho_uzemia)
values(1,1,'Mala Bytca');

Create table nehnutelnost (
	id_supisne_cislo Number NOT NULL ,
	id_list_vlastnictva Number NOT NULL ,
	id_katastralny_urad Number NOT NULL ,
	id_uradu Number NOT NULL ,
	adresa Varchar2 (30),
primary key (id_supisne_cislo,id_list_vlastnictva) 
) 
/


insert into NEHNUTELNOST (ID_SUPISNE_CISLO,ID_LIST_VLASTNICTVA,id_katastralny_urad,
id_uradu, adresa)
values (1,1,1,1,'mala bytca 225');
/

Create table osoba (
	rodne_cislo Number NOT NULL ,
	meno_priezvisko Varchar2 (30),
	trvaly_pobyt Varchar2 (30),
primary key (rodne_cislo) 
) 
/
insert into osoba (MENO_PRIEZVISKO,trvaly_pobyt,rodne_cislo)
values ('Martin Malobicky','psurnovice 165','1111');/
insert into osoba (MENO_PRIEZVISKO,trvaly_pobyt,rodne_cislo)
values ('Erik Malobicky','psurnovice 165','1112');/
insert into osoba (MENO_PRIEZVISKO,trvaly_pobyt,rodne_cislo)
values ('Alica Malobicky','mala bytca 225','1113');/
insert into osoba (MENO_PRIEZVISKO,trvaly_pobyt,rodne_cislo)
values ('Jaroslav Malobicky','mala bytca 225','1114');/


Create table list_vlastnictva (
	id_list_vlastnictva Number NOT NULL ,
primary key (id_list_vlastnictva) 
) 
/

insert into LIST_VLASTNICTVA (ID_LIST_VLASTNICTVA)
values (1);

Create table podielnik_listu_vlastnictva (
	id_list_vlastnictva Number NOT NULL ,
	rodne_cislo Number NOT NULL ,
primary key (id_list_vlastnictva,rodne_cislo) 
) 
/

--drop table podielnik_listu_vlastnictva;


insert into podielnik_listu_vlastnictva (
id_list_vlastnictva ,
	rodne_cislo)
  values (1,'1111');/
insert into podielnik_listu_vlastnictva (
id_list_vlastnictva ,
	rodne_cislo)
  values (1,'1112');/
  insert into podielnik_listu_vlastnictva (
id_list_vlastnictva ,
	rodne_cislo)
  values (1,'1113');/
  insert into podielnik_listu_vlastnictva (
id_list_vlastnictva ,
	rodne_cislo)
  values (1,'1114');/

Create table podiel (
	id_podiel Varchar2 (30) NOT NULL ,
	rodne_cislo Number NOT NULL ,
	id_supisne_cislo Number NOT NULL ,
	id_list_vlastnictva Number NOT NULL ,
	velkost_podielu Float,
primary key (id_podiel,rodne_cislo) 
) 
/

insert into podiel(id_podiel,rodne_cislo,id_supisne_cislo,id_list_vlastnictva,velkost_podielu)
values (1,'1111',1,1,5);/

insert into podiel(id_podiel,rodne_cislo,id_supisne_cislo,id_list_vlastnictva,velkost_podielu)
values (2,'1112',1,1,5);/


-- Create Foreign keys section

Alter table katastralne_uzemie add  foreign key (id_uradu) references katastralny_urad (id_uradu) 
/

Alter table nehnutelnost add  foreign key (id_katastralny_urad,id_uradu) references katastralne_uzemie (id_katastralny_urad,id_uradu) 
/

Alter table podiel add  foreign key (id_supisne_cislo,id_list_vlastnictva) references nehnutelnost (id_supisne_cislo,id_list_vlastnictva) 
/

Alter table podielnik_listu_vlastnictva add  foreign key (rodne_cislo) references osoba (rodne_cislo) 
/

Alter table podiel add  foreign key (rodne_cislo) references osoba (rodne_cislo) 
/

Alter table nehnutelnost add  foreign key (id_list_vlastnictva) references list_vlastnictva (id_list_vlastnictva) 
/

Alter table podielnik_listu_vlastnictva add  foreign key (id_list_vlastnictva) references list_vlastnictva (id_list_vlastnictva) 
/


--selecty

select * from osoba;

/
select distinct podiel.id_list_vlastnictva, podiel.id_supisne_cislo, meno_priezvisko, velkost_podielu
from list_vlastnictva
join nehnutelnost using (id_list_vlastnictva)
join podielnik_listu_vlastnictva using(id_list_vlastnictva)
join osoba using(rodne_cislo)
join podiel using (rodne_cislo);


/
select meno_priezvisko, velkost_podielu
from osoba
join podiel using(rodne_cislo);



--        1. Vyh¾adanie nehnute¾nosti pod¾a súpisného èísla a èísla katastrálneho územia.
--        Po nájdení nehnute¾nosti je potrebné zobrazi všetky evidované údaje vrátane všetkıch
--        údajov z listu vlastníctva na ktorom je nehnute¾nos zapísaná.
select id_supisne_cislo, adresa, id_list_vlastnictva
from nehnutelnost
where id_supisne_cislo = 1;

--        2. Vyh¾adanie obyvate¾a pod¾a rodného èísla a vıpis jeho trvalého pobytu (vypíšu sa
--        všetky informácie o nehnute¾nosti, ktorú obıva)
select meno_priezvisko, trvaly_pobyt
from osoba
where rodne_cislo = '1111';

--        3. Vıpis všetkıch osôb, ktoré majú trvalı pobyt v zadanej nehnute¾nosti (zadá sa èíslo
--        katastrálneho územia, èíslo listu vlastníctva a súpisné èíslo)
select meno_priezvisko, trvaly_pobyt,adresa, id_supisne_cislo
from osoba
join PODIELNIK_LISTU_VLASTNICTVA using (rodne_cislo)
join LIST_VLASTNICTVA using (id_list_vlastnictva)
join NEHNUTELNOST using (id_list_vlastnictva)
join KATASTRALNE_UZEMIE using (id_katastralne_uzemie)
where id_katastralne_uzemie = 1
and id_list_vlastnictva = 1
and id_supisne_cislo = 1
and trvaly_pobyt = adresa;

--alter table katastralne_uzemie
--rename column id_katastralny_urad to id_katastralne_uzemie;
--alter table nehnutelnost
--rename column id_katastralny_urad to id_katastralne_uzemie;
--        4. Vyh¾adanie listu vlastníctva pod¾a jeho èísla a èísla katastrálneho územia. Po nájdení
--        listu vlastníctva je potrebné zobrazi všetky evidované údaje vrátane všetkıch údajov
--        o majite¾och nehnute¾ností zapísanıch na liste vlastníctva (mená, priezviská, majetkové
--        podiely...).



select meno_priezvisko, id_supisne_cislo, adresa, velkost_podielu
from podiel
join osoba using (rodne_cislo)
join NEHNUTELNOST using (id_supisne_cislo)
join PODIELNIK_LISTU_VLASTNICTVA using(rodne_cislo)
join LIST_VLASTNICTVA using(id_list_vlastnictva)
where id_list_vlastnictva = 1
;


--        5. Vyh¾adanie nehnute¾nosti pod¾a súpisného èísla a názvu katastrálneho územia.
--        Po nájdení nehnute¾nosti je potrebné zobrazi všetky evidované údaje vrátane všetkıch
--        údajov z listu vlastníctva na ktorom je nehnute¾nos zapísaná.

select ID_SUPISNE_CISLO, NAZOV_KATASTRALNEHO_UZEMIA, nehnutelnost.ID_LIST_VLASTNICTVA
from nehnutelnost
join katastralne_uzemie using(id_katastralne_uzemie)
where id_list_vlastnictva = 1;
--        6. Vyh¾adanie listu vlastníctva pod¾a jeho èísla a názvu katastrálneho územia. Po nájdení
--        listu vlastníctva je potrebné zobrazi všetky evidované údaje vrátane všetkıch údajov
--        o majite¾och nehnute¾ností zapísanıch na liste vlastníctva (mená, priezviská, majetkové
--        podiely...).

select podiel.id_list_vlastnictva, nazov_katastralneho_uzemia
from list_vlastnictva
join nehnutelnost using(id_list_vlastnictva)
join katastralne_uzemie using(ID_KATASTRALNE_UZEMIE)
join podielnik_listu_vlastnictva using (id_list_vlastnictva)
join osoba using (rodne_cislo)
join podiel using (rodne_cislo)
where katastralne_uzemie.NAZOV_KATASTRALNEHO_UZEMIA = 'Mala Bytca'
and podiel.id_list_vlastnictva = 1;
--        7. Vıpis nehnute¾ností v zadanom katastrálnom území (definované názvom) utriedenıch
--        pod¾a ich súpisnıch èísel aj s ich popisom.
select id_supisne_cislo, nazov_katastralneho_uzemia, adresa
from katastralne_uzemie
join nehnutelnost using (ID_KATASTRALNE_UZEMIE)
where katastralne_uzemie.NAZOV_KATASTRALNEHO_UZEMIA = 'Mala Bytca';
--        8. Vıpis všetkıch nehnute¾ností majite¾a (definovanı rodnım èíslom) v zadanom
--        katastrálnom území (definované jeho èíslom).
--        9. Vıpis všetkıch nehnute¾ností majite¾a (definovanı rodnım èíslom).
--        10. Zmena trvalého pobytu obyvate¾a (definovanı rodnım èíslom) do nehnute¾nosti
--        (definovaná súpisnım èíslom) v zadanom katastrálnom území (definované jeho
--        názvom).
--        11. Zmena majite¾a (definovanı rodnım èíslom) nehnute¾nosti (definovaná súpisnım
--        èíslom) v zadanom katastrálnom území (definované jeho èíslom). Novı majite¾ je
--        definovanı rodnım èíslom.
--        12. Zapísanie majetkového podielu majite¾a (definovanı rodnım èíslom) na list vlastníctva
--        (definovanı èíslom) v zadanom katastrálnom území (definované jeho èíslom)
--        13. Odstránenie majetkového podielu majite¾a (definovanı rodnım èíslom) z listu
--        vlastníctva (definovanı èíslom) v zadanom katastrálnom území (definované jeho
--        èíslom).
--        14. Vıpis všetkıch katastrálnych území utriedenıch pod¾a ich názvov.
--        15. Pridanie obèana.
--        16. Pridanie listu vlastníctva.
--        17. Pridanie nehnute¾nosti na list vlastníctva (definovanı èíslom) v zadanom katastrálnom
--        území (definované jeho èíslom).
--        18. Odstránenie obèana (definovanı rodnım èíslom).
--        19. Odstránenie listu vlastníctva (definovanı èíslom) v zadanom katastrálnom území
--        (definované jeho èíslom). Nehnute¾nosti sa presunú na inı list vlastníctva.
--        20. Odstránenie nehnute¾nosti (definovaná popisnım èíslom) z listu vlastníctva (definovanı
--        èíslom) v zadanom katastrálnom území (definované jeho èíslom).
--        21. Pridanie katastrálneho územia.
--        22. Odstránenie katastrálneho územia (definované jeho èíslom). Agenda sa presunie do
--        iného katastrálneho územia.


