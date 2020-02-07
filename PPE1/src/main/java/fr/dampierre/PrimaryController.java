package fr.dampierre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
    void OnActionClickConnexion(ActionEvent event) {
        // connexion();
    }

    // public void connexion() {
    //     String dbURL = "jdbc:mysql://localhost:8889/salon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //     Statement statement = conn.createStatement();
    //     ResultSet result = statement.executeQuery(sql);
    //     String username = result.getString(1);
    //     String password = result.getString(2);
    //     if (username == "root" && password == "root") {
    //         try {
    //             Connection conn = DriverManager.getConnection(dbURL, username, password);
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

}