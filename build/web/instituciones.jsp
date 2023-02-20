<%-- 
    Document   : instituciones
    Created on : 19/11/2022, 10:04:51 p. m.
    Author     : Meli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Acción Solidaria</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <body class="main-layout inner_page">
        <!-- header -->
        <header class="full_bg">
            <!-- header inner -->
            <div class="header">
                <div class="container-fluid">
                    <div class="row">
                        <!-- -->
                        <!--Logo -->
                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo">
                                        <a href="index.jsp"><img src="images/logo1.png" alt="#"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Menú-->
                        <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                            <nav class="navigation navbar navbar-expand-md navbar-dark ">
                                <!-- Botón responsive -->
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <!-- Opciones del menú -->
                                <div class="collapse navbar-collapse" id="navbarsExample04">
                                    <ul class="navbar-nav mr-auto">
                                        <li class="nav-item">
                                            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link active" href="instituciones.jsp">Instituciones</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="necesidades.jsp">Necesidades</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="testimonios.jsp">Testimonios</a>
                                        </li>
                                        <%
                                            if (session.getAttribute("admin") == "admin" && session.getAttribute("nombre") != null) {
                                        %>
                                        <li class="nav-item">
                                            <a class="nav-link active" href="admin.jsp">Admin</a>
                                        </li>
                                        <%} else {
                                            if (session.getAttribute("nombre") != null) {
                                        %>
                                        <li class="nav-item">
                                            <a class="nav-link active" href="institucion.jsp">Insti</a>
                                        </li>

                                        <%} else {
                                            if (session.getAttribute("admin") == "admin") {
                                        %>
                                        <li class="nav-item">
                                            <a class="nav-link active" href="admin.jsp">Admin</a>
                                        </li>
                                        <%} else {

                                        %>
                                        <li class="nav-item">
                                            <a class="nav-link" href="usuario.jsp">Usuarios</a>
                                        </li>

                                        <% }
                                                }
                                            }
                                        %>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end header inner -->
            <!-- end header -->
            <!-- banner -->

        </header>
        <!-- end banner -->
        <!-- Título -->
        <div class="back_re">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title">
                            <h2>Nuestras Instituciones</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- our classes -->
        <div class="classes">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="titlepage">
                            <p><br>
                                El municipio de Caldas cuenta con 14 sedes rurales, <br>
                                si desea donar a alguna de ellas comuniquese al número celular
                                <br>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/1.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Colegio Dario Gutierrez</h1>
                                Vereda Primavera<br>
                                302 123 4695
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/2.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural El Sesenta</h1>
                                Vereda El Sesenta<br>
                                300 675 6785
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/3.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural La Clara</h1>
                                Vereda La Clara<br>
                                301 453 5678
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/4.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Luis Javier García Isaza</h1>
                                Vereda La Salada<br>
                                302 467 3456
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/5.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Claudina Munera</h1>
                                Vereda La Carola<br>
                                304 567 6789
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/8.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Maní del Cardal</h1>
                                Vereda La Maní<br>
                                318 675 2222
                                </p>
                            </div>
                        </div>
                    </div>
                   
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/7.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Salinas</h1>
                                Vereda Salinas<br>
                                315 642 2312
                                </p>
                            </div>
                        </div>
                    </div>
                     <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/6.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. El Cano</h1>
                                Vereda El Cano<br>
                                310 567 6756
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/9.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Sinifaná</h1>
                                Vereda Sinifaná<br>
                                310 123 5890
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/13.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. La Colina Amigo</h1>
                                Vereda La Raya<br>
                                301 543 6512
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/11.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural Cardalito</h1>
                                Vereda Cardalito<br>
                                321 123 4567
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/12.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural La Chuscala</h1>
                                Vereda Chuscala<br>
                                322 097 5398
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/10.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Rural San Francisco</h1>
                                Vereda La Quiebra<br>
                                312 789 0056
                                </p>
                            </div>
                        </div>
                    </div>
                 
                    <div class="col-md-4 col-sm-6 margin_bott">
                        <div class="card">
                            <img class="card-img" src="images/14.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text"> 
                                <h1>Inst. Monseñor Pedro Luis Alvarez Correa</h1>
                                Vereda La Miel<br>
                                300 300 1111
                                </p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- end our classes -->

        <!--  footer -->
        <footer>
            <div class="footer">
                <div class="container">

                    <div class="row">
                        <div class="col-md-4">
                            <h3>LINKS</h3>
                            <ul class="link_menu">
                                <li><a href="index.jsp">Inicio</a></li>
                                <li><a href="nosotros.jsp"> Nosotros</a></li>
                                <li><a href="instituciones.jsp">Instituciones</a></li>
                                <li><a href="necesidades.jsp">Necesidades</a></li>
                                <li><a href="testimonios.jsp">Testimonios</a></li>
                                <li><a href="usuario.jsp">Usuarios</a></li>
                            </ul>
                        </div>
                        <div class=" col-md-3">
                            <h3>Acción Solidaria</h3>
                            <p class="many">
                                Somos un equipo enfocado en reducir la brecha educativa rural en el municipio de Caldas, Antioquia 
                            </p>
                        </div>
                        <div class="col-lg-3 offset-mdlg-2     col-md-4 offset-md-1">
                            <h3>Contacto </h3>
                            <ul class="conta">
                                <li><i class="fa fa-map-marker" aria-hidden="true"></i> Caldas, Antioquia</li>
                                <li> <i class="fa fa-envelope" aria-hidden="true"></i><a href="#"> Acsolid@gmail.com</a></li>
                                <li><i class="fa fa-mobile" aria-hidden="true"></i> Cel: 321 456 9870</li>
                            </ul>
                            <ul class="social_icon">
                                <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="copyright">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-10 offset-md-1">
                                <p>© 2022 Acción Solidaria <a href="https://html.design/"></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- end footer -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>