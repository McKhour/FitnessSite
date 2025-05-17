INSERT INTO felhasznalok (kereszt_nev, vezetek_nev, email, eletkor, test_suly)
VALUES ('Péter', 'Janklovics', 'janklovics@black.magic', 45, 109);

INSERT INTO futas (futas_cim, futas_kezd, futas_veg, helye, kilometer, felhasznalo_id)
VALUES ('Reggeli kocogas', '2024-05-17 6:30:00', '2024-05-17 7:00:00', 'KINT', 3.5, 1);

INSERT INTO kaloria_bevitel (zsir, szenhidrat, feherje, viz, felhasznalo_id)
VALUES (12, 132, 78, 125, 1);

INSERT INTO suly_emeles (suly, szettek, repek, tipusa, felhasznalo_id)
VALUES (100, 15, 20, 'KETKEZES', 1);
