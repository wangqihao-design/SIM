package com.simtech.sim.calcfileserver.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Service
public class FileReader {
    

    private final String defaultRoute = "src/main/resources/algorithm_files/";

    public String getFile(String FileInstance) throws IOException{

        BufferedReader reader = new BufferedReader(new java.io.FileReader((defaultRoute + FileInstance)));
        String line = reader.readLine();

        System.out.println(line);
        return line;

    }





}
