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
  $asignatura = $_POST['asignatura'];

  // Escapar caracteres especiales para evitar inyección de SQL
  $asignatura = mysqli_real_escape_string($conexion, $asignatura);

  // Definir la consulta para obtener los profesores del departamento
  $sql = "SELECT per.nombre, per.id, per.nif, per.apellido1, per.apellido2, per.ciudad, per.direccion, per.telefono, 
  per.fecha_nacimiento, per.sexo FROM persona as per, alumno_se_matricula_asignatura as mat, asignatura as asig
  WHERE asig.nombre = '$asignatura' AND asig.id = mat.id_asignatura AND mat.id_alumno = per.id";

  // Ejecutar la consulta
  $result = mysqli_query($conexion, $sql);

  // Verificar si se obtuvieron resultados
  if (mysqli_num_rows($result) > 0) {
    // Mostrar el grado seleccionado
    echo "<div class='gradient'></div><div class='container'><div class='content-php'>";
    echo "<h2>Alumnos de Asignaturas</h2>";
    echo "<ul>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<li>" . $row["id"] ;
        echo " - " . $row["nif"] ;
        echo " - " . $row["nombre"] ;
        echo " - " . $row["apellido1"] ;
        echo " - " . $row["apellido2"] ;
        echo " - " . $row["ciudad"] ;
        echo " - " . $row["direccion"] ;
        echo " - " . $row["telefono"] ;
        echo " - " . $row["fecha_nacimiento"] ;
        echo " - " . $row["sexo"] . "</li>";

    }
    echo "</ul>";
  } else {
    // Si no se encontraron profesores, mostrar un mensaje de error
    echo "No se econtraron alumnos de estas asignaturas.";
  }
  echo "<button><a href='index.html'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'><path d='M3 9l9-7 9 7v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9z'/><polyline points='9 22 9 12 15 12 15 22'/></svg>&nbsp;&nbsp;Inicio</a></button>";
  echo "</div></div>";
}

// Cerrar la conexión a la base de datos
mysqli_close($conexion);
?>