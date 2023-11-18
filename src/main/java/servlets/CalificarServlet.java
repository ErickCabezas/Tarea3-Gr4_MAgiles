package servlets;

import com.example.web.Gestor_Usuario;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CalificarServlet", urlPatterns = {"/CalificarServlet"})
public class CalificarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        int nivel= Integer.parseInt(solicitud.getParameter("nivel")) ;
        Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario);
        String notificacion="";
        HttpSession miSesion = solicitud.getSession();
        if(usuario!=null){
            //misma linea en distintos if's

            if(nivel==0){
                notificacion="Seleccione nivel según la calificación";
                respuesta.sendRedirect("calificar.jsp");
            }else {
                usuario.getInscripcion().nivel=nivel;
                notificacion="Usuario calificado";
                respuesta.sendRedirect("calificar.jsp");
            }
        }else{
            notificacion="no existe el estudiante con ese usuario";
            respuesta.sendRedirect("calificar.jsp");
        }
        miSesion.setAttribute("Notificacion", notificacion);
    }

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}
