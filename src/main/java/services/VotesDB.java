package services;

import data.Vote;

import java.util.List;

/**
 * Local service that registers votes.
 */
public interface VotesDB {

    void registerVote(Vote vote);

    List<Vote> getVotes();

}