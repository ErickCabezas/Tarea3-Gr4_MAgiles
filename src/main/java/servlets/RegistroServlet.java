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

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opc=req.getParameter("mostrar");
        if(opc!=null){
            HttpSession misesion= req.getSession();
            misesion.setAttribute("listaUsuarios", LoginServlet.gestor_usuario.getListaUsuarios());
            resp.sendRedirect("mostrarUsuarios.jsp");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String ci = req.getParameter("ci");
        String correo = req.getParameter("correo");
        String modo = req.getParameter("tipoUser");
        String tel = req.getParameter("telf");
        String usuario= req.getParameter("user");
        String key = req.getParameter("key");
        String agregado= LoginServlet.gestor_usuario.agregarUsuario(
                 new Usuario(nombre,apellido,ci,correo,modo,tel,usuario,key));
        HttpSession misesion= req.getSession();
        misesion.setAttribute("registro", agregado);
        resp.sendRedirect("registro.jsp");
    }



}
