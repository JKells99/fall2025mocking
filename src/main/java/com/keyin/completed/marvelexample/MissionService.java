/**
 * MissionService.java
 * Service for assigning missions to Avengers heroes.
 */
package com.keyin.completed.marvelexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles mission assignments and hero management for Avengers.
 */
public class MissionService {

    private final AvengersAPI avengersAPI;

    /**
     * Constructs a MissionService with the given AvengersAPI.
     * @param avengersAPI the AvengersAPI implementation
     */
    public MissionService(AvengersAPI avengersAPI) {
        this.avengersAPI = avengersAPI;
    }

    /**
     * Assigns a mission to the first available hero.
     * @param mission the mission description
     * @return assignment result message
     */
    public String assignMission(String mission) {
        List<String> heroes = avengersAPI.getAvailableHeroes();
        if (heroes.isEmpty()) {
            return "No heroes available for the mission: " + mission;
        }

        return heroes.getFirst() + " is assigned to the mission: " + mission;
    }

    /**
     * Removes the first hero from the available heroes list.
     * @return updated list of available heroes
     */
    public List<String> removeHero() {
        List<String> mutableHeroes = new ArrayList<>(avengersAPI.getAvailableHeroes());
        mutableHeroes.removeFirst();
        return mutableHeroes;

    }
}
