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


Create table "Urad" (
	"id_uradu" Varchar2 (30) NOT NULL ,
primary key ("id_uradu") 
) 
/

Create table "katastralne_uzemie" (
	"id_katastralny_urad" Varchar2 (30) NOT NULL ,
	"id_uradu" Varchar2 (30) NOT NULL ,
	"nazov_katastralneho_uzemia" Varchar2 (30) NOT NULL  UNIQUE ,
primary key ("id_katastralny_urad","id_uradu") 
) 
/

Create table "nehnutelnost" (
	"id_supisne_cislo" Varchar2 (30) NOT NULL ,
	"id_list_vlastnictva" Varchar2 (30) NOT NULL ,
	"id_katastralny_urad" Varchar2 (30) NOT NULL ,
	"id_uradu" Varchar2 (30) NOT NULL ,
	"adresa" Varchar2 (30),
primary key ("id_supisne_cislo","id_list_vlastnictva") 
) 
/

Create table "osoba" (
	"id_osoby" Varchar2 (30) NOT NULL ,
	"meno_priezvisko" Varchar2 (30),
	"trvaly_pobyt" Varchar2 (30),
	"rodne_cislo" Varchar2 (30),
primary key ("id_osoby") 
) 
/

Create table "list_vlastnictva" (
	"id_list_vlastnictva" Varchar2 (30) NOT NULL ,
	"katastralne_uzemie" Varchar2 (30) NOT NULL ,
primary key ("id_list_vlastnictva") 
) 
/

Create table "podielnik_listu_vlastnictva" (
	"id_podielnik" Varchar2 (30) NOT NULL ,
	"id_list_vlastnictva" Varchar2 (30) NOT NULL ,
	"id_osoby" Varchar2 (30) NOT NULL ,
primary key ("id_podielnik","id_list_vlastnictva","id_osoby") 
) 
/

Create table "podiel" (
	"id_podiel" Varchar2 (30) NOT NULL ,
	"id_osoby" Varchar2 (30) NOT NULL ,
	"id_supisne_cislo" Varchar2 (30) NOT NULL ,
	"id_list_vlastnictva" Varchar2 (30) NOT NULL ,
	"velkost_podielu" Varchar2 (30),
primary key ("id_podiel","id_osoby") 
) 
/


-- Create Object Tables section


-- Create XMLType Tables section


-- Create Functions section


-- Create Sequences section


-- Create Packages section


-- Create Synonyms section


-- Create Table comments section


-- Create Attribute comments section


