package com.simtech.sim.mine.service.impl;

import com.simtech.sim.mine.entity.basic.MineEntity;
import com.simtech.sim.mine.repo.MineRepository;
import com.simtech.sim.mine.service.PurchaseMine;
import com.simtech.sim.mine.service.impl.timed.GenerateMine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
public class PurchaseMineImpl implements PurchaseMine {

    @Autowired
    private MineRepository mineRepository;

    @Override
    @Transactional
    public void buyMine(MineEntity mineEntity){
        GenerateMine generateMine = new GenerateMine();
        System.out.println(generateMine.getMineInfo());

        Set<MineEntity> MineSet = generateMine.getMineInfo();

        if(MineSet.contains(mineEntity)){
            MineSet.remove(mineEntity);
            mineRepository.save(mineEntity);

            // TODO 请求扣钱
        }
        else{
            System.out.println("No such Mine");
        }


    }



}
