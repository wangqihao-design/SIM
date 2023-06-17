package com.simtech.sim.backpack.service;


import com.simtech.sim.backpack.entity.CommonEntity;
import com.simtech.sim.backpack.entity.InventoryEntity;
import com.simtech.sim.backpack.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService {

    String addTeam(TeamEntity teamEntity);

    void removeTeamById(String id);

    String addPlayerToTeam(String teamId, List<CommonEntity> players);

    String addMineToTeam(String id, List<CommonEntity> mines);

    String addTechToTeam(String id, List<CommonEntity> techs);

    String addInventoryToTeam(String id, InventoryEntity inventory);

    String removePlayerToTeam(String teamId, List<CommonEntity> players);

    String removeMineToTeam(String id, List<CommonEntity> mines);

    String removeTechToTeam(String id, List<CommonEntity> techs);

    String removeProductionLineToTeam(String id, List<CommonEntity> productionLine);


    String removeInventoryToTeam(String id, InventoryEntity inventory);

    String addProductionLineToTeam(String id, List<CommonEntity> productLine);

    String removeInventoryFromTeam(String id, InventoryEntity productionLine);

}
