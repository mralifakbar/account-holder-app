package id.ilkomunila.opp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class IndividualHolder extends AccountHolder{
    StringProperty gender;
    StringProperty birthdate;

    public IndividualHolder(Integer holderId,
                            String name,
                            String address,
                            ArrayList<Account> accounts,
                            String gender,
                            String birthdate) {
        super(holderId, name, address, accounts);
        this.gender = new SimpleStringProperty(gender);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    public IndividualHolder(Integer holderId,
                            String name,
                            String address,
                            Account account,
                            String gender,
                            String birthdate) {
        super(holderId, name, address, account);
        this.gender = new SimpleStringProperty(gender);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public StringProperty birthdateProperty() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate.set(birthdate);
    }
}
