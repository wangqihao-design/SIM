package com.simtech.sim.backpack.service.impl;

import com.simtech.sim.backpack.entity.CommonEntity;
import com.simtech.sim.backpack.entity.InventoryEntity;
import com.simtech.sim.backpack.entity.ProductEntity;
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
        Optional<TeamEntity> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isPresent()) {
            TeamEntity team = optionalTeam.get();
            InventoryEntity storedInventory = team.getInventory();

            // Update the inventory by subtracting the given inventory
            storedInventory = sourceEditor(storedInventory, -inventory.getMoney(), -inventory.getA(), -inventory.getB(), -inventory.getC());

            // Update product quantities in the inventory
            for (ProductEntity inventoryProduct : inventory.getProducts()) {
                for (ProductEntity storedProduct : storedInventory.getProducts()) {
                    if (inventoryProduct.getName().equals(storedProduct.getName())) {
                        int storedProductNumber = storedProduct.getNumber() - inventoryProduct.getNumber();
                        storedProduct.setNumber(storedProductNumber);
                    }
                }
            }

            // Save the updated inventory
            team.setInventory(storedInventory);
            teamRepository.save(team);

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
        Optional<TeamEntity> optionalTeam = teamRepository.findById(teamId);

        if (optionalTeam.isPresent()) {
            TeamEntity team = optionalTeam.get();
            InventoryEntity thisInventory = team.getInventory();


            thisInventory = sourceEditor(thisInventory, thisInventory.getMoney(), thisInventory.getA(), thisInventory.getB(), thisInventory.getC());
            List<ProductEntity> thisProducts = thisInventory.getProducts();
            List<ProductEntity> incomingProducts = inventory.getProducts();

            if (incomingProducts != null) {
                for (ProductEntity incomingProduct : incomingProducts) {
                    ProductEntity foundProduct = thisProducts.stream()
                            .filter(product -> product.getId().equals(incomingProduct.getId()))
                            .findFirst()
                            .orElse(null);

                    if (foundProduct != null) {
                        int existingQuantity = foundProduct.getNumber();
                        foundProduct.setNumber(existingQuantity + incomingProduct.getNumber());
                    } else {
                        thisProducts.add(incomingProduct);
                    }
                }
            }

            team.setInventory(thisInventory);
            teamRepository.save(team);
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
        Optional<TeamEntity> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isPresent()) {
            TeamEntity team = optionalTeam.get();
            InventoryEntity localProducts = team.getInventory();

            if (localProducts.getA() >= inventory.getA() && localProducts.getB() >= inventory.getB()
                    && localProducts.getC() >= inventory.getC() && localProducts.getMoney() >= inventory.getMoney()) {
                localProducts.setA(localProducts.getA() - inventory.getA());
                localProducts.setB(localProducts.getB() - inventory.getB());
                localProducts.setC(localProducts.getC() - inventory.getC());
                localProducts.setMoney(localProducts.getMoney() - inventory.getMoney());

                List<ProductEntity> localInventory = localProducts.getProducts();
                boolean enoughItems = inventory.getProducts().stream().allMatch(itemToReduce ->
                        localInventory.stream().anyMatch(availableItem ->
                                availableItem.getId().equals(itemToReduce.getId()) &&
                                        availableItem.getNumber() >= itemToReduce.getNumber()
                        )
                );

                if (enoughItems) {
                    inventory.getProducts().forEach(itemToReduce ->
                            localInventory.stream().filter(availableItem ->
                                    availableItem.getId().equals(itemToReduce.getId())
                            ).findFirst().ifPresent(availableItem -> {
                                int quantityToReduce = itemToReduce.getNumber();
                                availableItem.setNumber(availableItem.getNumber() - quantityToReduce);
                            })
                    );

                    team.setInventory(localProducts);
                    teamRepository.save(team);
                    return "OK";
                } else {
                    return "Not Enough Product";
                }
            } else {
                return "Not Enough Source";
            }
        } else {
            return "Team " + id + " Not Exists";
        }
    }

    public InventoryEntity sourceEditor(InventoryEntity inventory, double money, int... source){
        for(int s : source){
            inventory.setA(s + inventory.getA());
            inventory.setB(s + inventory.getB());
            inventory.setC(s + inventory.getC());
            inventory.setMoney(s + money);
        }

        return inventory;
    }


}
