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

    // public void connexion() {
    // String dbURL =
    // "jdbc:mysql://localhost:8889/salon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // Statement statement = conn.createStatement();
    // ResultSet result = statement.executeQuery(sql);
    // String username = result.getString(1);
    // String password = result.getString(2);
    // if (username == "root" && password == "root") {
    // try {
    // Connection conn = DriverManager.getConnection(dbURL, username, password);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }
    // }

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

// try (Connection conn = DriverManager.getConnection(dbURL, "root", "")) {
// System.out.println("Connecter a la base de donnee");
// code to execute SQL queries goes here...

// String sql = "INSERT INTO `ppe2`.`visiteur` (`idvisiteur`, `Nom`, `prenom`,
// `MDP`, `tel`) VALUES (?, ?, ?, ?, ?)";
// PreparedStatement statement = conn.prepareStatement(sql);
// statement.setString(1, "99");
// statement.setString(2, "Thiebaut");
// statement.setString(3, "Matteo");
// statement.setString(4, "10112000");
// statement.setString(5, "22222");

// int rowsInserted = statement.executeUpdate();
// if (rowsInserted > 0) {
// System.out.println("A new user was inserted successfully!");
// }

// } catch (SQLException ex) {
// ex.printStackTrace();
// }