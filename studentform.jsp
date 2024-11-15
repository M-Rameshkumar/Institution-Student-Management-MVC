<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %> 

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background: url('https://via.placeholder.com/1920x1080?') no-repeat center center fixed;
            background-size: cover;
            color: #fff; 
            font-family: Arial, sans-serif;
        }

      
        .form-container {
            background-color: rgba(0, 0, 0, 0.8); 
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            margin: 50px auto;
        }

        .form-container h3 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 1.8rem;
        }

        label {
            font-weight: bold;
        }

        .form-table input, .form-table select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: none;
            border-radius: 5px;
        }

       
        .submit-btn {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            color: #fff;
            text-transform: uppercase;
            font-weight: bold;
            border-radius: 5px;
            transition: background-color 0.3s;
            width: 100%;
        }

        .submit-btn:hover {
            background-color: #0056b3;
        }

       
        .message {
            text-align: center;
            margin-top: 20px;
            font-weight: bold;
            color: #f8d7da; 
        }

      
        @media (max-width: 768px) {
            .form-container {
                padding: 20px;
            }

            .form-table input, .form-table select {
                font-size: 14px;
            }

            .submit-btn {
                font-size: 14px;
            }
        }

    </style>
</head>
<body>


<div class="form-container">
    <h3>Student Information</h3>
    <form action="studenthome" method="post">
        <table class="form-table">
            <tr>
                <td><label for="txtname">Name</label></td>
                <td><input type="text" id="txtname" name="txtname" required/></td>
            </tr>
            <tr>
                <td><label for="txtAge">Age</label></td>
                <td><input type="number" id="txtAge" name="txtAge" required/></td>
            </tr>
            <tr>
                <td><label for="txtmobile">Mobile</label></td>
                <td><input type="tel" id="txtmobile" minlength="10" maxlength="10" pattern="[0-9]{10}" name="txtmobile" required/></td>
            </tr>
            <tr>
                <td><label for="txtaddress">Address</label></td>
                <td><input type="text" id="txtaddress" name="txtaddress" required/></td>
            </tr>
            <tr>
                <td><label for="txtemail">Email</label></td>
                <td><input type="email" id="txtemail" name="txtemail" required/></td>
            </tr>
            <tr>
                <td><label for="txtcourse">Course</label></td>
                <td>
                    <select id="txtcourse" name="txtcourse" required>
                        <option>---SELECT COURSE---</option>
                        <option>C++</option>
                        <option>JAVA</option>
                        <option>C#</option>
                        <option>MYSQL</option>
                        <option>PYTHON</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="action" value="savestudent" class="submit-btn"/>
                </td>
            </tr>
        </table>
    </form>

    
    <div class="message">
        <% if (request.getAttribute("message") != null) { %>
            <%= request.getAttribute("message") %>
        <% } %>
    </div>
</div>

</body>
</html>
