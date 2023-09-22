package co.com.hotelAlura.jdbc.controller;
import co.com.hotelAlura.jdbc.dao.HuespedesDAO;
import co.com.hotelAlura.jdbc.model.ReservasModel;
import java.sql.SQLException;
import java.util.Date;

public class HuespedesController {

    private HuespedesDAO huespedesDAO;

    public HuespedesController(HuespedesDAO huespedesDAO){this.huespedesDAO = huespedesDAO;}
}
