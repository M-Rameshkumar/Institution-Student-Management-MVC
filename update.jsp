<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>
<%@page import="com.palletech.model.Bean" %> 

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Record</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }

    .container {
        margin-top: 30px;
        padding: 20px;
        background-color: black;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .form-label {
        font-weight: bold;
        color: #007bff;
    }

    .btn-primary {
        background-color: #007bff;
        border: none;
        width: 100%;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    @media (max-width: 768px) {
        .container {
            padding: 15px;
        }

        .form-control {
            width: 100%;
        }

        .btn-primary {
            font-size: 14px;
        }
    }

    .header {
        background-color: #007bff;
        color: white;
        padding: 15px;
        text-align: center;
        font-size: 1.8rem;
        margin-bottom: 20px;
        border-radius: 8px 8px 0 0;
    }

    .form-control {
        width: 300px;
        margin: 10px auto;
    }
</style>
</head>

<body>

<div class="header">
    <h2>Update Student Information</h2>
</div>

<form action="/showstudentdatatoupdate" method="post">
    <div class="container">
        <div class="mb-3" align="center">
            <label for="exampleInputEmail1" class="form-label">Enter Mobile Number</label>
            <input type="tel" pattern="[0-9]{10}" name="mob" required class="form-control" id="exampleInputEmail1">
            <button type="submit" class="btn btn-primary" value="showdata">Show Data</button>
        </div>
    </div>
</form>

<script type="text/javascript">
    function f1() {
        <% if (request.getAttribute("message") != null) { %>
            alert("<%= request.getAttribute("message") %>");
        <% } %>
    }
    f1();
</script>

<% if (request.getAttribute("studentdata") != null) { %>
    <% Bean b = (Bean) request.getAttribute("studentdata"); %>

    <form action="/updatedsucess" method="post">
        <div class="container">
            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input type="text" name="txtname" value="<%= b.getName() %>" class="form-control">
            </div>

            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Age</label>
                <input type="number" name="txtage" value="<%= b.getAge() %>" class="form-control">
            </div>

            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Mobile</label>
                <input type="tel" name="txtnumber" value="<%= b.getMobile() %>" class="form-control">
            </div>

            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Address</label>
                <input type="text" name="txtaddress" value="<%= b.getAddress() %>" class="form-control">
            </div>

            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="email" name="txtemail" value="<%= b.getEmail() %>" class="form-control">
            </div>

            <div class="mb-3" align="center">
                <label for="exampleInputEmail1" class="form-label">Course</label>
                <input type="text" name="txtcourse" value="<%= b.getCourse() %>" class="form-control">
            </div>

            <div align="center">
                <button type="submit" class="btn btn-primary" value="updatedsucess">Update</button>
            </div>
        </div>
    </form>
<% } %>

<script type="text/javascript">
    function f2() {
        <% if (request.getAttribute("message1") != null) { %>
            alert("<%= request.getAttribute("message1") %>");
        <% } %>
    }
    f2();
</script>

</body>
</html>
