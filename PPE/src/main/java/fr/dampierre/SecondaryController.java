package fr.dampierre;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SecondaryController {
    ConnexionBdd connexion = new ConnexionBdd("ppetheo", "ppetheo");
    
    @FXML
	static void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void OnActionClickDeconnexion(ActionEvent event) throws SQLException, IOException {
        switchToPrimary();
    }

    class Visiteur {
        @FXML
        private TextField Txmatricule;
        @FXML
        private TextField TxNom;
        @FXML
        private TextField TxPrénom;
        @FXML
        private TextField TxMotDePasse;
    }

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