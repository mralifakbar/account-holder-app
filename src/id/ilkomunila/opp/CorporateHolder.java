package id.ilkomunila.opp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class CorporateHolder extends AccountHolder{
    StringProperty contact;

    public CorporateHolder(Integer holderId, String name, String address, ArrayList<Account> accounts, String contact) {
        super(holderId, name, address, accounts);
        this.contact = new SimpleStringProperty(contact);
    }

    public CorporateHolder(Integer holderId, String name, String address, Account account, String contact) {
        super(holderId, name, address, account);
        this.contact = new SimpleStringProperty(contact);
    }

    public String getContact() {
        return contact.get();
    }

    public StringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }
}
