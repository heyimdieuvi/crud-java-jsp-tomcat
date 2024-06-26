package usermanagement.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usermanagement.dao.UserDAO;
import usermanagement.model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="UserServlet", urlPatterns={"/"})
public class UserServlet extends HttpServlet {
    
    private UserDAO userDAO;
    
    @Override
    public void init(){
        userDAO = new UserDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            String action = request.getServletPath();
            switch(action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                default:
                    showListUser(request, response);
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            String action = request.getServletPath();
            switch(action) {
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    showListUser(request, response);
                    break;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //show all user
    private void showListUser(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }
    
    //this will send user's info when editing
    private void showEditForm (HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp"); 
        dispatcher.forward(request, response);
    }
    
    //If insert a exist id -> ???
    private void insertUser (HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User (name, email, country);
        userDAO.insertUser(newUser);
        response.sendRedirect("abv");
    }
    
    private void deleteUser (HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("abc");
        
    }


    
    //edit user info
    //**If edited id is exist?? What happend??
    //No permission to update id -> How to?
    private void updateUser (HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, ClassNotFoundException{
        //get request data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userDAO.updateUser(user);
        response.sendRedirect("list");
    }

}

