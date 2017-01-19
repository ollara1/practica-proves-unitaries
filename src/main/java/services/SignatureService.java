package services;

import data.Signature;
import data.Vote;

/**
 * External service for signing votes
 */
public interface SignatureService {

    Signature sign(Vote vote);

}