package servlet;

import ro.msg.edu.jbugs.bug.BugManager;
import ro.msg.edu.jbugs.dto.BugDTO;
import ro.msg.edu.jbugs.dto.UserDTO;
import ro.msg.edu.jbugs.user.UserManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    private String message;
    private UserDTO userDTO = new UserDTO();
    @EJB
    private UserManager userManager;
    @EJB
    private BugManager bugManager;

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
        List<BugDTO> bugList = bugManager.getByAssignedId(1);
        bugList.forEach(s -> out.println(s.toString()));
    }

    public void destroy() {
        // do nothing.
    }
}
