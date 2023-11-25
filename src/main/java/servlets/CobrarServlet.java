package servlets;

import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CobrarServlet", urlPatterns = {"/CobrarServlet"})
public class CobrarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        String modoPago= solicitud.getParameter("metodoPago");
        Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario);
        String notificacion="";
        if(usuario!=null){
            //misma linea en distintos if's
            if(modoPago.equalsIgnoreCase("0")){
                notificacion="Seleccione modo de pago";
                respuesta.sendRedirect("cobrar.jsp");
            }else {
                usuario.getInscripcion().nivel=2;
                notificacion="Usuario calificado";
                respuesta.sendRedirect("calificar.jsp");
            }
        }else{
            notificacion="no existe el estudiante con ese usuario";
            respuesta.sendRedirect("calificar.jsp");
        }
        pasarNotificacion(solicitud,notificacion);
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
