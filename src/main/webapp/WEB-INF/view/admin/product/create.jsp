<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
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
    <title>Create User - PickerBallShop</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script
      src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
      crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      $(document).ready(() => {
        const avatarFile = $("#avatarFile");
        avatarFile.change(function (e) {
          const imgURL = URL.createObjectURL(e.target.files[0]);
          $("#avatarPreview").attr("src", imgURL);
          $("#avatarPreview").css({ display: "block" });
        });
      });
    </script>
  </head>
  <body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
      <jsp:include page="../layout/sidebar.jsp" />
      <div id="layoutSidenav_content">
        <main>
          <div class="container-fluid px-4">
            <h1 class="mt-4">Products</h1>
            <ol class="breadcrumb mb-4">
              <li class="breadcrumb-item">
                <a href="/admin">Dashboard</a>
              </li>
              <li class="breadcrumb-item">
                <a href="/admin/product">Product</a>
              </li>
              <li class="breadcrumb-item active">Create Product</li>
            </ol>
            <div class="row">
              <div class="col-md-6 col-12 mx-auto">
                <h1>Create a Product</h1>
                <hr />
                <form:form
                  action="/admin/product/create"
                  method="post"
                  class="row"
                  modelAttribute="newProduct"
                  enctype="multipart/form-data"
                >
                  <c:set var="errorName">
                    <form:errors path="name" cssClass="invalid-feedback" />
                  </c:set>
                  <c:set var="errorPrice">
                    <form:errors path="price" cssClass="invalid-feedback" />
                  </c:set>
                  <c:set var="errorDetailDesc">
                    <form:errors
                      path="detailDesc"
                      cssClass="invalid-feedback"
                    />
                  </c:set>
                  <c:set var="errorShortDesc">
                    <form:errors path="shortDesc" cssClass="invalid-feedback" />
                  </c:set>
                  <c:set var="errorQuantity">
                    <form:errors path="quantity" cssClass="invalid-feedback" />
                  </c:set>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="name" class="form-label">Name:</label>
                    <form:input
                      type="text"
                      class="form-control ${not empty errorName ? 'is-invalid' : ''}"
                      path="name"
                    />
                    ${errorName}
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="price" class="form-label">Price:</label>
                    <form:input
                      type="number"
                      class="form-control ${not empty errorPrice ? 'is-invalid' : ''}"
                      path="price"
                    />
                    ${errorPrice}
                  </div>
                  <div class="mb-3 col-12">
                    <label for="description" class="form-label"
                      >Detail description:</label
                    >
                    <form:textarea
                      type="text"
                      class="form-control ${not empty errorDetailDesc ? 'is-invalid' : ''}"
                      path="detailDesc"
                    />
                    ${errorDetailDesc}
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="shortDescription" class="form-label"
                      >Short description:</label
                    >
                    <form:input
                      type="text"
                      class="form-control ${not empty errorShortDesc ? 'is-invalid' : ''}"
                      path="shortDesc"
                    />
                    ${errorShortDesc}
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="quantity" class="form-label">Quantity:</label>
                    <form:input
                      type="number"
                      class="form-control ${not empty errorQuantity ? 'is-invalid' : ''}"
                      path="quantity"
                    />
                    ${errorQuantity}
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="factory" class="form-label">Factory:</label>
                    <form:select class="form-select" path="factory">
                      <form:option value="Kamito">Kamito</form:option>
                      <form:option value="Lining">Lining</form:option>
                      <form:option value="Joola">Joola</form:option>
                      <form:option value="Facolos">Facolos</form:option>
                      <form:option value="Paddletek">Paddletek</form:option>
                      <form:option value="CRBN">CRBN</form:option>
                      <form:option value="Legendtek">Legendtek</form:option>
                      <form:option value="Selkirk">Selkirk</form:option>
                    </form:select>
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="target" class="form-label">Target:</label>
                    <form:select class="form-select" path="target">
                      <form:option value="ATTACK">ATTACK</form:option>
                      <form:option value="GUARD">GUARD</form:option>
                      <form:option value="ALL-AROUND">ALL-AROUND</form:option>
                      <form:option value="PRO">PRO</form:option>
                    </form:select>
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="productFile" class="form-label">Image:</label>
                    <input
                      type="file"
                      class="form-control"
                      id="avatarFile"
                      accept=".png, .jpg, .jpeg"
                      name="productFile"
                    />
                  </div>
                  <div class="mb-3 col-12">
                    <img
                      alt="avatar preview"
                      id="avatarPreview"
                      style="max-width: 200px; display: none"
                    />
                  </div>
                  <div class="col-12 mb-5">
                    <button type="submit" class="btn btn-primary">
                      Create product
                    </button>
                  </div>
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
