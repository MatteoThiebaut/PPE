package fr.dampierre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;;

public class ConnexionBdd {
    private final String DBURL = "jdbc:mysql://ppeslam.ddns.net:3306/ppetheo";
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

    public void insert() {
        
    }


    public void verificationMatriculePassword(String matricule, String password) throws SQLException, IOException {
            String sql = "SELECT * FROM visiteur where idvisiteur="+matricule+" and MDP='"+password+"';";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int i = 0;
            while (result.next()){
                i++;
            }
            if (i==1) {
                System.out.println("Connecté");
                PrimaryController.switchToSecondary();
            }else System.out.println("Matricule ou password incorrect");
    }
}
