package com.simtech.sim.dataproxy;


import com.simtech.sim.dataproxy.entity.JobInfoEntity;
import com.simtech.sim.dataproxy.service.db.impl.MineStorageImpl;
import com.simtech.sim.dataproxy.service.sender.SenderProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

public class SimDataproxyApplicationTests {


    @Autowired
    private SenderProxy<JobInfoEntity> sender;

    @Autowired
    private MineStorageImpl productStorage;

    @Test
    public void test2(){
        productStorage.getById("m1");
    }

    @Test

    public void test() throws Exception {

        for(int i=0; i < 3; i++) {
            JobInfoEntity job = new JobInfoEntity();

            job.setPeriod("0/20 * * ? * *");
            job.setGroup("test");
            job.setTeamId("1");


            sender.messageSender(job);
        }
    }

}
