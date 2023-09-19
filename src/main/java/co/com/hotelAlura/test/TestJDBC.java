package co.com.hotelAlura.test;

import co.com.hotelAlura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Consulta SQL para seleccionar todos los registros de la tabla "usuarios".
            String sql = "SELECT * FROM usuarios";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    // Obtén los datos de cada fila.
                    int id = resultSet.getInt("id_usuario");
                    String nombre = resultSet.getString("usuario");

                    // Imprime los datos o realiza cualquier otra acción que necesites.
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
