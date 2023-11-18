package servlets;

import com.example.web.InscripcionCurso;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        Usuario usuario=LoginServlet.usuario;
        int nivel=usuario.getInscripcion().nivel;
        String horario = solicitud.getParameter("horario");
        String fechaInicio= String.valueOf(LocalDate.now().plusMonths(1));
        String fechaFin= String.valueOf(LocalDate.now().plusMonths(4));
        String textoNotificacion="";
        HttpSession miSesion= solicitud.getSession();

        if(usuario.getInscripcion().nivel!=0) {
            if (horario.equalsIgnoreCase("0")){
                textoNotificacion="seleccione horario";
                miSesion.setAttribute("noti", textoNotificacion);
                respuesta.sendRedirect("matricula.jsp");
            }else {
                int aulaInscripcion = 106;
                if (horario.equalsIgnoreCase("7-9")) {
                    aulaInscripcion = 101;
                }
                if (horario.equalsIgnoreCase("9-11")) {
                    aulaInscripcion = 102;
                }
                if (horario.equalsIgnoreCase("11-13")) {
                    aulaInscripcion = 103;
                }
                if (horario.equalsIgnoreCase("14-16")) {
                    aulaInscripcion = 104;
                }
                if (horario.equalsIgnoreCase("16-18")) {
                    aulaInscripcion = 105;
                }
                usuario.setInscripcion(new InscripcionCurso(aulaInscripcion, fechaInicio, fechaFin, horario, 300, nivel));
                textoNotificacion=usuario.getInscripcion().inscribir();
                miSesion.setAttribute("noti", textoNotificacion);
                respuesta.sendRedirect("matricula.jsp");
            }
        }else{
            miSesion.setAttribute("userMatricula", usuario);
            respuesta.sendRedirect("examen.jsp");
        }

    }
}
