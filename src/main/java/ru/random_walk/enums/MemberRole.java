package ru.random_walk.enums;

public enum MemberRole {

    ADMIN("ADMIN"),
    USER("USER"),
    INSPECTOR("INSPECTOR");

    private final String graphqlName;

    private MemberRole(String graphqlName) {
        this.graphqlName = graphqlName;
    }

    @Override
    public String toString() {
        return this.graphqlName;
    }

}
