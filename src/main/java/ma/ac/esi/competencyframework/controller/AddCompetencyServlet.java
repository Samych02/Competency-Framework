package ma.ac.esi.competencyframework.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.ac.esi.competencyframework.model.Competency;
import ma.ac.esi.competencyframework.model.CompetencyDAO;

import java.io.IOException;

@WebServlet(name = "AddCompetencyServlet", value = "/AddCompetencyServlet")
public class AddCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String domain = request.getParameter("domain");
    String level = request.getParameter("level");
    Competency competency = new Competency(name, description, domain, level);
    CompetencyDAO competencyDAO = new CompetencyDAO();
    if (competencyDAO.addCompetency(competency)) {
      request.setAttribute("success", "The competency has been added successfully!");
    } else {
      request.setAttribute("error", "An error has been encountered while adding the competency!");
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("CompetencyCRUD.jsp");
    dispatcher.forward(request, response);
  }
}