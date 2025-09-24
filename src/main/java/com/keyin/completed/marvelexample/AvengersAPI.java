/**
 * AvengersAPI.java
 * Interface for retrieving available Avengers heroes.
 */
package com.keyin.completed.marvelexample;

import java.util.List;

/**
 * Provides a method to get a list of available heroes.
 */
public interface AvengersAPI {
    /**
     * Returns a list of available hero names.
     * @return List of hero names
     */
    List<String> getAvailableHeroes(); // Pretend that this makes a call to a DB and fetches us data, THis was the easiest way to show mocking without it being confusing
}
