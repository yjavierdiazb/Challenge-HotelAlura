package co.com.hotelAlura.jdbc.dao;
import co.com.hotelAlura.jdbc.factory.ConnectionFactory;
import co.com.hotelAlura.jdbc.model.HuespedesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HuespedesDAO {

    public void agregarHuesped(HuespedesModel huespedesModel) throws SQLException{
        String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, huespedesModel.getNombre());
            statement.setString(2, huespedesModel.getApellido());
            statement.setDate(3, new java.sql.Date(huespedesModel.getFecha_nacimiento().getTime()));
            statement.setString(4,huespedesModel.getNacionalidad());
            statement.setString(5, huespedesModel.getTelefono());
            statement.setInt(6,huespedesModel.getId_reserva());

            statement.executeUpdate();
        }   catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<HuespedesModel> obtenerTodosHuespedes() throws SQLException{
        String sql = "SELECT * FROM huespedes";
        List<HuespedesModel> huespedes = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()){
                    HuespedesModel huesped = new HuespedesModel();
                    huesped.setId(resultSet.getInt("id"));
                    huesped.setNombre(resultSet.getString("nombre"));
                    huesped.setApellido(resultSet.getString("apellido"));
                    huesped.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                    huesped.setNacionalidad(resultSet.getString("nacionalidad"));
                    huesped.setTelefono(resultSet.getString("telefono"));
                    huesped.setId_reserva(resultSet.getInt("id_reserva"));
                    huespedes.add(huesped);
                }
            }
            catch(SQLException e){
                e.printStackTrace();
                throw e;
            }
        }
        return huespedes;
    }

    public List<HuespedesModel> obtenerHuespedesFiltro(int id) throws SQLException{
        String sql = "SELECT * FROM huespedes WHERE id = ?";
        List<HuespedesModel> huespedes = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    HuespedesModel huesped = new HuespedesModel();
                    huesped.setId(resultSet.getInt("id"));
                    huesped.setNombre(resultSet.getString("nombre"));
                    huesped.setApellido(resultSet.getString("apellido"));
                    huesped.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                    huesped.setNacionalidad(resultSet.getString("nacionalidad"));
                    huesped.setTelefono(resultSet.getString("telefono"));
                    huesped.setId_reserva(resultSet.getInt("id_reserva"));
                    huespedes.add(huesped);
                }
            }
        }
        return huespedes;
    }

}
