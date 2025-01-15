package com.infanzon.collaborativestorybuilder.DataClasses;

public class Turn {
    private String userId;
    private boolean isTurnActive;

    // Constructor
    public Turn(String userId, boolean isTurnActive) {
        this.userId = userId;
        this.isTurnActive = isTurnActive;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isTurnActive() {
        return isTurnActive;
    }

    public void setTurnActive(boolean isTurnActive) {
        this.isTurnActive = isTurnActive;
    }
}
