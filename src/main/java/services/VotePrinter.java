package services;

import data.Vote;

/**
 * This service prints physically the vote to allow checking.
 */

public interface VotePrinter {

    void print(Vote vote);

}