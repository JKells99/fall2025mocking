package com.keyin.completed.jediexample;

public interface ForceMeter {
    int getForceLevel(String name); // pretend this makes a call to a db to get the force level for a specific person by name, we will mock that it is working in the test
}
