/*Design a Voting System
Description: Design a system where:
Votes are stored in a HashMap (Candidate -> Votes).
TreeMap is used to display the results in sorted order.
LinkedHashMap is used to maintain the order of votes.
*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.util.*;

class Voting {
    private Map<String, Integer> votesMap;       //HashMap to store candidate votes
    private Map<String, Integer> linkedVotesMap; //LinkedHashMap to maintain order of voting
    private Map<Integer, String> sortedVotesMap; //TreeMap to sort candidates by number of votes

    public Voting() {
        votesMap = new HashMap<>();
        linkedVotesMap = new LinkedHashMap<>();
        sortedVotesMap = new TreeMap<>(Collections.reverseOrder()); //Sorted by votes in descending order
    }

    //Casting a vote for a candidate
    public void castVote(String candidate) {
        //Increasing the vote count in HashMap
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);

        //Maintaining the insertion order in LinkedHashMap
        linkedVotesMap.put(candidate, votesMap.get(candidate));

        //Updating the TreeMap with the latest vote count (sorted in descending order)
        sortedVotesMap.put(votesMap.get(candidate), candidate);
    }

    //Getting the current vote count of a candidate
    public int getVotesForCandidate(String candidate) {
        return votesMap.getOrDefault(candidate, 0);
    }

    //Displaying the results in sorted order (highest to lowest votes)
    public void displayResultsSorted() {
        System.out.println("\nResults (Sorted by votes):");
        sortedVotesMap.forEach((votes, candidate) -> System.out.println(candidate + ": " + votes));
    }

    // Display the results in the order of voting (insertion order)
    public void displayResultsInsertionOrder() {
        System.out.println("\nResults (Insertion Order):");
        linkedVotesMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }
}
public class VotingSystem {
    public static void main(String[] args) {
        //Creating an instance of the Voting
        Voting votingSystem = new Voting();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");

        votingSystem.displayResultsSorted();

        votingSystem.displayResultsInsertionOrder();

        System.out.println("\nVotes for Alice: " + votingSystem.getVotesForCandidate("Alice"));
        System.out.println("Votes for Bob: " + votingSystem.getVotesForCandidate("Bob"));
        System.out.println("Votes for Charlie: " + votingSystem.getVotesForCandidate("Charlie"));
    }
}