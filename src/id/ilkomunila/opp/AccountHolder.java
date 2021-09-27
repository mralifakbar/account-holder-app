package id.ilkomunila.opp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public abstract class AccountHolder {
    private IntegerProperty holderId;
    private StringProperty name;
    private StringProperty address;
    private IntegerProperty numAccounts;
    private ArrayList<Account> accounts;

    public AccountHolder(Integer holderId,
                         String name,
                         String address,
                         ArrayList<Account> accounts) {
        this.holderId = new SimpleIntegerProperty(holderId);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.numAccounts = new SimpleIntegerProperty(accounts.size());
        this.accounts = accounts;
    }

    public AccountHolder(Integer holderId,
                         String name,
                         String address,
                         Account account) {
        accounts = new ArrayList<>();
        this.holderId = new SimpleIntegerProperty(holderId);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.numAccounts = new SimpleIntegerProperty(accounts.size());
        this.accounts.add(account);
    }

    public Integer getHolderId() {
        return holderId.get();
    }

    public IntegerProperty holderIdProperty() {
        return holderId;
    }

    public void setHolderId(Integer holderId) {
        this.holderId.set(holderId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public Integer getNumAccounts() {
        return numAccounts.get();
    }

    public IntegerProperty numAccountsProperty() {
        return numAccounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
