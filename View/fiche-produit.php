<!DOCTYPE html>
<html>
<head>
	<title><?php echo $title; ?></title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="../View/css/show_table.css">
</head>
<body>
<section>
  <h1>DÉTAILS DU PRODUIT</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nom</th>
          <th>Référence</th>
          <th>Fournisseur</th>
          <th>Coût</th>
          <th>Prix unitaire</th>
          <th>Description</th>
          <th>Quantité</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <?php
        foreach ($produit_détails as $produit_détail)
        {
        	echo '<tr>';
        	echo '<td>'.$produit_détail['pr_id'].'</td>';
        	echo '<td>'.$produit_détail['pr_nom'].'</td>';
        	echo '<td>'.$produit_détail['pr_referece'].'</td>';
          echo '<td>'.$produit_détail['pr_nomFournisseur'].'</td>';
          echo '<td>'.$produit_détail['pr_cout'].'</td>';
          echo '<td>'.$produit_détail['pr_unitaire'].'</td>';
          echo '<td>'.$produit_détail['pr_description'].'</td>';
          echo '<td>'.$getAllProduits.'</td>';
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