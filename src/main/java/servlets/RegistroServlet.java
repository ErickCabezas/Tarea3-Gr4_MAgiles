package servlets;

import com.example.web.Gestor_Usuario;
import com.example.web.Login;
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

    protected void processRequest(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String opcion=solicitud.getParameter("mostrar");
        if(opcion!=null){
            HttpSession miSesion= solicitud.getSession();
            miSesion.setAttribute("listaUsuarios", LoginServlet.gestor_usuario.getListaUsuarios());
            respuesta.sendRedirect("mostrarUsuarios.jsp");
        }else{
            respuesta.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombre = solicitud.getParameter("nombre");
        String apellido = solicitud.getParameter("apellido");
        String ci = solicitud.getParameter("ci");
        String correo = solicitud.getParameter("correo");
        String modo = solicitud.getParameter("tipoUser");
        String tel = solicitud.getParameter("telf");
        String usuario= solicitud.getParameter("user");
        String key = solicitud.getParameter("key");
        String agregado= LoginServlet.gestor_usuario.agregarUsuario(
                 new Usuario(nombre,apellido,ci,correo,modo,tel,usuario,key));
        HttpSession miSesion= solicitud.getSession();
        miSesion.setAttribute("registro", agregado);
        respuesta.sendRedirect("registro.jsp");
    }



}
