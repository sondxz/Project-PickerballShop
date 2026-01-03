<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Delete User - PickerBallShop</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script
      src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
      <jsp:include page="../layout/sidebar.jsp" />
      <div id="layoutSidenav_content">
        <main>
          <div class="container-fluid px-4">
            <h1 class="mt-4">Manage Users</h1>
            <ol class="breadcrumb mb-4">
              <li class="breadcrumb-item active">
                <a href="/admin">Dashboard</a>
              </li>
              <li class="breadcrumb-item"><a href="/admin/user">users</a></li>
            </ol>
            <div class="row">
              <div class="col-12 mx-auto">
                <h3>Delete a User id = ${id}</h3>
                <hr />
                <div class="alert alert-danger">
                  Are you sure you want to delete this user?
                </div>
                <form:form
                  action="/admin/user/delete"
                  method="post"
                  modelAttribute="newUser"
                >
                  <div class="mb-3" style="display: none">
                    <label for="id" class="form-label">Id:</label>
                    <form:input
                      value="${id}"
                      type="text"
                      class="form-control"
                      path="id"
                    />
                  </div>
                  <button type="submit" class="btn btn-danger">
                    Delete User
                  </button>
                  <a href="/admin/user" class="btn btn-secondary">Cancel</a>
                </form:form>
              </div>
            </div>
          </div>
        </main>
        <jsp:include page="../layout/footer.jsp" />
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/script.js"></script>
  </body>
</html>
