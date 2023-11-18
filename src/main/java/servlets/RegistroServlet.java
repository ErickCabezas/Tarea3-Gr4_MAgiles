package servlets;

import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name="RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcion=req.getParameter("mostrar");
        if(opcion!=null){
            HttpSession misesion= req.getSession();
            misesion.setAttribute("listaUsuarios", LoginServlet.gestor_usuario.getUsuarios());
            resp.sendRedirect("mostrarUsuarios.jsp");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession misesion= solicitud.getSession();
        misesion.setAttribute("registro", RegistrarUsuario(solicitud));
        respuesta.sendRedirect("registro.jsp");
    }
    public String RegistrarUsuario(HttpServletRequest solicitud){

        String nombre = solicitud.getParameter("nombre");
        String apellido = solicitud.getParameter("apellido");
        String cedula = solicitud.getParameter("cedula");
        String correo = solicitud.getParameter("correo");
        String modo = solicitud.getParameter("tipoUser");
        String telefono = solicitud.getParameter("telf");
        String usuario= solicitud.getParameter("user");
        String contrasenia = solicitud.getParameter("contrasenia");

        return LoginServlet.gestor_usuario.agregarUsuario(
                new Usuario(nombre,apellido,cedula,correo,modo,telefono,usuario,contrasenia));
    }





}
