<?php

class Bdd
{
    private $dbh;

    public function __construct()
    {
        try {
            $this->dbh = new PDO("mysql:dbname=ppe;host=127.0.0.1;charset=utf8", "root", "");
        } catch (PDOException $e) {
            echo 'Connexion échouée : ' . $e->getMessage();
            // Fonction connexion à la base de données si la connexion ne fonctionne pas 
            // On affiche : 'Connexion échouée'
        }
    }

    public function getlogin($login, $password)
    {
        $req = "SELECT fk_me , lo_password FROM login WHERE fk_me = :fk_me AND lo_password = :password_log";
        $res = $this->dbh->prepare($req);
        $res->execute([":fk_me" => $login, ":password_log" => $password]);
        $userexist = $res->rowCount();
        if ($userexist == 1) {
            $_SESSION['connect'] = true;
            header('Location: ./Controller/depo_control.php');
            exit;
        } else {
            echo '<span style="color: red;">Erreur: Identifiant ou mot de passe non valide.</span>';
            // Fonction de connexion avec identifiant et mot de passe en comparant avec la base de données.
            // Si l'identifiant est incorrecte on affiche : 'Erreur: Identifiant ou mot de passe non valide.'
        }
    }

    public function getlogout()
    {
        session_destroy();
        header('Location: ../index.php');
        exit;
        // Fonction de déconnexion, on detruit la session actuelle.
    }

    public function getAllEntrepot()
    {
        $ret = $this->dbh->query('SELECT en_id, en_nom, en_localisation  FROM entrepots order by en_nom ASC', PDO::FETCH_ASSOC);
        return $ret->fetchAll();
        // requête SQL permettant de récupérer la liste des entrepôts.
    }

    public function getAllProduits($entrepot)
    {
        $req = "SELECT fk_pr, pr_nom, CONCAT(fk_mo,fk_ra,fk_se,'.',fk_et) as pr_lieux, quantité, pr_id FROM comprend JOIN produits ON fk_pr = pr_id WHERE fk_en = :id";
        $res = $this->dbh->prepare($req);
        $res->execute([":id" => $entrepot]);
        return $res->fetchAll();
        // requête SQL permettant de récupérer la liste des produits.
    }

    public function getDetailsProduits($produit)
    {
        $req = "SELECT  pr_id, pr_nom, pr_referece, pr_nomFournisseur, pr_cout, pr_unitaire, pr_description FROM produits WHERE pr_id = :id";
        $res = $this->dbh->prepare($req);
        $res->execute([":id" => $produit]);
        return $res->fetchAll();
        // requête SQL permettant de récupérer les détails des produits.
    }

    public function getProduitsQuant($id_produit)
    {
        $req = "SELECT quantité FROM comprend JOIN produits ON fk_pr = pr_id WHERE fk_pr = :id";
        $res = $this->dbh->prepare($req);
        $res->execute([":id" => $id_produit]);
        $all = $res->fetchAll();
        $counter_quant = 0;
        foreach ($all as $quant) {
            $counter_quant +=  $quant['quantité'];
        }
        return $counter_quant;
        // requête SQL permettant de récupérer la quantité des produits.
    }
}
