package co.com.hotelAlura.jdbc.dao;

import co.com.hotelAlura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
        public boolean autenticarUsuario(String usuario, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si existe un registro, las credenciales son válidas
            }
        } catch (SQLException e) {
            // Manejo de excepciones, por ejemplo, logueo o lanzar una excepción personalizada
            e.printStackTrace();
            return false;
        }
    }
}

