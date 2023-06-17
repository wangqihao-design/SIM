package com.simtech.sim.mine.entity.basic;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class MineEntity {


    private MineEntity(String name, SourceEntity source){
        this.id = java.util.UUID.randomUUID().toString(); // 自动生成唯一id
        this.name = name;
        this.source = source;
    }


    public static MineEntity CreateNewMine(String name, SourceEntity source){

        return new MineEntity(name, source);
    }

    @Id
    private String id;

    private String name;

    private SourceEntity source;
}