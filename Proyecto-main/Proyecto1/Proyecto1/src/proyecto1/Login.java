package proyecto1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    
    private final Connection connection;

    public Login(Connection connection) {
        this.connection = connection;
    }



    public boolean iniciarSesion(String usuario, String contrasena) {
        try {
            String query = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next(); 
        } catch (SQLException e) {
            System.err.println("Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }
}