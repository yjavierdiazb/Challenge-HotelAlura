package co.com.hotelAlura.jdbc.dao;
import co.com.hotelAlura.jdbc.factory.ConnectionFactory;
import co.com.hotelAlura.jdbc.model.HuespedesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HuespedesDAO {

    public void agregarHuesped(HuespedesModel huespedesModel) throws SQLException{
        String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, huespedesModel.getNombre());
            statement.setString(2, huespedesModel.getApellido());
            statement.setDate(3, new java.sql.Date(huespedesModel.getFecha_nacimiento().getTime()));
            statement.setString(4,huespedesModel.getNacionalidad());
            statement.setInt(5,huespedesModel.getTelefono());

            statement.executeUpdate();
        }   catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}
