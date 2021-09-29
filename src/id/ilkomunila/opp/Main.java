/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ilkomunila.opp;

import id.ilkomunila.opp.db.DBHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AccountHolderForm.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Kartadinata Account Holder System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
//        try {
//            AccountHolderDataModel ahdm = new AccountHolderDataModel();
//            IndividualHolder ih = new IndividualHolder(2, "Alif Akbar", "Pringsewu",  new Account(12, 500000.0), "Male", "2002-05-24");
//            ahdm.addAccountHolder(ih);
//            System.out.println("Sukses ditambahkan");
////            if (null != DBHelper.getConnection()) {
////                System.out.println("Koneksi sukses");
////            } else {
////                System.out.printf("Koneksi gagal");
////            }
//        } catch (SQLException ex) {
//            System.out.println("Gagal ditambahkan");
//            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }

        launch(args);
    }
    
}
