    <%@ page isELIgnored="false" language="java" contentType="text/html;chareset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <style>
    body {
      color: #fff;
      background: #3598dc;
      font-family: 'Roboto', sans-serif;
    }
    .login-form {
      width: 400px;
      margin: 30px auto;
    }
    .login-form form {
      margin-bottom: 15px;
      background: #f7f7f7;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      padding: 30px;

    }
    .login-form h2 {
      margin: 0 0 15px;
      color: #333;
      font-weight: bold;
    }
    .form-control, .login-btn {
      border-radius: 2px;
    }
    .input-group-prepend .fa {
      font-size: 18px;
    }
    .login-btn {
      font-size: 15px;
      font-weight: bold;
      min-height: 40px;
    }


    .log-form a {
      color: #fff;
      text-decoration: underline;
    }
    .or-seperator i {
      padding: 0 10px;
      background: #f7f7f7;
      position: relative;
      top: -11px;
      z-index: 1;
    }
    .signup-form form a:hover {
      text-decoration: underline;
    }
    .hint-text  {
      padding-bottom: 15px;
      text-align: center;
    }
  </style>

</head>
<body>
<div class="login-form">
  <form action="login" method="post">
    <h2 class="text-center">Authentification</h2>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-prepend">
                    <span class="input-group-text">
                        <span class="fa fa-user"></span>
                    </span>
        </div>
        <input type="text" class="form-control" name="login" placeholder="login" required="required">
      </div>
    </div>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-prepend">
                    <span class="input-group-text">
                        <i class="fa fa-lock"></i>
                    </span>
        </div>
        <input type="password" class="form-control" name="password" placeholder="Password" required="required">
      </div>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary login-btn btn-block">Se connecter</button>
    </div>
    <div class="clearfix">
      <a href="#" class="float-right">Forgot Password?</a>
    </div>
    <p class="text-center">     ${requestScope.error}
    </p>

  </form>
  <p class="text-center text-muted small hint-text">Vous n'avez pas de compte? <a href="${pageContext.request.contextPath}/register">Inscrivez-vous!</a></p>
</div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
