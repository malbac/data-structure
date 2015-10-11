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



--        1. Vyh�adanie nehnute�nosti pod�a s�pisn�ho ��sla a ��sla katastr�lneho �zemia.
--        Po n�jden� nehnute�nosti je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch
--        �dajov z listu vlastn�ctva na ktorom je nehnute�nos� zap�san�.
select id_supisne_cislo, adresa, id_list_vlastnictva
from nehnutelnost
where id_supisne_cislo = 1;

--        2. Vyh�adanie obyvate�a pod�a rodn�ho ��sla a v�pis jeho trval�ho pobytu (vyp�u sa
--        v�etky inform�cie o nehnute�nosti, ktor� ob�va)
select meno_priezvisko, trvaly_pobyt
from osoba
where rodne_cislo = '1111';

--        3. V�pis v�etk�ch os�b, ktor� maj� trval� pobyt v zadanej nehnute�nosti (zad� sa ��slo
--        katastr�lneho �zemia, ��slo listu vlastn�ctva a s�pisn� ��slo)
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
--        4. Vyh�adanie listu vlastn�ctva pod�a jeho ��sla a ��sla katastr�lneho �zemia. Po n�jden�
--        listu vlastn�ctva je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch �dajov
--        o majite�och nehnute�nost� zap�san�ch na liste vlastn�ctva (men�, priezvisk�, majetkov�
--        podiely...).



select meno_priezvisko, id_supisne_cislo, adresa, velkost_podielu
from podiel
join osoba using (rodne_cislo)
join NEHNUTELNOST using (id_supisne_cislo)
join PODIELNIK_LISTU_VLASTNICTVA using(rodne_cislo)
join LIST_VLASTNICTVA using(id_list_vlastnictva)
where id_list_vlastnictva = 1
;


--        5. Vyh�adanie nehnute�nosti pod�a s�pisn�ho ��sla a n�zvu katastr�lneho �zemia.
--        Po n�jden� nehnute�nosti je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch
--        �dajov z listu vlastn�ctva na ktorom je nehnute�nos� zap�san�.

select ID_SUPISNE_CISLO, NAZOV_KATASTRALNEHO_UZEMIA, nehnutelnost.ID_LIST_VLASTNICTVA
from nehnutelnost
join katastralne_uzemie using(id_katastralne_uzemie)
where id_list_vlastnictva = 1;
--        6. Vyh�adanie listu vlastn�ctva pod�a jeho ��sla a n�zvu katastr�lneho �zemia. Po n�jden�
--        listu vlastn�ctva je potrebn� zobrazi� v�etky evidovan� �daje vr�tane v�etk�ch �dajov
--        o majite�och nehnute�nost� zap�san�ch na liste vlastn�ctva (men�, priezvisk�, majetkov�
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
--        7. V�pis nehnute�nost� v zadanom katastr�lnom �zem� (definovan� n�zvom) utrieden�ch
--        pod�a ich s�pisn�ch ��sel aj s ich popisom.
select id_supisne_cislo, nazov_katastralneho_uzemia, adresa
from katastralne_uzemie
join nehnutelnost using (ID_KATASTRALNE_UZEMIE)
where katastralne_uzemie.NAZOV_KATASTRALNEHO_UZEMIA = 'Mala Bytca';
--        8. V�pis v�etk�ch nehnute�nost� majite�a (definovan� rodn�m ��slom) v zadanom
--        katastr�lnom �zem� (definovan� jeho ��slom).
--        9. V�pis v�etk�ch nehnute�nost� majite�a (definovan� rodn�m ��slom).
--        10. Zmena trval�ho pobytu obyvate�a (definovan� rodn�m ��slom) do nehnute�nosti
--        (definovan� s�pisn�m ��slom) v zadanom katastr�lnom �zem� (definovan� jeho
--        n�zvom).
--        11. Zmena majite�a (definovan� rodn�m ��slom) nehnute�nosti (definovan� s�pisn�m
--        ��slom) v zadanom katastr�lnom �zem� (definovan� jeho ��slom). Nov� majite� je
--        definovan� rodn�m ��slom.
--        12. Zap�sanie majetkov�ho podielu majite�a (definovan� rodn�m ��slom) na list vlastn�ctva
--        (definovan� ��slom) v zadanom katastr�lnom �zem� (definovan� jeho ��slom)
--        13. Odstr�nenie majetkov�ho podielu majite�a (definovan� rodn�m ��slom) z listu
--        vlastn�ctva (definovan� ��slom) v zadanom katastr�lnom �zem� (definovan� jeho
--        ��slom).
--        14. V�pis v�etk�ch katastr�lnych �zem� utrieden�ch pod�a ich n�zvov.
--        15. Pridanie ob�ana.
--        16. Pridanie listu vlastn�ctva.
--        17. Pridanie nehnute�nosti na list vlastn�ctva (definovan� ��slom) v zadanom katastr�lnom
--        �zem� (definovan� jeho ��slom).
--        18. Odstr�nenie ob�ana (definovan� rodn�m ��slom).
--        19. Odstr�nenie listu vlastn�ctva (definovan� ��slom) v zadanom katastr�lnom �zem�
--        (definovan� jeho ��slom). Nehnute�nosti sa presun� na in� list vlastn�ctva.
--        20. Odstr�nenie nehnute�nosti (definovan� popisn�m ��slom) z listu vlastn�ctva (definovan�
--        ��slom) v zadanom katastr�lnom �zem� (definovan� jeho ��slom).
--        21. Pridanie katastr�lneho �zemia.
--        22. Odstr�nenie katastr�lneho �zemia (definovan� jeho ��slom). Agenda sa presunie do
--        in�ho katastr�lneho �zemia.


