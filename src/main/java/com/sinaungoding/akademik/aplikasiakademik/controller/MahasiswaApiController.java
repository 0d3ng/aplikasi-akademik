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

package com.sinaungoding.akademik.aplikasiakademik.controller;

import com.sinaungoding.akademik.aplikasiakademik.controller.exception.InternalServerErrorException;
import com.sinaungoding.akademik.aplikasiakademik.dao.MahasiswaDao;
import com.sinaungoding.akademik.aplikasiakademik.entity.Mahasiswa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class MahasiswaApiController {

    @Autowired
    private MahasiswaDao mahasiswaDao;

    @GetMapping("/api/mahasiswa")
    @ResponseBody
    public Page<Mahasiswa> getAll(Pageable page) {
        return mahasiswaDao.findAll(page);
    }

    @GetMapping("/api/mahasiswaNama")
    @ResponseBody
    public Page<Mahasiswa> getAllByNama(@RequestParam(name = "nama") String nama, Pageable pageable) {
        return mahasiswaDao.getMahasiswaByNamaContaining(nama, pageable);
    }

    @GetMapping("/api/mahasiswa/{id}")
    @ResponseBody
    public Mahasiswa getById(@PathVariable(name = "id") Mahasiswa mahasiswa) {
        return mahasiswa;
    }

    @PostMapping("/api/mahasiswa")
    @ResponseStatus(HttpStatus.CREATED)
    public Mahasiswa insert(@RequestBody @Valid Mahasiswa mahasiswa) {
        try {
            return mahasiswaDao.save(mahasiswa);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PutMapping("/api/mahasiswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mahasiswa update(@RequestBody @Valid Mahasiswa mahasiswa) {
        try {
            return mahasiswaDao.save(mahasiswa);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DeleteMapping("/api/mahasiswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Mahasiswa mahasiswa) {
        try {
            mahasiswaDao.delete(mahasiswa);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
