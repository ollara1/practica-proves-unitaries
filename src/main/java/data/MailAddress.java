package data;

public class MailAddress {

    private final String mailAddress;

    public MailAddress(String Address) {
        this.mailAddress = Address;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    @Override
    public String toString() {
        return "MailAddress{"
                + "address='"
                + mailAddress
                + "\'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress address = (MailAddress) o;
        return mailAddress.equals(address.mailAddress);
    }

    @Override
    public int hashCode() {
        return mailAddress.hashCode();
    }
}

