package fr.dampierre;


import java.io.IOException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    //Connexion a la base de données via ConnexionBdd.java POO
    ConnexionBdd connexion = new ConnexionBdd("ppetheo", "ppetheo");
    
    @FXML
    static void switchToSecondary() throws IOException {
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
    void OnActionClickConnexion(final ActionEvent event) throws IOException, SQLException {
        connexion();
    }

    public void connexion() throws IOException, SQLException {
        String matricule = TxMatricule.getText();
        String password = TxMotDePasse.getText();
        connexion.verificationMatriculePassword(matricule, password);
    }
}
