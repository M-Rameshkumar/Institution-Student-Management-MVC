<%@page import="java.util.ListIterator"%>
<%@page import="com.palletech.model.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="home.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        background-color: #f8f9fa;
        font-family: Arial, sans-serif;
    }

    .container {
        margin-top: 30px;
        padding: 20px;
        background-color: black;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .table {
        margin-top: 20px;
        border: 1px solid #ddd;
        border-radius: 8px;
        overflow: hidden;
    }

    .table th, .table td {
        text-align: center;
        padding: 12px 15px;
    }

    .table th {
        background-color: #ffffff; 
        color: #007bff;
    }

    .table td {
        background-color: #f2f2f2;
    }

    .table td:hover {
        background-color: #e9ecef;
        cursor: pointer;
    }

    .table-striped tbody tr:nth-of-type(odd) {
        background-color: #f9f9f9;
    }

    .table-hover tbody tr:hover {
        background-color: #f1f1f1;
    }

    h2 {
        text-align: center;
        font-size: 2rem;
        margin-bottom: 20px;
        color: #007bff;
    }

    
    @media (max-width: 768px) {
        .table th, .table td {
            font-size: 12px;
            padding: 8px 10px;
        }

        h2 {
            font-size: 1.5rem;
        }
    }
</style>
</head>
<body>

<div class="container">
    <h2>Student Records</h2>
    
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>SID</th>
                <th>NAME</th>
                <th>AGE</th>
                <th>MOBILE</th>
                <th>ADDRESS</th>
                <th>EMAIL</th>
                <th>COURSE</th>
            </tr>
        </thead>
        <tbody>
            <% 
                ArrayList<Bean> al = (ArrayList<Bean>) request.getAttribute("studentdata"); 
                if (al != null) {
                    for (Bean b : al) { 
            %>
                <tr>
                    <td><%= b.getSid() %></td>
                    <td><%= b.getName() %></td>
                    <td><%= b.getAge() %></td>
                    <td><%= b.getMobile() %></td>
                    <td><%= b.getAddress() %></td>
                    <td><%= b.getEmail() %></td>
                    <td><%= b.getCourse() %></td>
                </tr>
            <% 
                    } 
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
