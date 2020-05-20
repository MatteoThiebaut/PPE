package fr.dampierre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SecondaryController {
    private static final String Visiteur = null;
    ConnexionBdd connexion = new ConnexionBdd("ppetheo", "ppetheo");
    
    @FXML
	static void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void OnActionClickDeconnexion(ActionEvent event) throws SQLException, IOException {
        switchToPrimary();
    }
    @FXML
    static void switchToValider() throws IOException {
        App.setRoot("valider");
    }
    @FXML
    void OnActionClickValider(ActionEvent event) throws SQLException, IOException {
        insertVisiteur();
        switchToValider();
    }
            

    // class Visiteur {
        @FXML
        private TextField Txmatricule;
        @FXML
        private TextField TxNom;
        @FXML
        private TextField TxPrénom;
        @FXML
        private TextField TxMotDePasse;
        @FXML
        private TextField TxTelephone;

        public void insertVisiteur() throws SQLException {
                Connection conn= ConnexionBdd.getConn();
                String sqlVisiteur = "INSERT INTO Visiteur (VI_Nom, VI_Prenom) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(sqlVisiteur);
                statement.setString(2, TxNom.getText());
                statement.setString(3, TxPrénom.getText());
                // statement.setString(4, TxTelephone.getText());
            }
        // }
   


    class frais {
        @FXML
        private TextField TxNuitéeQuantitée;
        @FXML
        private TextField TxRepasQuantité;
        @FXML
        private TextField TxKilometrageQuantité;
        @FXML
        private TextField TxNuitéeMontantUnitaire;
        @FXML
        private TextField TxRepasMontantUnitaire;
        @FXML
        private TextField TxKilometrageMontantUnitaire;
        @FXML
        private TextField TxNuitéeTotal;
        @FXML
        private TextField TxRepasTotal;
        @FXML
        private TextField TxKilometrageTotal;
    }

    class autrefrais {
        @FXML
        private TextField TxLibellé1;
        @FXML
        private TextField TxMontant1;
        @FXML
        private TextField TxDate1;
        @FXML
        private TextField TxLibellé2;
        @FXML
        private TextField TxDate2;
        @FXML
        private TextField TxMontant2;
        @FXML
        private TextField TxLibellé3;
        @FXML
        private TextField TxMontant3;
        @FXML
        private TextField TxDate3;

    }

    @FXML
    private TextField TxMois;




}
