package mik.prog4.zh1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mik.prog4.zh1.service.PetService;

import java.io.IOException;

public class ListServlet extends HttpServlet {

    private static final PetService petService = new PetService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("petList", petService.findAll());
        req.getRequestDispatcher("petList.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        petService.deletePet(Long.parseLong(req.getParameter("petId")));
        req.setAttribute("petList", petService.findAll());
        req.getRequestDispatcher("petList.jsp").forward(req, resp);
    }
}
