package services;

import data.MailAddress;
import data.Signature;

/**
 * External service for sending mails
 */
public interface MailerService {

    void send(MailAddress address, Signature signature);

}