package com.infanzon.collaborativestorybuilder.TurnManagement;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infanzon.collaborativestorybuilder.DataClasses.Turn;
import com.infanzon.collaborativestorybuilder.DataClasses.User;

import java.util.List;
import java.util.UUID;

public class TurnHandler {
    private DatabaseReference turnRef;
    private List<User> participants;
    private int currentTurnIndex;

    public TurnHandler(List<User> participants) {
        this.participants = participants;
        this.currentTurnIndex = 0;
        this.turnRef = FirebaseDatabase.getInstance().getReference("turns");
    }

    public void initializeTurns() {
        // Reset turns and set first user's turn as active
        for (User user : participants) {
            Turn turn = new Turn(user.getUserId(), false);
            turnRef.child(user.getUserId()).setValue(turn);
        }

        // Set first participant's turn as active
        setCurrentTurn(participants.get(0));
    }

    public void setCurrentTurn(User user) {
        // Deactivate previous turn
        if (currentTurnIndex > 0) {
            User previousUser = participants.get(currentTurnIndex - 1);
            updateTurnStatus(previousUser.getUserId(), false);
        }

        // Activate current user's turn
        updateTurnStatus(user.getUserId(), true);
        currentTurnIndex = participants.indexOf(user);
    }

    public void moveToNextTurn() {
        // Cycle to next participant
        currentTurnIndex = (currentTurnIndex + 1) % participants.size();
        User nextUser = participants.get(currentTurnIndex);
        setCurrentTurn(nextUser);
    }

    private void updateTurnStatus(String userId, boolean isActive) {
        Turn turn = new Turn(userId, isActive);
        turnRef.child(userId).setValue(turn);
    }

    public User getCurrentTurnUser() {
        return participants.get(currentTurnIndex);
    }

    public boolean isUserTurn(String userId) {
        User currentUser = getCurrentTurnUser();
        return currentUser.getUserId().equals(userId);
    }
}