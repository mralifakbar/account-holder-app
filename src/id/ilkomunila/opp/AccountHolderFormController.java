/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ilkomunila.opp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author LENOVO
 */
public class AccountHolderFormController implements Initializable {

    @FXML
    private TextField tfHolderID;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAddress;

    @FXML
    private ComboBox<String> cbGender;

    @FXML
    private DatePicker dpBirthdate;

    @FXML
    private TextField tfAccNumber;

    @FXML
    private TextField tfAccBalance;

    @FXML
    private Button btnAddAccountHolder;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<?> tblAccHolder;

    @FXML
    private TableColumn<?, ?> colHolderID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colBirthdate;

    @FXML
    private TableColumn<?, ?> colNumAccounts;

    @FXML
    private TableView<?> tblAccount;

    @FXML
    private TableColumn<?, ?> colAccNumber;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TextField tfNewHolderID;

    @FXML
    private TextField tfNewAccNumber;

    @FXML
    private TextField tfNewAccBalance;

    @FXML
    private Button btnAddAccount;

    @FXML
    private Label lblDBStatus;

    private AccountHolderDataModel ahdm;
    @FXML
    void handleAddAccountButton(ActionEvent event) {

    }

    @FXML
    void handleAddHolderButton(ActionEvent event) {

    }

    @FXML
    void handleClearButton(ActionEvent event) {

    }

    @FXML
    void handleReloadButton(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female");
        cbGender.setItems(gender);

        try {
            AccountHolderDataModel ahdm = new AccountHolderDataModel();
            lblDBStatus.setText(ahdm.conn == null? "Not Connected" : "Connected");
            tfHolderID.setText(""+ahdm.nextAccountHolderID());
            tfAccNumber.setText(tfHolderID.getText() + "01");
        } catch (SQLException ex) {
            Logger.getLogger(AccountHolderDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
