<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Register</title>
</head>
<body>
<div class="container-fluid mt-4">
  <div class="row justify-content-center">
    <div class="col-sm-10 col-md-8 col-lg-6">
      <div class="card">
        <h2 class="text-center mt-1">Register</h2>
        <div class="card-body">
          <form class="needs-validation" novalidate>
            <div class="row">
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="fname" placeholder="">
                  <label for="fname">First name</label>
                  <div class="invalid-feedback" id="invalid-fname"></div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="lname" placeholder="">
                  <label for="lname">Last name</label>
                  <div class="invalid-feedback" id="invalid-lname"></div>
                </div>
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="email" placeholder="">
              <label for="email">Email address</label>
              <div class="invalid-feedback" id="invalid-email"></div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="password" class="form-control" id="password1" placeholder="">
                  <label for="password1">Password</label>
                  <div class="invalid-feedback" id="invalid-password1"></div>
                  <div class="form-text">
                    Your password must be 8-20 characters long, contain at least a letter, a numbers
                    and a special characters.
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="password" class="form-control" id="password2" placeholder="">
                  <label for="password2">Confirm password</label>
                  <div class="invalid-feedback" id="invalid-password2"></div>
                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-primary">R</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>
