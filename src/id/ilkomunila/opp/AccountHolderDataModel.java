package id.ilkomunila.opp;

import id.ilkomunila.opp.db.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountHolderDataModel {
    private final Connection conn;

    public AccountHolderDataModel() throws SQLException {
        this.conn = DBHelper.getConnection();
    }

    public void addAccountHolder(IndividualHolder holder) throws SQLException{
        String insertHolder = "INSERT INTO account_holder (holder_id, name, address)"
                + " VALUES (?, ?, ?)";
        String insertIndividual  = "INSERT INTO individual_holder (holder_id, gender, birthdate)"
                + " VALUES (?, ?, ?)";
        String insertAccount  = "INSERT INTO account (acc_number, balance, holder_id)"
                + " VALUES (?, ?, ?)";

        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, holder.getHolderId());
        stmtHolder.setString(2, holder.getName());
        stmtHolder.setString(3, holder.getAddress());
        stmtHolder.execute();

        PreparedStatement stmtIndividual = conn.prepareStatement(insertIndividual);
        stmtIndividual.setInt(1, holder.getHolderId());
        stmtIndividual.setString(2, holder.getGender());
        stmtIndividual.setString(3, holder.getBirthdate());
        stmtIndividual.execute();

        PreparedStatement stmtAccount = conn.prepareStatement(insertAccount);
        stmtAccount.setInt(1, holder.getAccounts().get(0).getAccNumber());
        stmtAccount.setDouble(2, holder.getAccounts().get(0).getBalance());
        stmtAccount.setInt(3, holder.getHolderId());
        stmtAccount.execute();
    }

    public void addAccountHolder(CorporateHolder holder) throws SQLException{
        String insertHolder = "INSERT INTO account_holder (holder_id, name, address)"
                + " VALUES (?, ?, ?)";
        String insertCorporate  = "INSERT INTO corporate_holder (holder_id, gender, contact)"
                + " VALUES (?, ?)";
        String insertAccount  = "INSERT INTO account (acc_number, balance, holder_id)"
                + " VALUES (?, ?, ?)";

        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, holder.getHolderId());
        stmtHolder.setString(2, holder.getName());
        stmtHolder.setString(3, holder.getAddress());
        stmtHolder.execute();

        PreparedStatement stmtCorporate = conn.prepareStatement(insertCorporate);
        stmtCorporate.setInt(1, holder.getHolderId());
        stmtCorporate.setString(2, holder.getContact());
        stmtCorporate.execute();

        PreparedStatement stmtAccount = conn.prepareStatement(insertAccount);
        stmtAccount.setInt(1, holder.getAccounts().get(0).getAccNumber());
        stmtAccount.setDouble(2, holder.getAccounts().get(0).getBalance());
        stmtAccount.setInt(3, holder.getHolderId());
        stmtAccount.execute();
    }

}
