package ru.random_walk.enums;

public enum AnswerStatus {

    /**
     * The answer was created, but not sent
     */
    CREATED("CREATED"),
    /**
     * The answer has been sent for review
     */
    SENT("SENT"),
    /**
     * The answer in progress for checking answer options
     */
    IN_PROGRESS("IN_PROGRESS"),
    /**
     * The answer in review and waiting for manual approve or reject
     */
    IN_REVIEW("IN_REVIEW"),
    /**
     * The answer was reviewed with failed result
     */
    FAILED("FAILED"),
    /**
     * The answer was reviewed with passed result
     */
    PASSED("PASSED");

    private final String graphqlName;

    private AnswerStatus(String graphqlName) {
        this.graphqlName = graphqlName;
    }

    @Override
    public String toString() {
        return this.graphqlName;
    }

}
