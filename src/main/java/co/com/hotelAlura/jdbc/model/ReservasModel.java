package co.com.hotelAlura.jdbc.model;
import java.util.Date;

public class ReservasModel {
    private int id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double valor;
    private String formaPago;

    public ReservasModel() {
    }

    public ReservasModel(Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public int getId(){
        return id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setId(int id) {
        this.id = id;
    }
}
