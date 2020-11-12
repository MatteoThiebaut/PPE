<!DOCTYPE html>
<html>

<head>
  <title><?php echo $title; ?></title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="../View/css/show_table.css">
</head>

<!--
  depo.php est un HTML structurant le tableau permettant d'afficher :
  la Liste des entrepôts, le nom de l'entrepôt et la localisation de
  l'entrepôt concerné. Cet HTML est relié à un CSS pour le désign.
 -->

<body>
  <section>
    <h1>LISTE DES ENTREPÔTS</h1>
    <div class="tbl-header">
      <table cellpadding="0" cellspacing="0" border="0">
        <thead>
          <tr>
            <th>Nom entrepôt</th>
            <th>Localisation entrepôt</th>
            <th></th>
          </tr>
        </thead>
      </table>
    </div>
    <div class="tbl-content">
      <table cellpadding="0" cellspacing="0" border="0">
        <tbody>
          <?php
          foreach ($entrepots as $entrepot) {
            echo '<tr>';
            echo '<td>' . $entrepot['en_nom'] . '</td>';
            echo '<td>' . $entrepot['en_localisation'] . '</td>';
            echo '<td><a href="list-produit.php?id=' . $entrepot['en_id'] . '">Détails</a></td>';
            echo '</tr>';
          }
          ?>
        </tbody>
      </table>
    </div>
  </section>

  <!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="../View/js/show_table.css"></script>
</body>

</html>