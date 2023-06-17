package com.simtech.sim.technology.service.impl;


import com.google.gson.Gson;
import com.simtech.sim.technology.entity.ComponentEntity;
import com.simtech.sim.technology.entity.ProductEntity;
import com.simtech.sim.technology.entity.param.ProductResponseEntity;
import com.simtech.sim.technology.entity.param.ResearchResponseEntity;
import com.simtech.sim.technology.service.QualityGrabber;
import com.simtech.sim.technology.util.DefaultMQMessageProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RecipeCreateImpl {

    @Autowired
    private QualityGrabber qualityGrabber;

    @Autowired
    private DefaultMQMessageProcess<ProductEntity, ProductResponseEntity> messageSender;


    /**
     * @param source
     * @return source + generated quality + generated production time
     */
    public ProductResponseEntity recipePreview(ComponentEntity source) throws Exception {
        ProductEntity product = new ProductEntity();
        product.setComponents(source);

        CompletableFuture<ProductResponseEntity> responseFuture = new CompletableFuture<>();

        messageSender.send(product, ProductResponseEntity.class, "algorithm.techRecipe", "recipe", responseFuture);

        ProductResponseEntity res = messageSender.getResponse();

        System.out.println(res);
        return res;
    }

    public void recipeCache(){
        // this method should store the commonly selected recipe in redis
    }

}
