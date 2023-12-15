package servlets;

import com.example.web.Gestor_Usuario;
//import com.example.web.Usuario;

import entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    Gestor_Usuario gestorUsuario = new Gestor_Usuario();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcion = req.getParameter("mostrar");
        if (opcion != null) {
            HttpSession misesion = req.getSession();
            misesion.setAttribute("listaUsuarios", LoginServlet.gestor_usuario.getUsuarios());
            resp.sendRedirect("mostrarUsuarios.jsp");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        Usuario usuario = registrarUsuario(solicitud);
        HttpSession misesion = solicitud.getSession();
        misesion.setAttribute("registro", usuario);
        gestorUsuario.insertar(usuario);
        respuesta.sendRedirect("registro.jsp");
    }

    public Usuario registrarUsuario(HttpServletRequest solicitud) {

        String nombre = solicitud.getParameter("nombre");
        String apellido = solicitud.getParameter("apellido");
        String cedula = solicitud.getParameter("cedula");
        String correo = solicitud.getParameter("correo");
        String modo = solicitud.getParameter("tipoUser");
        String telefono = solicitud.getParameter("telf");
        String usuario = solicitud.getParameter("user");
        String contrasenia = solicitud.getParameter("contrasenia");

        return new Usuario(usuario, contrasenia, nombre, apellido, cedula, correo, Integer.parseInt(telefono), modo, null);
    }
}
