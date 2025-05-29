package ru.random_walk.enums;

public enum ApprovementType {

    MEMBERS_CONFIRM("MEMBERS_CONFIRM"),
    FORM("FORM");

    private final String graphqlName;

    private ApprovementType(String graphqlName) {
        this.graphqlName = graphqlName;
    }

    @Override
    public String toString() {
        return this.graphqlName;
    }

}
