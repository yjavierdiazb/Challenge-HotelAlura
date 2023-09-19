package co.com.hotelAlura.jdbc.dao;

import co.com.hotelAlura.jdbc.factory.ConnectionFactory;
import co.com.hotelAlura.jdbc.model.ReservasView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {
    public void agregarReserva(ReservasView reservasView) throws SQLException {
        String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_de_pago) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
             statement.setDate(1, new java.sql.Date(reservasView.getFechaEntrada().getTime()));
             statement.setDate(2, new java.sql.Date(reservasView.getFechaSalida().getTime()));
             statement.setDouble(3, reservasView.getValor());
             statement.setString(4, reservasView.getFormaPago());

             statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void eliminarReserva(ReservasView reservasView) throws SQLException{
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, reservasView.getId());;
            statement.executeUpdate();
        } catch(SQLException e){
            throw e;
        }
    }




}
