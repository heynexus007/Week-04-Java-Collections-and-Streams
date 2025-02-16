package javacollectionframework.mapinterface;

import java.util.*;
import static java.lang.System.*;
public class VotingSystem {
    // Method to cast votes
    private static void castVote(Map<String, Integer> votes, String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    public static void main(String[] args) {
        // HashMap to store votes for candidates
        HashMap<String, Integer> votes = new HashMap<>();

        // Simulate voting
        castVote(votes, "Rahul");
        castVote(votes, "Rajiv");
        castVote(votes, "Rahul");
        castVote(votes, "Ravi");
        castVote(votes, "Rajiv");

        // Display votes in insertion order using LinkedHashMap
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(votes);
        out.println("Votes in insertion order : " + voteOrder);

        // Display votes sorted by candidate name using TreeMap
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);
        out.println("Sorted voting results : " + sortedResults);
    }
}
