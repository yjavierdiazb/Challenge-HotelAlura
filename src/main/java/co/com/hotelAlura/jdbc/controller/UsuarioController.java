package co.com.hotelAlura.jdbc.controller;
import co.com.hotelAlura.jdbc.dao.UsuarioDAO;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController(){
        usuarioDAO = new UsuarioDAO();
    }

    public boolean autenticarUsuario(String usuario, String contrasena){
        return usuarioDAO.autenticarUsuario(usuario,contrasena);
    }
}
