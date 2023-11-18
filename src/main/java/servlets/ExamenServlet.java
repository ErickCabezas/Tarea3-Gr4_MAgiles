package servlets;

import com.example.web.InscripcionCurso;
import com.example.web.InscripcionExamen;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="ExamenServlet", urlPatterns = {"/ExamenServlet"})
public class ExamenServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession miSesion= solicitud.getSession();
        Usuario usuario=LoginServlet.usuario;
        String horario = solicitud.getParameter("horario");
        String textoNotificacion="";

        if(usuario.getInscripcion().nivel!=0) {
            if (horario.equalsIgnoreCase("0")){
                textoNotificacion="seleccione horario";
                respuesta.sendRedirect("examen.jsp");
            }else {
                usuario.setInscripcion(new InscripcionExamen(horario));
                textoNotificacion=usuario.getInscripcion().inscribir();
                respuesta.sendRedirect("examen.jsp");
            }
        }else{
            textoNotificacion="si ya dio el examen espere la calificación";
            respuesta.sendRedirect("examen.jsp");
        }
        miSesion.setAttribute("noti", textoNotificacion);
    }

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}
