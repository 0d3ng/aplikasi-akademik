/*
 * aplikasi-akademik
 *
 * Copyright (c) 2019
 * All rights reserved
 * Written by od3ng created on 8/11/19, 10:32 AM
 * Blog    : sinaungoding.com
 * Email   : noprianto@sinaungoding.com,lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */

package com.sinaungoding.akademik.aplikasiakademik;

import com.sinaungoding.akademik.aplikasiakademik.entity.Mahasiswa;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@Slf4j
public class MahasiswaControllerTest extends AplikasiAkademikApplicationTests {

    @Test
    public void insertTest() throws Exception {
        String uri = "/api/mahasiswa";
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setIpk(3F);
        mahasiswa.setNim("075410099");
        mahasiswa.setNama("Pak Slamet");
        mahasiswa.setJurusan("Teknik Informatika");


        String inputJson = super.mapToJson(mahasiswa);
        log.info(inputJson);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        log.info("" + status);
        log.info(mvcResult.getResponse().getContentAsString());
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Mahasiswa berhasil ditambahkan");
    }
}
