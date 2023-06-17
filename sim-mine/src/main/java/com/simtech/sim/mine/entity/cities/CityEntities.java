package com.simtech.sim.mine.entity.cities;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@TableName("mms_cities")

public class CityEntities {

    @Id
    private int id;
    private String name;
}
