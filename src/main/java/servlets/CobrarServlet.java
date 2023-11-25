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

@WebServlet(name="CobrarServlet", urlPatterns = {"/CobrarServlet"})
public class CobrarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        double monto= Double.parseDouble(solicitud.getParameter("monto"));
        String modoPago= solicitud.getParameter("metodoPago");
        Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario);
        String notificacion="";
        if(sePuedeCobrar(usuario, monto)){
            //misma linea en distintos if's
            if(modoPago.equalsIgnoreCase("0")){
                notificacion="Seleccione modo de pago";
            }else {
                notificacion = validarPago(usuario, modoPago);
            }
        }else{
            notificacion="no existe el estudiante con ese usuario o el monto es incorrecto";
        }
        pasarNotificacion(solicitud,notificacion);
        respuesta.sendRedirect("cobrar.jsp");
    }

    private static boolean sePuedeCobrar(Usuario usuario, double monto) {
        return usuario != null && monto==usuario.getInscripcion().getCosto();
    }

    private String validarPago(Usuario usuario, String modoPago) {
        String notificacion;
        if(usuario.getInscripcion().pagar(modoPago)){
            notificacion="Pago Guardado";
        }else{
            notificacion="Pago no realizado";
        }
        return notificacion;
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
