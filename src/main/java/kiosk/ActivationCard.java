package kiosk;

public class ActivationCard {

    private boolean active = true;
    private String code;

    public ActivationCard(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivationCard activationCard = (ActivationCard) o;
        return code.equals(activationCard.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }//preguntar raul

    public boolean isActive() {
        return this.active;

    }

    public void erase() {
        this.active = false;
    }
}
