package co.com.hotelAlura.jdbc.controller;

import co.com.hotelAlura.jdbc.dao.ReservaDAO;
import co.com.hotelAlura.jdbc.model.ReservasModel;
import co.com.hotelAlura.views.RegistroHuesped;


import java.sql.SQLException;
import java.util.Date;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public void realizarReserva(Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
        try {
            ReservasModel reservasModel = new ReservasModel(fechaEntrada, fechaSalida, valor, formaPago);
            reservaDAO.agregarReserva(reservasModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerYMostrarUltimoNumeroReserva() {
        try {
            int ultimoNumeroReserva = reservaDAO.obtenerUltimoNumeroReserva();
            if (ultimoNumeroReserva != -1) {
                System.out.println("El último número de reserva generado es: " + ultimoNumeroReserva);
                return ultimoNumeroReserva;
            } else {
                System.out.println("No se pudo obtener el último número de reserva.");
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
