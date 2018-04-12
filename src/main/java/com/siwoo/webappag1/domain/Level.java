package com.siwoo.webappag1.domain;

public enum Level {
    EXTREME("고급",3, null), INTERMEDIATE("중급",1, EXTREME), NOVICE("초급", 2, INTERMEDIATE);
    private String korean;
    private int value;
    private Level nextLevel;

    Level(String korean,int value, Level nextLevel) {
        this.korean = korean;
        this.value = value;
        this.nextLevel = nextLevel;
    }

    Level koreanValueOf(String korean) {
        switch (korean) {
            case "고급": return EXTREME;
            case "중급": return INTERMEDIATE;
            case "초급": return NOVICE;
            default: throw new IllegalStateException("Unknown value: " + korean );
        }
    }

    Level valueOf(int level) {
        switch (level) {
            case 3: return EXTREME;
            case 2: return INTERMEDIATE;
            case 1: return NOVICE;
            default: throw new IllegalStateException("Unknown value: " + level );
        }
    }
}
