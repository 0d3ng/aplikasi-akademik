/*
 * aplikasi-akademik
 *
 * Copyright (c) 2019
 * All rights reserved
 * Written by od3ng created on 7/26/19 9:55 AM
 * Blog    : sinaungoding.com
 * Email   : noprianto@sinaungoding.com,lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */

package com.sinaungoding.akademik.aplikasiakademik.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Mahasiswa {
    @Id
    private String nim;
    @NotNull
    @NotEmpty
    private String nama;
    @NotNull
    @NotEmpty
    private String jurusan;
    @NotNull
    private float ipk;
}
