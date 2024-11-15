<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            background-color: #f8f9fa; 
        }
        .form-container {
            max-width: 400px; 
            width: 100%; 
            border: 1px solid #ddd; /
            border-radius: 8px; 
            background-color: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); 
        }
        .btn-primary {
            background-color: #007bff; 
            border: none; 
        }
        .btn-primary:hover {
            background-color: #0056b3; 
        }
    </style>
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="card form-container">
            <form action="reg" method="post" class="p-4">
                <h2 class="text-center mb-4">Create Your Account</h2>
                
               
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="txtname" id="name" class="form-control" placeholder="Enter your full name" required>
                </div>
                
              
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" name="txtemail" id="email" class="form-control" placeholder="Enter your email address" required>
                </div>
                
               
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="txtpassword" id="password" class="form-control" placeholder="Enter a secure password" required>
                </div>
                
                
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
