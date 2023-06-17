package com.simtech.sim.backpack.service.impl;

import com.simtech.sim.backpack.entity.CommonEntity;
import com.simtech.sim.backpack.entity.InventoryEntity;
import com.simtech.sim.backpack.entity.TeamEntity;
import com.simtech.sim.backpack.repo.TeamRepository;
import com.simtech.sim.backpack.service.CommonService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public String addTeam(TeamEntity team){
        teamRepository.save(team);
        return team.getId();
    }

    @Override
    public void removeTeamById(String id){
        teamRepository.deleteById(id);
    }


    @Override
    public String addPlayerToTeam(String teamId, List<CommonEntity> players){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().getPlayers().addAll(players);
            teamRepository.save(team.get());
            return "ok";
        }
        else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String addMineToTeam(String teamId, List<CommonEntity> mines){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().getMine().addAll(mines);
            teamRepository.save(team.get());
            return "ok";
        }
        else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String removeMineToTeam(String teamId, List<CommonEntity> mines) {
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            List<CommonEntity> mineList = team.get().getMine();

            mineList.removeIf(mine -> mines.stream()
                    .anyMatch(removeMine -> removeMine.getId().equals(mine.getId())));

            teamRepository.save(team.get());
            return "ok";
        } else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String removeTechToTeam(String teamId, List<CommonEntity> techs) {
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            List<CommonEntity> techList = team.get().getTechnology();

            techList.removeIf(tech -> techs.stream()
                    .anyMatch(removeMine -> removeMine.getId().equals(tech.getId())));

            teamRepository.save(team.get());
            return "ok";
        } else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String removeProductionLineToTeam(String teamId, List<CommonEntity> productionLines){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            List<CommonEntity> plList = team.get().getProductionLine();

            plList.removeIf(productionLine -> productionLines.stream()
                    .anyMatch(removeMine -> removeMine.getId().equals(productionLine.getId())));

            teamRepository.save(team.get());
            return "ok";
        } else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String removeInventoryToTeam(String id, InventoryEntity inventory) {
        Optional<TeamEntity> team = teamRepository.findById(id);
        if (team.isPresent()) {

            InventoryEntity inventoryEntity = team.get().getInventory();
            inventoryEntity.setA(inventoryEntity.getA() - inventory.getA());
            inventoryEntity.setB(inventoryEntity.getB() - inventory.getB());
            inventoryEntity.setC(inventoryEntity.getC() - inventory.getC());

            inventoryEntity.setMoney(inventoryEntity.getMoney() - inventory.getMoney());

            List<Object[]> localProduct = team.get().getInventory().getProducts();

            if(inventory.getProducts() == null){
                inventory.setProducts(new ArrayList<>());
            }
            List<Object[]> removeProduct = inventory.getProducts();


            for (Object[] removeItem : removeProduct) {
                String removeItemId = (String) removeItem[0];
                int removeItemQuantity = (int) removeItem[2];

                boolean found = false;
                for (Object[] localItem : localProduct) {
                    String localItemId = (String) localItem[0];
                    int localItemQuantity = (int) localItem[2];

                    if (localItemId.equals(removeItemId)) {
                        found = true;
                        if (localItemQuantity < removeItemQuantity) {
                            return "没有足够的物品";
                        }
                        localItem[2] = localItemQuantity - removeItemQuantity;
                        break;
                    }
                }

                if (!found) {
                    return "物品不存在";
                }
            }


            teamRepository.save(team.get());
            return "ok";
        } else {
            return "The request Team " + id + " Not Found";
        }
    }


    @Override
    public String addTechToTeam(String teamId, List<CommonEntity> techs){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().getTechnology().addAll(techs);
            teamRepository.save(team.get());
            return "ok";
        }
        else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    @Transactional
    public String addInventoryToTeam(String teamId, InventoryEntity inventory) {
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            InventoryEntity thisInventory = team.get().getInventory();
            thisInventory.setA(inventory.getA() + thisInventory.getA());
            thisInventory.setB(inventory.getB() + thisInventory.getB());
            thisInventory.setC(inventory.getC() + thisInventory.getC());
            thisInventory.setMoney(inventory.getMoney() + thisInventory.getMoney());

            List<Object[]> thisProduct = thisInventory.getProducts();

            if(inventory.getProducts() == null){
                inventory.setProducts(new ArrayList<>());
            }

            List<Object[]> result = inventory.getProducts().stream()
                    .map(item -> {
                        String id = (String) item[0];
                        String name = (String) item[1];
                        int quantity = (int) item[2];

                        Optional<Object[]> foundItem = thisProduct.stream()
                                .filter(obj -> ((String) obj[0]).equals(id))
                                .findFirst();

                        if (foundItem.isPresent()) {
                            int existingQuantity = (int) foundItem.get()[2];
                            foundItem.get()[2] = existingQuantity + quantity;
                            return foundItem.get();
                        } else {
                            return new Object[]{id, name, quantity};
                        }
                    })
                    .collect(Collectors.toList());


            teamRepository.save(team.get());
            return "ok";
        } else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    public String removePlayerToTeam(String teamId, List<CommonEntity> players) {
        return null;
    }


    @Override
    public String addProductionLineToTeam(String teamId, List<CommonEntity> productLine){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().getProductionLine().addAll(productLine);
            teamRepository.save(team.get());
            return "ok";
        }
        else {
            return "The request Team " + teamId + " Not Found";
        }
    }

    @Override
    @Transactional
    public String removeInventoryFromTeam(String id, InventoryEntity inventory) {
        Optional<TeamEntity> team = teamRepository.findById(id);
        if(team.isPresent()){
            InventoryEntity localProducts = team.get().getInventory();

            if(!(localProducts.getA() < inventory.getA() || localProducts.getB() < inventory.getB() || localProducts.getC() < inventory.getC() || localProducts.getMoney() < inventory.getMoney())){
                localProducts.setA(localProducts.getA() - inventory.getA());
                localProducts.setB(localProducts.getB() - inventory.getB());
                localProducts.setC(localProducts.getC() - inventory.getC());
                localProducts.setMoney(localProducts.getMoney() - inventory.getMoney());
            }
            else{
                return "Not Enough Source";
            }

            List<Object[]> localInventory = team.get().getInventory().getProducts();
            boolean enoughItems = inventory.getProducts().stream().allMatch(itemToReduce ->
                    localInventory.stream().anyMatch(availableItem ->
                            availableItem[0].equals(itemToReduce[0]) &&
                                    (int) availableItem[2] >= (int) itemToReduce[2]
                    )
            );

            if (enoughItems) {
                inventory.getProducts().forEach(itemToReduce ->
                        localInventory.stream().filter(availableItem ->
                                availableItem[0].equals(itemToReduce[0])
                        ).findFirst().ifPresent(availableItem -> {
                            int quantityToReduce = (int) itemToReduce[2];
                            availableItem[2] = (int) availableItem[2] - quantityToReduce;
                        })
                );
                teamRepository.save(team.get());

                return "OK";
            } else {
                return "Not Enough Product";
            }

        }
        else {
            return "Team " + id +  " Not Exists";
        }
    }


}
