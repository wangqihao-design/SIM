package com.simtech.sim.mine.entity.basic;


import lombok.Data;

import java.util.random.RandomGenerator;

@Data
public class SourceEntity {

    private SourceEntity(int A, int B, int C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public static SourceEntity SourceFactory(int origin, int bound){
        RandomGenerator generator = RandomGenerator.getDefault();
        int A = generator.nextInt(origin, bound);
        int B = generator.nextInt(origin, bound);
        int C = generator.nextInt(origin, bound);
        return new SourceEntity(A, B ,C);
    }

    public static SourceEntity SourceFactory(int AOrigin, int ABound, int BOrigin, int BBound, int COrigin, int CBound){
        RandomGenerator generator = RandomGenerator.getDefault();
        int A = generator.nextInt(AOrigin, ABound);
        int B = generator.nextInt(BOrigin, BBound);
        int C = generator.nextInt(COrigin, CBound);
        return new SourceEntity(A, B ,C);
    }

    private int A;
    private int B;
    private int C;
}
