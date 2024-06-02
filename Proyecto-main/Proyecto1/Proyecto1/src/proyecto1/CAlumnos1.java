package proyecto1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CAlumnos1 {

    private final Connection connection;

    public CAlumnos1(Connection connection) {
        this.connection = connection;
    }

    public void insertarAlumno(int carnet, String primerNombre, String segundoNombre, String tercerNombre,
                               String primerApellido, String segundoApellido, String tercerApellido,
                               String fechaNacimiento, String direccion, int semestre, String facultad) {
        try {
            String query = "INSERT INTO students (carnet, primer_nombre, segundo_nombre, tercer_nombre, " +
                    "primer_apellido, segundo_apellido, tercer_apellido, fecha_de_nacimiento, direccion, " +
                    "semestre, facultad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, carnet);
            statement.setString(2, primerNombre);
            statement.setString(3, segundoNombre);
            statement.setString(4, tercerNombre);
            statement.setString(5, primerApellido);
            statement.setString(6, segundoApellido);
            statement.setString(7, tercerApellido);
            statement.setString(8, fechaNacimiento);
            statement.setString(9, direccion);
            statement.setInt(10, semestre);
            statement.setString(11, facultad);

            statement.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    public void actualizarAlumno(int carnet, String columna, String nuevoValor) {
        try {
            String query = "UPDATE students SET " + columna + " = ? WHERE carnet = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nuevoValor);
            statement.setInt(2, carnet);

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Alumno actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún alumno con ese carnet.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar alumno: " + e.getMessage());
        }
    }

    public void leerAlumnos() {
        try {
            String query = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Lista de Alumnos:");
            System.out.println("Carnet\tNombre\tApellido\tFecha de Nacimiento\tDirección\tSemestre\tFacultad");
            while (resultSet.next()) {
                int carnet = resultSet.getInt("carnet");
                String primerNombre = resultSet.getString("primer_nombre");
                String primerApellido = resultSet.getString("primer_apellido");
                String fechaNacimiento = resultSet.getString("fecha_de_nacimiento");
                String direccion = resultSet.getString("direccion");
                int semestre = resultSet.getInt("semestre");
                String facultad = resultSet.getString("facultad");

                System.out.println(carnet + "\t" + primerNombre + "\t" + primerApellido + "\t" + fechaNacimiento + "\t" + direccion + "\t" + semestre + "\t" + facultad);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer alumnos: " + e.getMessage());
        }
    }

    public void eliminarAlumno(int carnet) {
        try {
            String query = "DELETE FROM students WHERE carnet = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, carnet);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Alumno eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún alumno con ese carnet.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar alumno: " + e.getMessage());
        }
    }
}
