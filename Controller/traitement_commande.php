<?php
    header('Content-Type: application/json');
    include_once "../Model/bdd.php";
    
    $bdd = new Bdd();
    $latitude = htmlspecialchars($_GET['lat']);
    $longitude = htmlspecialchars($_GET['long']);
    $bdd->getstockbylocalisation($latitude, $longitude);

?>