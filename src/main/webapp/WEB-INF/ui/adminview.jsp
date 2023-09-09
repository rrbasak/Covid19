<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      .container {
        display: flex;
        justify-content: center; /* Center the boxes horizontally */
        align-items: center; /* Center the boxes vertically */
        height: 100vh; /* Set the container height to the viewport height */
      }

      .box {
        width: 150px;
        height: 150px;
        padding: 10px;
        box-shadow: 0px 1px 4px 1px rgb(192 187 187);
        border: 1px;
        margin: 80px;
      }
      .box:hover {
        width: 155px;
        height: 155px;
        transition: all 1s ease-in-out;
        transform: scale(1);
      }
    </style>
  </head>
  <body>

    <div class="container">
      <div class="box"><a href="users" style="text-decoration: none;">Users</a></div>
      <div class="box"><a href="usersdetails" style="text-decoration: none;">UsersDetails</a></div>
    </div>
  </body>
</html>
