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
        FechaMatricula fechaMatricula= new FechaMatricula();
        String fechaInicio= fechaMatricula.getFechaInicio();
        String fechaFin= fechaMatricula.getFechaFin();
        String textoNotificacion="";
        HttpSession miSesion= solicitud.getSession();

        if(usuario.getInscripcion().nivel!=0) {
            if (horario.equalsIgnoreCase("0")){
                textoNotificacion="seleccione horario";
                respuesta.sendRedirect("matricula.jsp");
            }else {
                usuario.setInscripcion(new InscripcionCurso(asignarAula(horario), fechaInicio, fechaFin, horario, 300, nivel));
                textoNotificacion = getNotificacionInscripcion(usuario);
                respuesta.sendRedirect("matricula.jsp");
            }
            miSesion.setAttribute("noti", textoNotificacion);
        }else{
            miSesion.setAttribute("userMatricula", usuario);
            respuesta.sendRedirect("examen.jsp");
        }

    }

    public String getNotificacionInscripcion(Usuario usuario) {
        String textoNotificacion;
        textoNotificacion= usuario.getInscripcion().inscribir()
                +"\n Realice el pago del curso"
                + " \n en las oficinas de CAMBRIGE "
                + "\npara finalizar su inscripción ";
        return textoNotificacion;
    }

    public int asignarAula(String horario){
        int aulaInscripcion=0;
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
        if (horario.equalsIgnoreCase("18-20")) {
            aulaInscripcion = 105;
        }
        return aulaInscripcion;
    }
}
