<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            background-color: #f8f9fa; 
        }
        .sample-image {
            max-width: 100%; 
            height: auto;
        }
        .sign-up-link {
            color: #007bff;
            text-decoration: none;
        }
        .sign-up-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <section class="vh-100">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-8 col-lg-6 col-xl-5">
                  
                    <div class="text-center mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="sample-image" alt="Sample image">
                    </div>
                    
                   
                    <form action="login" method="post" class="p-4 rounded shadow bg-white">
                        <h3 class="text-center mb-4">Login</h3>
                        
                       
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Username</label>
                            <input type="email" name="txtemail" class="form-control" id="exampleInputEmail1" placeholder="Enter your email" required>
                        </div>
                        
                        
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Password</label>
                            <input type="password" name="txtpassword" class="form-control" id="exampleInputPassword1" placeholder="Enter your password" required>
                        </div>
                        
                      
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary w-100">Login</button>
                        </div>
                        
                        
                        <div class="text-center mt-3">
                            <a href="registration.jsp" class="sign-up-link">Don't have an account? Sign Up</a>
                        </div>
                        
                        
                        <% if(request.getAttribute("message") != null) { %>
                            <div class="alert alert-info mt-3" role="alert">
                                <%= request.getAttribute("message") %>
                            </div>
                        <% } %>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
