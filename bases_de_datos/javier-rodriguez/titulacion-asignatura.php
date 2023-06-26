<style><?php include 'C:/xampp/htdocs/javier-rodriguez/estilos/styles.css'; ?></style>

<?php
$conexion = mysqli_connect("localhost", "root", "", "universidad");

if (mysqli_connect_error()) {
    printf("MySQL connection failed with the error: %s", mysqli_connect_error());
    exit;
}

// Verificar si se envió el formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Obtener el grado seleccionado desde el formulario
  $grado = $_POST['grado'];

  // Escapar caracteres especiales para evitar inyección de SQL
  $grado = mysqli_real_escape_string($conexion, $grado);

  // Definir la consulta para obtener las asignaturas del grado seleccionado
  $sql = "SELECT a.nombre AS asignatura, g.nombre AS grado
          FROM asignatura AS a
          JOIN grado AS g ON a.id_grado = g.id
          WHERE g.nombre = '$grado'";

  // Ejecutar la consulta
  $result = mysqli_query($conexion, $sql);

  // Verificar si se obtuvieron resultados
  if (mysqli_num_rows($result) > 0) {

    // Mostrar el grado seleccionado
    echo "<div class='gradient'></div><div class='container'><div class='content-php'>";
    echo "<h2>Asignaturas para el Grado seleccionado:</h2><br>";
    // Mostrar las asignaturas correspondientes
    echo "<ul>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<li>" . $row["asignatura"] . "</li>";
    }
    echo "</ul>";
  } else {
    // Si no se encontraron asignaturas, mostrar un mensaje de error
    echo "No se encontraron asignaturas para el grado seleccionado.";
  }
  echo "<button><a href='index.html'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'><path d='M3 9l9-7 9 7v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9z'/><polyline points='9 22 9 12 15 12 15 22'/></svg>&nbsp;&nbsp;Inicio</a></button>";
  echo "</div></div>";
}

// Cerrar la conexión a la base de datos
mysqli_close($conexion);
?>