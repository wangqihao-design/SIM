package com.simtech.sim.technology.controller;


import com.simtech.sim.common.utils.Result;
import com.simtech.sim.technology.entity.ComponentEntity;
import com.simtech.sim.technology.entity.ProductEntity;
import com.simtech.sim.technology.service.impl.RecipeCreateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/researchCenter")
public class ResearchCenterController {

    @RequestMapping("/requestNew")
    public Result<ProductEntity> requestNewRecipe(ProductEntity productEntity){

        return new Result<ProductEntity>().ok(productEntity);
    }

    @Autowired
    private RecipeCreateImpl recipeCreate;

    @RequestMapping("/test")
    public void test() throws Exception {

        ComponentEntity component = new ComponentEntity();
        component.setA(1);
        component.setB(3);
        component.setC(6);
        recipeCreate.recipePreview(component);
    }

}

