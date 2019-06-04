package Entity;

import javax.persistence.*;

@Entity(name = "Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private TwitchUser donator;
    private double amount;
    private String message;
    private boolean counted;

    public Donation() {
    }

    public Donation(TwitchUser donator, double amount, String message, boolean counted) {
        this.donator = donator;
        this.amount = amount;
        this.message = message;
        this.counted = counted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TwitchUser getDonator() {
        return donator;
    }

    public void setDonator(TwitchUser donator) {
        this.donator = donator;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCounted() {
        return counted;
    }

    public void setCounted(boolean counted) {
        this.counted = counted;
    }
}
