<!DOCTYPE html>
<html>
<head>
	<title><?php echo $title; ?></title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="../View/css/show_table.css">
</head>
<body>
<section>
  <h1>LISTE DES PRODUITS</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>ID produit</th>
          <th>Nom produit</th>
          <th>Localisation produit</th>
          <th>Quantité produit</th>
          <th></th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <?php
        foreach ($produits as $produit)
        {
        	echo '<tr>';
        	echo '<td>'.$produit['fk_pr'].'</td>';
        	echo '<td>'.$produit['pr_nom'].'</td>';
        	echo '<td>'.$produit['pr_lieux'].'</td>';
          echo '<td>'.$produit['quantité'].'</td>';
          echo '<td><a href="details-produit.php?id='.$produit['pr_id'].'">Fiche</a></td>';
        	echo '</tr>';
        }
        ?>
      </tbody>
    </table>
  </div>
    <form>
        <input class="goback" type="button" value="Retour" onclick="history.go(-1)">
      </form>
</section>

<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="../View/js/show_table.css"></script>
</body>
</html>