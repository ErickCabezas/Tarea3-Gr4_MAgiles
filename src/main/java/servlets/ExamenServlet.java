package servlets;

import com.example.web.InscripcionExamen;
//import com.example.web.Usuario;
import entities.Incripcionexamen;

import entities.Inscripcion;
import entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name="ExamenServlet", urlPatterns = {"/ExamenServlet"})
public class ExamenServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        Usuario usuario = LoginServlet.usuario;
        String horario = solicitud.getParameter("horario");
        String textoNotificacion="";

        if(usuario.getInscripcionByInscripcion() != null) {
            if (horario.equalsIgnoreCase("0")){
                textoNotificacion="seleccione horario";
                respuesta.sendRedirect("examen.jsp");
            }else {
                java.util.Date fechaUtil = new java.util.Date();
                java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
                Incripcionexamen examen = new Incripcionexamen(horario);
                Inscripcion inscripcion = new Inscripcion(fechaSQL, horario, usuario, 0, examen);
                usuario.setInscripcionByInscripcion(inscripcion);
                //textoNotificacion=usuario.getInscripcion().inscribir();
                respuesta.sendRedirect("examen.jsp");
            }
        }else{
            textoNotificacion="si ya dio el examen espere la calificación";
            respuesta.sendRedirect("examen.jsp");
        }
        pasarNotificacion(solicitud,textoNotificacion);
    }
    public void pasarNotificacion(HttpServletRequest solicitud, String notificacion){
        HttpSession miSesion = solicitud.getSession();
        miSesion.setAttribute("noti", notificacion);
    }
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}
