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

    public static Gestor_Usuario gestor_usuario;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registro.jsp");
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario= req.getParameter("user");
        String key= req.getParameter("key");
        Usuario user=gestor_usuario.buscarUsuario(usuario);
        boolean ver =user!=null && (user.getLogin().validarCredenciales(usuario,key));
        if(ver){
            HttpSession misesion= req.getSession();
            misesion.setAttribute("loginUser",user);
            resp.sendRedirect("cuentaUser.jsp");
        }else{
            HttpSession misesion= req.getSession();
            misesion.setAttribute("Error","Las credenciales no son validas");
            resp.sendRedirect("index.jsp");
        }

    }
}
