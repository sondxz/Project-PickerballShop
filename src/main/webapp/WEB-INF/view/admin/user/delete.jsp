<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Delete User Page ${id}</title>
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link rel="stylesheet" href="css/demo.css"> -->
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-12 mx-auto">
          <h3>Delete a User id = ${id}</h3>
          <hr />
          <div class="alert alert-danger">Are you sure you want to delete this user?</div>
          <form:form action="/admin/user/delete" method="post" modelAttribute="newUser">
            <div class="mb-3" style="display: none;">
              <label for="id" class="form-label">Id:</label>
              <form:input value="${id}" type="text" class="form-control" path="id" />
            </div>
            <button type="submit" class="btn btn-danger">Delete User</button>
            <a href="/admin/user" class="btn btn-secondary">Cancel</a>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
