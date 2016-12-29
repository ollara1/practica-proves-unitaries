package data;

/**
 * Represents a vote.
 */
final public class Vote {
    private final String option;

    public Vote(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "option='" + option + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return option.equals(vote.option);
    }

    @Override
    public int hashCode() {
        return option.hashCode();
    }
}