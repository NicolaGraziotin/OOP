package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote {

    private static final long CAUSE_TIME = 40;
    private static final long DETAILS_TIME = 6000 + CAUSE_TIME;
    private final Map<String, Death> deaths = new HashMap<>();
    private String lastName = "";

    private class Death {
        private static final String DEFAULT_CAUSE = "heart attack";
        private static final String DEFAULT_DETAILS = "";

        private final String cause;
        private String details;
        private long timeOfDeath;
        
        public Death(String cause) {
            this.cause = cause;
            this.details = DEFAULT_DETAILS;
            this.timeOfDeath = System.currentTimeMillis();
        }

        public Death() {
            this(DEFAULT_CAUSE);
        }

        public String getCause() {
            return cause;
        }

        public String getDetails() {
            return details;
        }

        public long getTimeOfDeath() {
            return timeOfDeath;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    @Override
    public String getRule(int ruleNumber) throws IllegalArgumentException {
        if (ruleNumber <= 0 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException();
        }
        return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        Objects.requireNonNull(name);
        lastName = name;
        deaths.put(lastName, new Death());
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if (lastName.isBlank()) {
            throw new IllegalStateException();
        }
        if (System.currentTimeMillis() < deaths.get(lastName).getTimeOfDeath() + CAUSE_TIME) {
            deaths.put(lastName, new Death(cause));
            return true;
        }
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        if (lastName.isBlank()) {
            throw new IllegalStateException();
        }
        if (System.currentTimeMillis() < deaths.get(lastName).getTimeOfDeath() + DETAILS_TIME) {
            deaths.get(lastName).setDetails(details);
            return true;
        }
        return false;
    }

    @Override
    public String getDeathCause(String name) {
        return deaths.get(name).getCause();
    }

    @Override
    public String getDeathDetails(String name) {
        return deaths.get(name).getDetails();
    }

    @Override
    public boolean isNameWritten(String name) {
        return deaths.containsKey(name);
    }
    
}
