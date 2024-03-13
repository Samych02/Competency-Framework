<%@ page import="ma.ac.esi.competencyframework.model.Skill" %>
<%@ page import="ma.ac.esi.competencyframework.model.SkillDAO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="bootstrap/css/bootstrap-icons.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Competency CRUD</title>
</head>
<body>
<div class="container-fluid mt-4">
  <div class="row justify-content-center">
    <div class="col-sm-10 col-md-8 col-lg-6">
      <% String color = null;
        String message = null;
        if (request.getAttribute("success") != null) {
          color = "alert-success";
          message = (String) request.getAttribute("success");
        }
        if (request.getAttribute("error") != null) {
          color = "alert-danger";
          message = (String) request.getAttribute("error");
        }
        if (color != null) {
      %>
      <div class="<%=color%> alert alert-dismissible fade show" role="alert">
        <%= message %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <% }%>
      <div class="card">
        <h2 class="text-center mt-1">Add a competency</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/AddSkillServlet" method="POST" class="was-validated">
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="name" name="name" placeholder="" maxlength="255" required>
              <label for="name">Competency name</label>
              <div class="invalid-feedback" id="invalid-name"></div>
            </div>
            <div class="form-floating mb-3">
              <textarea class="form-control" id="description" name="description" placeholder="" required></textarea>
              <label for="description">Description</label>
              <div class="invalid-feedback" id="invalid-description"></div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="domain" name="domain" placeholder="" required>
              <label for="domain">Domain</label>
              <div class="invalid-feedback" id="invalid-domain"></div>
            </div>
            <div class="form-floating mb-3">
              <select class="form-select" id="level" name="level" required>
                <option value="" disabled selected>Select a level</option>
                <option value="Beginner">Beginner</option>
                <option value="Intermediate">Intermediate</option>
                <option value="Advanced">Advanced</option>
              </select>
              <label for="level">Level</label>
              <div class="invalid-feedback" id="invalid-level"></div>
            </div>
            <button type="submit" class="btn btn-success float-end">Add Competency</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid mt-4">
  <div class="card">
    <h2 class="text-center mt-1">Competency list</h2>
    <div class="card-body">
      <% SkillDAO skillDAO = new SkillDAO();
        ArrayList<Skill> skillsList = skillDAO.getAllSkills();
        if (skillsList.isEmpty()) {%>
      <h3>No competencies</h3>
      <%} else { %>
      <table class="table table-striped">
        <thead>
        <tr>
          <th class="col-2">Name</th>
          <th class="col-4">Description</th>
          <th class="col-2">Domain</th>
          <th class="col-2">Level</th>
          <th class="col-2"></th>
        </tr>
        </thead>
        <tbody>
          <% for (Skill s : skillsList){%>
        <tr>
          <td><%=s.getName()%>
          </td>
          <td><%=s.getDescription()%>
          </td>
          <td><%=s.getDomain()%>
          </td>
          <td><%=s.getLevel()%>
          </td>
          <td>
            <form class="float-end px-1" action="${pageContext.request.contextPath}/EditSkillServlet" method="post"><input
                name="edit" hidden="hidden" value="<%=s.getId()%>">
              <button class="btn p-0" type="submit"><i class="bi bi-pencil-square" style="color: blue"></i></button>
            </form>
            <form class="float-end px-1" action="${pageContext.request.contextPath}/DeleteSkillServlet" method="post"><input
                name="delete" hidden="hidden" value="<%=s.getId()%>">
              <button class="btn p-0" type="submit"><i class="bi bi-trash-fill" style="color: red"></i></button>
            </form>
          </td>
        </tr>
          <% }}%>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
</body>
</html>
