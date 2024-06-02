package proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conection {
    private static final String URL = "jdbc:mysql://localhost:3306/dataestudiantes";
    private static final String USER = "root";
    private static final String PASSWORD = "Joder26.";

    static void obtenerConexion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Connection connection;

    public Conection() {
        try {
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }


    public Connection getConnection() {
        return connection;
    }

   
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
       
        Conection dbConnection = new Conection();

        Connection conn = dbConnection.getConnection();

       

      
        dbConnection.closeConnection();
    }

    PreparedStatement prepareStatement(String select__from_estudiantes) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }
}
