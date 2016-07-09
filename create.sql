
Drop TABLE PRO.ROZRACHUNKI; 
CREATE TABLE PRO.ROZRACHUNKI (ID NUMBER(9) NOT NULL, DOKUMENT_ID NUMBER(9) NOT NULL, FIRMA_ID NUMBER(9) NOT NULL, DZIAL_ID NUMBER(9) NOT NULL, KONTRAHENT_ID NUMBER(9) NOT NULL, PLATNIK_ID NUMBER(9) NOT NULL, ADRESAT_ID NUMBER(9) NULL, CECHA NUMBER(2) NOT NULL, STAN NUMBER(2) NOT NULL, STATUS_ID NUMBER(9) NOT NULL, NUMER VARCHAR2(32) NULL, WN NUMBER(12,2) NULL, MA NUMBER(12,2) NULL, TERMIN DATE NULL,  PRIMARY KEY (ID));

Drop TABLE PRO.ROZRACHUNKI_STATUSY;
CREATE TABLE PRO.ROZRACHUNKI_STATUSY (ID NUMBER(9) NOT NULL, CECHA VARCHAR2(1) NOT NULL, LP NUMBER(2) NOT NULL, KOD VARCHAR2(2) NULL, NAZWA VARCHAR2(24) NULL, PRIMARY KEY (ID));

Select osoba from kart.histpodmiotu h group by osoba;

Select id_hist_podm, osoba from kart.histpodmiotu h where osoba =' ';

insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA", "LP", "KOD", "NAZWA") values(1, 'N', 1, 'W', 'W terminie');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(2, 'N', 2, 'P', 'Ponaglona');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(3, 'N', 3, 'P2', 'Ponownie ponaglona');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(4, 'N', 4, 'PS', 'Przed sadowa');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(5, 'N', 5, 'S', 'Sadowa');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(6, 'N', 6, 'E', 'Egzekucja');
insert into "PRO"."ROZRACHUNKI_STATUSY" ("ID", "CECHA","LP", "KOD", "NAZWA") values(7, 'N', 7, 'U', 'Ugoda');
