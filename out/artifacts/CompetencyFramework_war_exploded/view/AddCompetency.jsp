<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="../../../../../../resources/bootstrap/css/bootstrap.min.css">
  <title>Add a competency</title>
</head>
<body>
<div class="container-fluid mt-4">
  <div class="row justify-content-center">
    <div class="col-sm-10 col-md-8 col-lg-6">
      <div class="card">
        <h2 class="text-center mt-1">Add a competency</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/SkillServlet" method="POST" class="needs-validation" novalidate>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="name" name="name" placeholder="" required>
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
            <button type="submit" class="btn btn-primary float-end">Add</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="../../../../../../resources/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../../../../../resources/jquery/jquery.min.js"></script>
</body>
</html>
