<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: rgba(0, 0, 0, 0.8); 
            padding: 1rem;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

        .navbar-buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .navbar-buttons button {
            text-transform: uppercase;
            font-weight: bold;
            padding: 12px 25px;
            border-radius: 5px;
            font-size: 1.1rem;
            color: white;
            border: none;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        
      

        .header-content {
            text-align: center;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7); 
            border-radius: 0px;
            color: white;
            margin-top: 0; 
        }

        .header-content h1 {
            font-size: 2.5rem;
            font-weight: bold;
        }

        .header-content p {
            font-size: 1.2rem;
            margin-top: 10px;
        }

       
        @media (max-width: 768px) {
            .navbar-buttons {
                flex-direction: column;
                gap: 10px;
            }

            .navbar-buttons button {
                width: 100%;
                padding: 15px;
            }

            .header-content h1 {
                font-size: 2rem;
            }

            .header-content p {
                font-size: 1rem;
            }
        }

    </style>
</head>
<body>


<div class="header-content">
    <h1>Welcome to the Student Management System</h1>
    <p>Manage student data effortlessly with a user-friendly interface.</p>
</div>


<form action="studenthome" method="post">
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <div class="navbar-buttons">
                <button type="submit" class="btn add-btn" name="action" value="addstudent">Add Student</button>
                <button type="submit" class="btn display-btn" name="action" value="display">Display Info</button>
                <button type="submit" class="btn update-btn" name="action" value="update">Update Student</button>
                <button type="submit" class="btn delete-btn" name="action" value="delete">Delete Student</button>
            </div>
        </div>
    </nav>
</form>

</body>
</html>
