### Página HTML -> diseño parecido al JavaDoc

### Opciones
- Matricular a un alumno
- Contratar a un profesor
- Mostrar
    - Dada una titulación → mostar sus asignaturas
    - Dada una asignatura → mostrar sus alumnos con su nº de alumnos
    - Dado un departamento → mostrar sus profesores con su nº de profesor y sus datos

### Matricular a un alumno
    (formulario en el que recogemos las variables para las inserciones de SQL)
    (en el formulario incluimos un desplegable con 3 asignaturas)
    +-----------------+
    | Matemáticas     | -> id="id_mat", name="id_asignatura"; $id_asignatura = id_asignatura;
    | ...             |
    +-----------------+
    INSERT INTO persona VALUES ('$id', '$nif', '$nombre', '$apellido1', '$apellido2', '$ciudad', '$direccion', '$telefono', '$fecha_nacimiento', '$sexo', '$tipo');
    INSERT INTO alumno_se_matricula_en_asignatura VALUES ('$id', '$id_asignatura', 'id curso escolar que exista');


### Contratar a un profesor
    (formulario en el que recogemos las variables para las inserciones de SQL)
    (en el formulario incluimos un desplegable con 3 departamentos)
    +---------------------------------+
    | Departamento de Matemáticas     | -> id="id_departamento_mat", name="id_departamento"; $id_departamento = id_departamento;
    | ...                             |
    +---------------------------------+
    INSERT INTO persona VALUES ('$id', '$nif', '$nombre', '$apellido1', '$apellido2', '$ciudad', '$direccion', '$telefono', '$fecha_nacimiento', '$sexo', '$tipo');
    INSERT INTO profesor VALUES ('$id', '$id_departamento');



### Mostrar

### Dada una titulación → mostar sus asignaturas
    radio





### Ejemplo
ejemplo de php

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

:)
