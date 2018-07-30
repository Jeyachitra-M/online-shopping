   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%@ include file="/WEB-INF/Views/Header.jsp" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<br><br><br><br>
<div class="container"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src=".\resources\images\m.jpg" style="width:100%;">
      </div>

      <div class="item">
        <img src=".\resources\images\m1.jpg" style="width:100%;">
      </div>
    
      <div class="item">
        <img src=".\resources\images\m2.jpg" style="width:100%;">
      </div>
      <div class="item">
        <img src=".\resources\images\m4.jpg" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br/>
<h2> MyBazar </h2>
<p>----Address----</p>
<p>Admin Office No.30, Arcot Road, Kodambakkam, Chennai- 600 024.</p>
</p> Contact </p>
<p> 044 42345788 </p>
</body>
</html>