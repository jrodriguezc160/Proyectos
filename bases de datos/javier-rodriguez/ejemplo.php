<?php

$conexion =mysqli_connect("localhost", "root","", "universidad");
if (mysqli_connect_errno())
{
printf("MySQL connection failed with the error: %s",
mysqli_connect_error());
 exit;
}
$nombre=$_POST['nombre'];
$creditos=$_POST['creditos'];
$tipo=$_POST['tipo'];
$curso=$_POST['curso'];
$cuatrimestre=$_POST['cuatrimestre'];





$sql = "INSERT INTO asignatura (nombre, creditos, tipo, curso, cuatrimestre, id_profesor, id_grado)
        VALUES ('$nombre', '$creditos', '$tipo', '$curso', '$cuatrimestre', '3', '5')";

if ($conexion->query($sql) === TRUE) {
    echo "Asignatura insertada correctamente.";
} else {
    echo "Error al insertar la Asignatura: " . $conexion->error;
}
mysqli_close($conexion);

?>
