package esi.competencyframework.servlet;

import esi.competencyframework.dao.CompetencyDAO;
import esi.competencyframework.model.Competency;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "AddCompetencyServlet", value = "/AddCompetencyServlet")
public class AddCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String domain = request.getParameter("domain");
    String level = request.getParameter("level");
    Competency competency = new Competency(name, description, domain, level);
    CompetencyDAO competencyDAO = new CompetencyDAO();
    competencyDAO.addCompetency(competency);
    request.setAttribute("success", "The competency has been added successfully!");

    RequestDispatcher dispatcher = request.getRequestDispatcher("CompetencyCRUD.jsp");
    dispatcher.forward(request, response);
  }
}
