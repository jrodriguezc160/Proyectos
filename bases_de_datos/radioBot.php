<?php
$conexion = mysqli_connect("localhost", "root", "", "ventas");

if (mysqli_connect_errno()) {
    printf("MySQL connection failed with the error: %s", mysqli_connect_error());
    exit;
} else {
    echo "Conexión establecida" . "<br>";
}

$Elemento = $_POST["apartado"];
$Antiguo = $_POST["antiguo"];
$Nuevo = $_POST["nuevo"];

$select_query = "SELECT * FROM cliente";
$result = mysqli_query($conexion, $select_query);

if ($Elemento == 'nombre') {
    $edit_query = "UPDATE cliente SET nombre = '$Nuevo' WHERE nombre = '$Antiguo'";
} elseif ($Elemento == 'apell1') {
    $edit_query = "UPDATE cliente SET apellido1 = '$Nuevo' WHERE apellido1 = '$Antiguo'";
} elseif ($Elemento == 'apell2') {
    $edit_query = "UPDATE cliente SET apellido2 = '$Nuevo' WHERE apellido2 = '$Antiguo'";
} elseif ($Elemento == 'cate') {
    $edit_query = "UPDATE cliente SET categoria = '$Nuevo' WHERE categoria = '$Antiguo'";
} else {
    echo "No se ha actualizado";
}

if (isset($edit_query) && mysqli_query($conexion, $edit_query)) {
    echo 'Registro actualizado exitosamente.';
} else {
    echo 'Error';
}

while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
    echo "id: " . $row['id'] . "<br/>";
    echo "Nombre: " . $row['nombre'] . "<br/>";
    echo "Apellido1: " . $row['apellido1'] . "<br/>";
    echo "Apellido2: " . $row['apellido2'] . "<br/>";
    echo "Categoria: " . $row['categoría'] . "<br/>";
    echo "Ciudad: " . $row['ciudad'] . "<br/>";
    echo "<br/>";
}

// Cerrar la conexión a la base de datos
mysqli_close($conexion);
?>
