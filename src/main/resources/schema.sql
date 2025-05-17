CREATE TABLE Felhasznalok (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    kereszt_nev VARCHAR(255),
    vezetek_nev VARCHAR(255),
    email VARCHAR(255),
    eletkor INTEGER,
    test_suly INTEGER
);

CREATE TABLE Futas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    felhasznalo_id BIGINT,
    futas_cim VARCHAR(255),
    futas_kezd TIMESTAMP,
    futas_veg TIMESTAMP,
    kilometer DOUBLE,
    helye VARCHAR(255),
    CONSTRAINT fk_futas_felhasznalo FOREIGN KEY (felhasznalo_id) REFERENCES Felhasznalok(id)
);

CREATE TABLE Kaloria_Bevitel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    felhasznalo_id BIGINT,
    zsir INTEGER,
    szenhidrat INTEGER,
    feherje INTEGER,
    viz INTEGER,
    CONSTRAINT fk_kaloria_felhasznalo FOREIGN KEY (felhasznalo_id) REFERENCES Felhasznalok(id)
);

CREATE TABLE Suly_Emeles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    felhasznalo_id BIGINT,
    suly INTEGER,
    szettek INTEGER,
    repek INTEGER,
    tipusa VARCHAR(255),
    CONSTRAINT fk_suly_felhasznalo FOREIGN KEY (felhasznalo_id) REFERENCES Felhasznalok(id)
);
