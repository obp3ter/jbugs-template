package servlet;

import ro.msg.edu.jbugs.Cleaner;
import ro.msg.edu.jbugs.manager.BugManager;
import ro.msg.edu.jbugs.dto.dto.UserDTO;
import ro.msg.edu.jbugs.manager.NotificationManager;
import ro.msg.edu.jbugs.manager.UserManager;
import ro.msg.edu.jbugs.model.exception.BusinessException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    private String message;
    private UserDTO userDTO = new UserDTO();
    @EJB
    private UserManager userManager;
    @EJB
    private BugManager bugManager;
    @EJB
    private NotificationManager notificationManager;
    @EJB
    private Cleaner cleaner;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
        userDTO.setCounter(0);
        userDTO.setEmail("teste");
        userDTO.setFirstName("testfn");
        userDTO.setLastName("testln");
        userDTO.setMobileNumber("testmn");
        userDTO.setPassword("testp");
        userDTO.setUsername("testun");
        userDTO.setStatus(1);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        for (int i = 0; i < 5; i++) {
            userManager.insert(userDTO);
        }
        userManager.findAll().forEach(s-> out.println("<p>"+s+"</p>"));
        /*
        TODO:   try wrong pass
                try deactivated user
                try no such user
         */

        try {
            out.println(userManager.login("testlte","testp").toString());
        } catch (BusinessException e) {
            out.println("<p>"+e.getMessage()+"</p>");
        }
        try {
            out.println(userManager.login("testle","testp").toString());
        } catch (BusinessException e) {
            out.println("<p>"+e.getMessage()+"</p>");
        }
        for (int i = 0; i < 3; i++) {
            try {
                out.println(userManager.login("testlte","tesp").toString());
            } catch (BusinessException e) {
                out.println("<p>"+e.getMessage()+"</p>");
            }
        }
        try {
            out.println(userManager.login("testlte","testp").toString());
        } catch (BusinessException e) {
            out.println("<p>"+e.getMessage()+"</p>");
        }
        for (int i = 0; i < 5; i++) {
            try {
                out.println(userManager.login("testlte","tesp").toString());
            } catch (BusinessException e) {
                out.println("<p>"+e.getMessage()+"</p>");
            }
        }
        try {
            out.println(userManager.login("testlte","testp").toString());
        } catch (BusinessException e) {
            out.println("<p>"+e.getMessage()+"</p>");
        }


    }

    public void destroy() {
        // do nothing.
    }
}
