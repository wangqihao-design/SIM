package com.simtech.sim.workingnodes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

@Data
public class CommonEntity implements Serializable {

    @Id
    private String id;

    private String name;

    public CommonEntity(){
        this.id = java.util.UUID.randomUUID().toString();
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (id == null) {
            id = java.util.UUID.randomUUID().toString();
        }
    }
}
