package com.simtech.sim.calcfileserver.controller;


import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import com.simtech.sim.calcfileserver.service.FileReader;
import org.apache.tomcat.util.buf.ByteBufferHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.ByteBufferDecoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileReader fileReader;

    @RequestMapping("/retrieveFile")
    public byte[] retrieve(@RequestParam String name) throws IOException {

        String fileContent = fileReader.getFile(name);

        byte[] encoded = Base64.getEncoder().encode(fileContent.getBytes(StandardCharsets.UTF_8));

        System.out.println(Arrays.toString(encoded));


        return null;
    }



}
