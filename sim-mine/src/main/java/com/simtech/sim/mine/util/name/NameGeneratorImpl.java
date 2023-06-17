package com.simtech.sim.mine.util.name;

import com.simtech.sim.mine.entity.cities.CityEntities;
import com.simtech.sim.mine.repo.mysql.CityNameRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class NameGeneratorImpl implements NameGenerator {

    private static Set<Integer> usedCity = new HashSet<>();

    private final Random random = new Random();

    public String getNewName(CityNameRepo cityNameRepo) {
        int id = random.nextInt(1, 201);
        CityEntities cityEntities;

        while (usedCity.contains(id)) {
            id = random.nextInt(1, 201);
            if (!usedCity.contains(id)) {
                break;
            }
        }

        cityEntities = cityNameRepo.selectById(id);

        return cityEntities.getName() + " Mine";
    }
}
