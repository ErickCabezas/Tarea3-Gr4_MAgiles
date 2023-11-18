package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.example.web.Gestor_Usuario;
import com.example.web.Login;
import com.example.web.Usuario;

@WebServlet(name="LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public static Gestor_Usuario gestor_usuario=new Gestor_Usuario();
    public static Usuario usuario;

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("registro.jsp");
    }

    protected void processRequest(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("user");
        String key= solicitud.getParameter("key");
        Usuario usuario=gestor_usuario.buscarUsuario(nombreUsuario);
        boolean credencialesValidas = usuario!=null && (usuario.getLogin().validarCredenciales(nombreUsuario,key));
        HttpSession miSesion= solicitud.getSession();
        if(credencialesValidas){
            miSesion.setAttribute("loginUser",usuario);
            LoginServlet.usuario=usuario;
            respuesta.sendRedirect("cuentaUser.jsp");
        }else{
            miSesion.setAttribute("Error","Las credenciales no son validas");
            respuesta.sendRedirect("index.jsp");
        }

    }
}
