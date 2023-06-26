package app1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

public class Ficheros {

    public static void save(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
        // Usamos las colecciones del Main: alineacion y equipos
        try {
            FileOutputStream fileOut = new FileOutputStream("datos.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // Guardar las colecciones en el archivo
            objectOut.writeObject(alineacion);
            objectOut.writeObject(equipos);

            // Cerramos el flujo
            objectOut.close();
            fileOut.close();

            System.out.println("Datos guardados correctamente en el archivo 'datos.bin'.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public static void load(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
        try {
            FileInputStream fileIn = new FileInputStream("datos.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Cargar las colecciones desde el archivo
            ArrayList<Futbolista> alineacionCargada = (ArrayList<Futbolista>) objectIn.readObject();
            ArrayList<Equipo> equiposCargados = (ArrayList<Equipo>) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            // Limpiar las colecciones existentes
            alineacion.clear();
            equipos.clear();

            // Agregar los datos cargados a las colecciones existentes
            alineacion.addAll(alineacionCargada);
            equipos.addAll(equiposCargados);

            // Utilizar los datos cargados
            // Ejemplo: Imprimir la alineación y los equipos
            System.out.println("Alineación:");
            for (Futbolista futbolista : alineacion) {
                System.out.println(futbolista);
            }

            System.out.println("\nEquipos:");
            for (Equipo equipo : equipos) {
                System.out.println(equipo);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

}
