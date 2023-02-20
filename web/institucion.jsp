<%-- 
    Document   : institucion
    Created on : 19/11/2022, 10:04:22 p. m.
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
        <title>Instituciones</title>
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
        <script type="text/javascript">
            function logout() {
                window.location = "ControladorAdministradores?accion=cerrarsesion";
            }
        </script>

    </head>
    <!-- body -->
    <body class="main-layout inner_page">
        <!-- header -->
    </head>
    <!-- body -->
<body class="main-layout">
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
                                        <a class="nav-link" href="instituciones.jsp">Instituciones</a>
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
                                        <a class="nav-link active" href="institucion.jsp">Institución</a>
                                    </li>
                                    
                                    <%} else {

                                    %>
                                    <li class="nav-item">
                                        <a class="nav-link active" href="usuario.jsp">Usuarios</a>
                                    </li>
                                    <% }
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
                        <h2>${nombre}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Fin Título -->

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="main_form">
                <div class="row">
                    <div class="col-md-12 ">
                        <img src="" alt="" width="90%">
                    </div>
                    <div class="col-md-12 ">
                        <form action="ControladorUsuarios" method="POST">
                            <button class="menuAdmin" name="accion" value="misdatos">
                                <li >
                                    <a class="">Mis datos</a>
                                </li>
                            </button>
                        </form>
                        <form action="ControladorDonaciones" method="POST">
                            <input type="hidden" name="idplantel" value="${idplantel}">       
                            <a class="menuAdmin" href="addDonacion1.jsp">Solicitar donación</a>
                            <button  name="accion" value="Listar1" class="menuAdmin"><a >Donaciones</a></button>
                            <a class="menuAdmin" href="addTestimonio1.jsp">Registrar testimonio</a>
                        </form>
                        <form action="ControladorTestimonios" method="POST">
                            <input type="hidden" name="idplantel" value="${idplantel}">       
                            <button  name="accion" value="Listar1" class="menuAdmin"><a>Testimonios</a></button>
                        </form>
                        <input value="Cerrar sesión" class="read_more ye_b5n " style="width: 100%" onclick=logout();>
                    </div>
                </div>  
            </div>
        </div>
    </div>                   
    <!-- FIN CRUD -->  


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
                            <p>© 2022 Acción Solidaria</p>
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
