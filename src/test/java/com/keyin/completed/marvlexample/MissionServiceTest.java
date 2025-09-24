package com.keyin.completed.marvlexample;

import com.keyin.completed.marvelexample.AvengersAPI;
import com.keyin.completed.marvelexample.MissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MissionServiceTest {


    @Mock
    AvengersAPI mockAvengersAPI;

    /**
     * Tests that a hero is assigned to a mission when heroes are available.
     */
    @Test
    public void testHerosAssigned() {
        when(mockAvengersAPI.getAvailableHeroes()).then(invocation -> List.of("Iron Man", "Spider Man")); // Mocking to return a list with heroes
        MissionService missionService = new MissionService(mockAvengersAPI);
        String result = missionService.assignMission("Save New York");
        Assertions.assertEquals("Iron Man is assigned to the mission: Save New York", result);

    }

    /**
     * Tests that the correct message is returned when no heroes are available for a mission.
     * Using mocking to simulate no available heroes.
     */
    @Test
    public void testNoHeroesAvailable() {
        when(mockAvengersAPI.getAvailableHeroes()).then(invocation -> List.of()); // Mocking to return an empty list
        MissionService missionService = new MissionService(mockAvengersAPI);
        String result = missionService.assignMission("Save New York");
        Assertions.assertEquals("No heroes available for the mission: Save New York", result);
    }


    /**
     * Tests that the second hero in the list is assigned after the first hero is removed.
     */
    @Test
    void assignSecondPersonInList() {
        when(mockAvengersAPI.getAvailableHeroes())
            .thenReturn(List.of("Iron Man", "Spider Man", "Captain America")) // Mocking to return a list with heroes
            .thenReturn(List.of("Spider Man", "Captain America")); // Mocking to return a list with heroes after the first one is removed
        MissionService missionService = new MissionService(mockAvengersAPI);

        String result = missionService.assignMission("Save New York");
        missionService.removeHero();
        String mission = missionService.assignMission("Save New York 2");

        Assertions.assertEquals("Spider Man is assigned to the mission: Save New York 2", mission);
    }


}
