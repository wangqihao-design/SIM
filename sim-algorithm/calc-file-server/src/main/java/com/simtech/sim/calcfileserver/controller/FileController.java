package com.simtech.sim.calcfileserver.controller;


import com.simtech.sim.calcfileserver.util.MinioUtils;
import com.simtech.sim.calcfileserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/fileServer")
public class FileController {

    @Autowired
    private MinioUtils minioUtils;


    @RequestMapping("/uploadFile/{fileCategory}")
    public Result<String> uploadFile(@RequestBody MultipartFile file, @PathVariable String fileCategory) throws Exception {
        minioUtils.uploadFile(file, fileCategory);

        return new Result<String>().ok(file.getName());
    }

    @RequestMapping("/getFile")
    public InputStream getFile(@RequestParam String instanceId, @RequestParam String algorithmType){
        return minioUtils.getObject(algorithmType, instanceId);
    }

}
