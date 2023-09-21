package co.com.hotelAlura.jdbc.dao;

import co.com.hotelAlura.jdbc.factory.ConnectionFactory;
import co.com.hotelAlura.jdbc.model.ReservasModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ReservaDAO {
    public void agregarReserva(ReservasModel reservasModel) throws SQLException {
        String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_de_pago) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
             statement.setDate(1, new java.sql.Date(reservasModel.getFechaEntrada().getTime()));
             statement.setDate(2, new java.sql.Date(reservasModel.getFechaSalida().getTime()));
             statement.setDouble(3, reservasModel.getValor());
             statement.setString(4, reservasModel.getFormaPago());

             statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int obtenerUltimoNumeroReserva() throws SQLException {
        String sql = "SELECT MAX(id) AS ultimo_numero_reserva FROM reservas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("ultimo_numero_reserva");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return -1;
    }

    public void eliminarReserva(ReservasModel reservasModel) throws SQLException{
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, reservasModel.getId());;
            statement.executeUpdate();
        } catch(SQLException e){
            throw e;
        }
    }




}
