package co.com.hotelAlura.jdbc.controller;

import co.com.hotelAlura.jdbc.dao.ReservaDAO;
import co.com.hotelAlura.jdbc.model.ReservasModel;
import co.com.hotelAlura.views.RegistroHuesped;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    public List<ReservasModel> traerTodasReservas(){
        List<ReservasModel> reservas = null;
        try{
            reservas = reservaDAO.obtenerTodasReservas();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return reservas;
    }

    public List<ReservasModel> traerReservasFiltro(int id) {
        ReservaDAO reservaDAO = new ReservaDAO();
        List<ReservasModel> reservas = new ArrayList<>();
        try {
            reservas = reservaDAO.obtenerReservasFiltro(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
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
