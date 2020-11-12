<?php
session_start();
include_once "../Model/bdd.php";

$bdd = new Bdd();
$bdd->getlogout();
    // système de logout
