package ma.ac.esi.competencyframework.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.ac.esi.competencyframework.model.Competency;
import ma.ac.esi.competencyframework.model.CompetencyDAO;

import java.io.IOException;

@WebServlet(name = "EditCompetencyServlet", value = "/EditCompetencyServlet")
public class EditCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("edit") != null) {
      System.out.println("no");
      int id = Integer.parseInt(request.getParameter("edit"));
      CompetencyDAO competencyDAO = new CompetencyDAO();
      Competency competency = competencyDAO.getCompetency(id);
      request.setAttribute("competency", competency);
      RequestDispatcher dispatcher = request.getRequestDispatcher("EditCompetency.jsp");
      dispatcher.forward(request, response);
    } else {
      Competency competency = new Competency(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("description"), request.getParameter("domain"), request.getParameter("level"));
      CompetencyDAO competencyDAO = new CompetencyDAO();
      if (competencyDAO.editCompetency(competency)) {
        request.setAttribute("success", "The competency has been edited successfully!");
      } else {
        request.setAttribute("error", "An error has been encountered while editing the competency!");
      }
      RequestDispatcher dispatcher = request.getRequestDispatcher("CompetencyCRUD.jsp");
      dispatcher.forward(request, response);
    }
  }
}