package fr.dampierre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;;

public class ConnexionBdd {
    private final String DBURL = "jdbc:mysql://90.110.87.53:3306/ppetheo2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection conn;
    private String username;
    private String password;

    public ConnexionBdd(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            conn = DriverManager.getConnection(DBURL, username, password);
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void verificationMatriculePassword(String matricule, String password) throws SQLException, IOException {
        String sql = "SELECT * FROM Visiteur where VI_Matricule=" + matricule + " and VI_MDP='" + password + "';";
        String sql1 = "SELECT * FROM Comptable where CO_Matricule=" + matricule + " and CO_MDP='" + password + "';";
        Statement statement = conn.createStatement();
        Statement statement1 = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        ResultSet result1 = statement1.executeQuery(sql1);
        int i = 0;
        int j = 0;
        while (result.next()) {
            i++;
        }
        if (i == 1) {
            System.out.println("Connecté");
            PrimaryController.switchToSecondary();
        }

        while (result1.next()) {
            j++;
        }
        if (j == 1) {
            System.out.println("Connecté");
            PrimaryController.switchToSecondaryComptable();
        }
        if (i == 0 && j == 0) {
            System.out.println("Matricule ou Password incorect");
        }
    }

    public Connection getConn() {
        return conn;
    }

}