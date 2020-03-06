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

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
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
        final String MotDePasse = TxMotDePasse.getText();
        String dbURL = "jdbc:mysql://localhost:3306/ppe2";
        if (matricule.equals("root") && MotDePasse.equals("root")) {
            System.out.println("Connecter");
            switchToSecondary();
            try (Connection conn = DriverManager.getConnection(dbURL, "root", "")) {
                System.out.println("Connecter a la base de donnee");
                // code to execute SQL queries goes here...

                // String sql = "INSERT INTO `ppe2`.`visiteur` (`idvisiteur`, `Nom`, `prenom`,
                // `MDP`, `tel`) VALUES (?, ?, ?, ?, ?)";
                // PreparedStatement statement = conn.prepareStatement(sql);

                // statement.setString(1, "99");
                // statement.setString(2, "Thiebaut");
                // statement.setString(3, "Matteo");
                // statement.setString(4, "10112000");
                // statement.setString(5, "22222");

                // String sql = "SELECT `ppe2`.`visiteur` (`Nom`, `prenom`) VALUES (?, ?)";
                // System.out.println(sql);
                // int rowsInserted = statement.executeUpdate();
                // if (rowsInserted > 0) {
                // System.out.println("A new user was inserted successfully!");
                // }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else
            System.out.println("Votre matricule ou mot de passe est faux");
    }
}