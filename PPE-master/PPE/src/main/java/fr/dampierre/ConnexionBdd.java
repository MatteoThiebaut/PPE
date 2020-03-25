package fr.dampierre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {
        private final String DBURL="jdbc:mysql://ppeslam.ddns.net:3306/ppetheo";
        private Connection conn;

        public ConnexionBdd(String username, String password) {
            try {
                conn = DriverManager.getConnection(DBURL, username, password);
                if (conn != null) {
                    System.out.println("Connected");
                }
            } catch (final SQLException ex) {
                ex.printStackTrace();
            }
        }

        public void insert(){
            
        }
    }