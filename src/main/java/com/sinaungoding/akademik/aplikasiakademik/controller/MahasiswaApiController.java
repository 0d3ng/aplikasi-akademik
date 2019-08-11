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

import com.sinaungoding.akademik.aplikasiakademik.dao.MahasiswaDao;
import com.sinaungoding.akademik.aplikasiakademik.entity.Mahasiswa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class MahasiswaApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaApiController.class.getName());

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
    public ResponseEntity<String> insert(@RequestBody @Valid Mahasiswa mahasiswa) {
        try {
            mahasiswaDao.save(mahasiswa);
            return new ResponseEntity<>("Mahasiswa berhasil ditambahkan", HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.info("DataAccessException");
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/api/mahasiswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody @Valid Mahasiswa mahasiswa) {
        Mahasiswa mhs = mahasiswaDao.findById("id").get();
        if (mhs == null) {
            LOGGER.warn("Mahasiswa id {} tidak ditemukan", id);
            return;
        }
        BeanUtils.copyProperties(mahasiswa, mhs);
        mahasiswaDao.save(mhs);
    }

    @DeleteMapping("/api/mahasiswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            mahasiswaDao.delete(mahasiswa);
        }
    }
}
