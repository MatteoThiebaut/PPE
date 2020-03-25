package fr.dampierre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    //Connexion a la base de données via ConnexionBdd.java POO
    ConnexionBdd connexion = new ConnexionBdd("ppetheo", "ppetheo");
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToSecondaryComptable() throws IOException {
        App.setRoot("secondaryComptable");
    }

    @FXML
    private TextField TxMatricule;

    @FXML
    private TextField TxMotDePasse;

    @FXML
    void OnActionClickConnexion(final ActionEvent event) throws IOException {
        connexion();
    }

    public void connexion() throws IOException {
        final String matricule = TxMatricule.getText();
        final String password = TxMotDePasse.getText();
        String dbURL = "jdbc:mysql://ppeslam.ddns.net:3306/ppetheo";
        if (matricule.equals("root") && password.equals("root")) {
            System.out.println("Connecté");
            switchToSecondary();
            try (Connection conn = DriverManager.getConnection(dbURL, "ppetheo", "ppetheo")) {
                System.out.println("Connecté a la base de donnee");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (matricule.equals("comptable") && password.equals("comptable")) {
            System.out.println("Connecté");
            switchToSecondaryComptable();
            try (Connection conn = DriverManager.getConnection(dbURL, "ppetheo", "ppetheo")) {
                System.out.println("Connecté a la base de donnee");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("Votre matricule ou mot de passe est faux");

        }

    }
}
