# Fall 2025 Mocking Examples

This project demonstrates unit testing and mocking in Java using two themed examples: **Avengers** and **Jedi**. It uses JUnit 5 and Mockito for writing and running tests.

** Maven Dependencies Needed ** 
```
<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.12.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>4.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## Avengers Example

**Classes:**
- `AvengersAPI`: Interface for retrieving available Avengers heroes.
- `MissionService`: Service class that assigns missions to heroes and manages hero availability.

**Testing & Mocking:**
- `MissionServiceTest` uses Mockito to mock the `AvengersAPI` interface.
- This allows tests to simulate different scenarios (heroes available, no heroes, removing heroes) without relying on real data or implementations.

**Mocking Example:**
```java
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
```

---

## Jedi Example

**Classes:**
- `JediTrainingService`: Assesses the force level of Padawans using a `ForceMeter` dependency.
- `ForceMeter`: (Assumed interface/class) Provides force level readings for Padawans.

**Testing & Mocking:**

**Mocking Example (conceptual):**
```java
JediTrainingService jediTrainingService;

@Mock
ForceMeter mockForceMeter;

@BeforeEach
void setUp() {
    jediTrainingService = new JediTrainingService(mockForceMeter);
}

@Test
void testStrongPadawan(){
    when(mockForceMeter.getForceLevel("Luke")).thenReturn(100);
    String result = jediTrainingService.assessPadawan("Luke");
    Assertions.assertEquals("Strong with the force Luke is ", result);
    System.out.println(result);
}
```

---

## How Mocking Is Showcased
- **Isolation:** Tests focus on the logic of the service classes (`MissionService`, `JediTrainingService`) without being affected by external systems or data.
- **Control:** Mocking allows you to simulate various scenarios (e.g., no heroes available, high force level) and verify that your code responds correctly.
- **Repeatability:** Tests are reliable and repeatable because they do not depend on changing external data.

---

---

## Summary
This project provides clear examples of how to use mocking in Java unit tests to isolate and verify business logic. The Avengers and Jedi examples show how to mock dependencies and write effective, maintainable tests.

## Links to mockito docs/videos 
- https://www.baeldung.com/mockito-annotations
-  
