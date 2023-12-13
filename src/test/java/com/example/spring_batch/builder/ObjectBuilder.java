package com.example.spring_batch.builder;

import com.example.spring_batch.entity.PassEntity;
import com.example.spring_batch.entity.constant.PassStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class ObjectBuilder {
    protected ArrayList<PassEntity> addPassEntities(int size) {
        final LocalDateTime now = LocalDateTime.now();
        final Random random = new Random();

        ArrayList<PassEntity> passEntities = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            PassEntity passEntity = PassEntity.builder()
                    .packageId(1)
                    .userId("A" + 1000 + i)
                    .status(PassStatus.PROGRESSED)
                    .remainingCount(random.nextInt(11))
                    .startedAt(now.minusDays(60))
                    .endedAt(now.minusDays(1))
                    .build();
            passEntities.add(passEntity);
        }
        return passEntities;
    }
}
