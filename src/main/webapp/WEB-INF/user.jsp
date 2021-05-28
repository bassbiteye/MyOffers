<%@ page language="java" contentType="text/html;chareset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:admin_template title="users">
  <jsp:attribute name="content">
    <style>
      body {
        color: #404E67;
        background: #F5F7FA;
        font-family: 'Open Sans', sans-serif;
      }
      .table-wrapper {
        width: 700px;
        margin: 30px auto;
        background: #fff;
        padding: 20px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
      }
      .table-title {
        padding-bottom: 10px;
        margin: 0 0 10px;
      }
      .table-title h2 {
        margin: 6px 0 0;
        font-size: 22px;
      }
      .table-title .add-new {
        float: right;
        height: 30px;
        font-weight: bold;
        font-size: 12px;
        text-shadow: none;
        min-width: 100px;
        border-radius: 50px;
        line-height: 13px;
      }
      .table-title .add-new i {
        margin-right: 4px;
      }
      table.table {
        table-layout: fixed;
      }
      table.table tr th, table.table tr td {
        border-color: #e9e9e9;
      }
      table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
      }
      table.table th:last-child {
        width: 100px;
      }
      table.table td a {
        cursor: pointer;
        display: inline-block;
        margin: 0 5px;
        min-width: 24px;
      }
      table.table td a.add {
        color: #27C46B;
      }
      table.table td a.edit {
        color: #FFC107;
      }
      table.table td a.delete {
        color: #E34724;
      }
      table.table td i {
        font-size: 19px;
      }
      table.table td a.add i {
        font-size: 24px;
        margin-right: -1px;
        position: relative;
        top: 3px;
      }
      table.table .form-control {
        height: 32px;
        line-height: 32px;
        box-shadow: none;
        border-radius: 2px;
      }
      table.table .form-control.error {
        border-color: #f50000;
      }
      table.table td .add {
        display: none;
      }


    </style>
  <div class="container-lg">
    <div class="table-responsive">
      <div class="table-wrapper">
        <div class="table-title">
          <div class="row">
            <div class="col-sm-8"><h2>Employee <b>Details</b></h2></div>
            <div class="col-sm-4">
              <div type="button" class="btn btn-info trigger-btn add-new" href="#myModal"  data-toggle="modal><i class="fa fa-plus"></i> Add New</button>
            </div>
          </div>
        </div>
        <table class="table table-bordered">
          <thead>
          <tr>
            <th>nom</th>
            <th>prénom</th>
            <th>tel</th>
            <th>email</th>
            <th>Actions</th>
          </tr>
          </thead>
          <tbody>

             <c:forEach  items="${users}" var="user">
             <tr>
            <td>${user.prenom}</td>
            <td>${user.nom}</td>
            <td>${user.tel}</td>
            <td>${user.login}</td>
            <td>
              <a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
              <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
              <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
            </td>
             </tr>
            </c:forEach>


          </tbody>
        </table>
      </div>
    </div>
  </div>

    <div id="myModal" class="modal fade">
      <div class="modal-dialog modal-login">
        <div class="modal-content">
          <div class="modal-header">
            <div class="avatar">
              <img src="/examples/images/avatar.png" alt="Avatar">
            </div>
            <h4 class="modal-title">Member Login</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <form action="/examples/actions/confirmation.php" method="post">
              <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="Username" required="required">
              </div>
              <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
              </div>
              <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Login</button>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <a href="#">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

  </jsp:attribute>
</mt:admin_template>