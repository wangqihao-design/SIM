package com.simtech.sim.technology;

import com.simtech.sim.technology.entity.ComponentEntity;
import com.simtech.sim.technology.service.impl.RecipeCreateImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimTechnologyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RecipeCreateImpl recipeCreate;

    @Test
    void test() throws Exception {
        ComponentEntity component = new ComponentEntity();
        component.setA(1);
        component.setB(3);
        component.setC(6);
        recipeCreate.recipePreview(component);
    }
}
