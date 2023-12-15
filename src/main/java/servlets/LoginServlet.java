package servlets;

import entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.example.web.Gestor_Usuario;
//import com.example.web.Usuario;

import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public static Gestor_Usuario gestor_usuario = new Gestor_Usuario();
    public static Usuario usuario;

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("registro.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario = solicitud.getParameter("user");
        String contrasenia = solicitud.getParameter("contrasenia");
        entities.Usuario usuario = gestor_usuario.buscar(nombreUsuario, contrasenia);
        //boolean credencialesValidas = esCredencialesValidas(usuario, nombreUsuario, contrasenia);
        HttpSession miSesion = solicitud.getSession();
        if (usuario != null) {
            miSesion.setAttribute("loginUser", usuario);
            LoginServlet.usuario = usuario;
            respuesta.sendRedirect("cuentaUser.jsp");
        } else {
            miSesion.setAttribute("Error", "Las credenciales no son validas");
            respuesta.sendRedirect("index.jsp");
        }

    }


}
