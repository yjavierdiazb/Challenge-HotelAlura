package co.com.hotelAlura.jdbc.controller;

import co.com.hotelAlura.jdbc.dao.ReservaDAO;
import co.com.hotelAlura.jdbc.model.ReservasView;

import java.sql.SQLException;
import java.util.Date;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public void realizarReserva(Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
        try {
            ReservasView reservasView = new ReservasView(fechaEntrada, fechaSalida, valor, formaPago);
            reservaDAO.agregarReserva(reservasView);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
