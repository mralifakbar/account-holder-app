package id.ilkomunila.opp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Account {
    IntegerProperty accNumber;
    DoubleProperty balance;

    public Account(Integer accNumber, Double balance) {
        this.accNumber = new SimpleIntegerProperty(accNumber);
        this.balance = new SimpleDoubleProperty(balance);
    }

    public Integer getAccNumber() {
        return accNumber.get();
    }

    public IntegerProperty accNumberProperty() {
        return accNumber;
    }

    public void setAccNumber(Integer accNumber) {
        this.accNumber.set(accNumber);
    }

    public Double getBalance() {
        return balance.get();
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance.set(balance);
    }

    public void deposite(Double amount) {
        this.balance.set(this.balance.get() + amount);
    }

    public void withdraw(Double amount) {
        this.balance.set(this.balance.get() - amount);
    }
}
