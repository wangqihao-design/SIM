package com.simtech.sim.technology.service.impl.algorithm;

import com.simtech.sim.technology.entity.ProductEntity;
import com.simtech.sim.technology.service.QualityGrabber;
import com.simtech.sim.technology.util.DefaultMQMessageProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QualityGrabberImpl implements QualityGrabber {

    @Autowired
    private DefaultMQMessageProcess defaultClient;


    public void getQuality(ProductEntity product){



    }
}
