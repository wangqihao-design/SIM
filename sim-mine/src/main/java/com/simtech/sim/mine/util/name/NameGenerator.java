package com.simtech.sim.mine.util.name;

import com.simtech.sim.mine.repo.mysql.CityNameRepo;

public interface NameGenerator {
    String getNewName(CityNameRepo cityNameRepo);
}
