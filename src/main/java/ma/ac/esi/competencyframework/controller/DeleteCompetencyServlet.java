package ma.ac.esi.competencyframework.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.ac.esi.competencyframework.model.CompetencyDAO;

import java.io.IOException;

@WebServlet(name = "DeleteCompetencyServlet", value = "/DeleteCompetencyServlet")
public class DeleteCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("delete"));
    CompetencyDAO competencyDAO = new CompetencyDAO();
    if (competencyDAO.removeCompetency(id)) {
      request.setAttribute("success", "The competency has been deleted successfully!");
    } else {
      request.setAttribute("error", "An error has been encountered while deleting the competency!");
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("AddCompetency.jsp");
    dispatcher.forward(request, response);
  }
}