package servlets;

import com.example.web.Gestor_Usuario;
import com.example.web.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CalificarServlet", urlPatterns = {"/CalificarServlet"})
public class CalificarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        int nivel= Integer.parseInt(solicitud.getParameter("nivel")) ;
        Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario);
        String notificacion="";
        if(usuario!=null){
            //misma linea en distintos if's

            if(nivel==0){
                notificacion="Seleccione nivel según la calificación";
            }else {
                usuario.getInscripcion().nivel=nivel;
                notificacion="Usuario calificado";
            }
        }else{
            notificacion="no existe el estudiante con ese usuario";

        }
        pasarNotificacion(solicitud,notificacion);
        respuesta.sendRedirect("calificar.jsp");
    }
    public void pasarNotificacion(HttpServletRequest solicitud, String notificacion){
        HttpSession miSesion = solicitud.getSession();
        miSesion.setAttribute("Notificacion", notificacion);
    }

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}
