/*
 * aplikasi-akademik
 *
 * Copyright (c) 2021
 * All rights reserved
 * Written by od3ng created on 11/7/21, 1:58 AM
 * Blog    : sinaungoding.com
 * Email   : noprianto@sinaungoding.com,lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */

CREATE TABLE mahasiswa(
nim  VARCHAR(10) NOT NULL,
nama VARCHAR(50) NOT NULL,
ipk  FLOAT(4, 2) NOT NULL,
jurusan VARCHAR(25) NOT NULL,
PRIMARY KEY(nim)
);