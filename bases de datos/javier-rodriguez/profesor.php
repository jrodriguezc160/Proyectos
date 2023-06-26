<style><?php include 'C:/xampp/htdocs/javier-rodriguez/estilos/styles.css'; ?></style>

<?php
$conexion = mysqli_connect("localhost", "root", "", "universidad");
if (mysqli_connect_error()) {
    printf("MySQL connection failed with the error: %s", mysqli_connect_error());
    exit;
}

// Verificar la conexión
if ($conexion->connect_error) {
    die("La conexión a la base de datos ha fallado: " . $conexion->connect_error);
}

// Procesar el formulario cuando se envía
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtener los valores del formulario
    $nif = $_POST["nif"];
    $apellido1 = $_POST["apellido1"];
    $ciudad = $_POST["ciudad"];
    $fecha_nacimiento = $_POST["fecha_nacimiento"];
    $sexo = $_POST["sexo"];
    $nombre = $_POST["nombre"];
    $apellido2 = $_POST["apellido2"];
    $direccion = $_POST["direccion"];
    $telefono = $_POST["telefono"];
    $tipo = "profesor";
    $departamento = $_POST["departamento"];

    if ($sexo == "hombre") {
        $sexo = "H";
    } elseif ($sexo == "mujer") {
        $sexo = "M";
    }

    if ($departamento == "Informática") {
        $departamento = 1;
        } elseif ($departamento == "Matemáticas") {
            $departamento = 2;
        } elseif ($departamento == "Economía y empresa") {
            $departamento = 3;
        } elseif ($departamento == "Educación") {
            $departamento = 4;
        } elseif ($departamento == "Agronomía") {
            $departamento = 5;
        } elseif ($departamento == "Química y Física") {
            $departamento = 6;
        } elseif ($departamento == "Filología") {
            $departamento = 7;
        } elseif ($departamento == "Derecho") {
            $departamento = 8;
        } elseif ($departamentoa == "Biología y geología") {
            $departamento = 9;
        }

    // Crear la consulta SQL para insertar los datos en la tabla "persona"
    $sql = "INSERT INTO persona (nif, apellido1, ciudad, fecha_nacimiento, sexo, nombre, apellido2, direccion, telefono, tipo)
            VALUES ('$nif', '$apellido1', '$ciudad', '$fecha_nacimiento', '$sexo', '$nombre', '$apellido2', '$direccion', '$telefono', '$tipo')";

    // Insertar la persona en la tabla "persona"
    if ($conexion->query($sql) === TRUE) {
        $id_profesor = $conexion->insert_id; // Obtener el ID del último registro insertado en la tabla "persona"

        // Crear la consulta SQL para insertar el profesor en la tabla "departamento"
        echo "<div class='gradient'></div><div class='container'><div class='content-php'>";
        $sql_profesor = "INSERT INTO profesor (id_profesor, id_departamento) VALUES ('$id_profesor', '$departamento')";

        // Insertar el profesor en la tabla "departamento"
        if ($conexion->query($sql_profesor) === TRUE) {
            echo "Los datos se han registrado correctamente en la base de datos.";
        } else {
            echo "Error al registrar el profesor en el departamento: " . $conexion->error;
        }

    } else {
        echo "Error al registrar los datos en la base de datos: " . $conexion->error;
    }
    echo "<button><a href='index.html'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'><path d='M3 9l9-7 9 7v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9z'/><polyline points='9 22 9 12 15 12 15 22'/></svg>&nbsp;&nbsp;Inicio</a></button>";
    echo "</div></div>";

    // Cerrar la conexión a la base de datos
    $conexion->close();
}
?>