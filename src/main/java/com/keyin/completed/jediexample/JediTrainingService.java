/**
 * JediTrainingService.java
 * Service for assessing the force level of Padawans.
 */
package com.keyin.completed.jediexample;

/**
 * Provides training assessment for Padawans using a ForceMeter.
 */
public class JediTrainingService {
    private final ForceMeter forceMeter;

    /**
     * Constructs a JediTrainingService with the given ForceMeter.
     * @param forceMeter the ForceMeter implementation
     */
    public JediTrainingService(ForceMeter forceMeter) {
        this.forceMeter = forceMeter;
    }

    /**
     * Assesses a Padawan's force level and returns a message.
     * @param padawanName the name of the Padawan
     * @return assessment message
     */
    public String assessPadawan(String padawanName) {
        int forceLevel = forceMeter.getForceLevel(padawanName);
        if(forceLevel > 70) {
            return "Strong with the force " + padawanName + " is ";
        }
        return "Much to lean they do " + padawanName;
    }
}
