package data;

public class Party {

    private final String party;

    public Party(String option) {
        this.party = option;
    }

    public String getParty() {
        return party;
    }

    @Override
    public String toString() {
        return "Party{"
                + "party='"
                + party
                + "\'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party part = (Party) o;
        return party.equals(part.party);
    }

    @Override
    public int hashCode() {
        return party.hashCode();
    }
}
