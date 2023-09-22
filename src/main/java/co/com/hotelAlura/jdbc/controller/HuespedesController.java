package co.com.hotelAlura.jdbc.controller;
import co.com.hotelAlura.jdbc.dao.HuespedesDAO;
import co.com.hotelAlura.jdbc.model.HuespedesModel;
import co.com.hotelAlura.jdbc.model.ReservasModel;
import java.sql.SQLException;
import java.util.Date;

public class HuespedesController {

    private HuespedesDAO huespedesDAO;

    public HuespedesController(HuespedesDAO huespedesDAO){this.huespedesDAO = huespedesDAO;}

    public void realizarRegistroHuesped(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono, int id_reserva){
        try{
            HuespedesModel huespedesModel = new HuespedesModel(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva);
            huespedesDAO.agregarHuesped(huespedesModel);
        }   catch (SQLException e){
            e.printStackTrace();
        }
    }
}
