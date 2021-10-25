package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 792268
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = "";
        session.setAttribute("username", username);

        if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        session.setAttribute("username", username);
             
        if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            
        }
        // Create an empty array list each session
        if (session.getAttribute("items") == null) {
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("items", items);
        }
        
        // For adding items
        if (action.equals("add")) {
            ArrayList<String> items = (ArrayList) session.getAttribute("items");
            String item = request.getParameter("items");
            items.add(item);
            request.setAttribute("items", items);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            
        }
        
        if (action.equals("delete")) {
            ArrayList<String> items = (ArrayList) session.getAttribute("items");
            String item = request.getParameter("newItem");
            items.remove(item);
            request.setAttribute("items", items);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            
        }

        else if (action.equals("logout")) {
            session.invalidate();
            response.sendRedirect("register");
            return;
        }
    }
}
