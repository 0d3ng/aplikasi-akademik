/*
 * aplikasi-akademik
 *
 * Copyright (c) 2021
 * All rights reserved
 * Written by od3ng created on 11/6/21, 11:51 PM
 * Blog    : sinaungoding.com
 * Email   : noprianto@sinaungoding.com,lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */

USE akademik;

CREATE TABLE mahasiswa
(
    nim  VARCHAR(10) NOT NULL,
    nama VARCHAR(50) NOT NULL,
    ipk  FLOAT(4, 2) NOT NULL,
    jurusan VARCHAR(25) NOT NULL,
    PRIMARY KEY(nim)
);

INSERT INTO mahasiswa VALUES ('075410099', 'Upin', 4.00, 'Teknologi Informasi');
INSERT INTO mahasiswa VALUES ('075410100', 'Ipin', 4.00, 'Pendidikan Bahasa Inggris');
INSERT INTO mahasiswa VALUES ('075410101', 'Ehsan', 3.99, 'Teknik Sipil');