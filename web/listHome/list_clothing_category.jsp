<%--
  Created by IntelliJ IDEA.
  User: holoi
  Date: 4/15/20
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clothing List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="../index.css">
    <link rel="stylesheet" type="text/css" href="../footer.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">THE BOUTIQUE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item m-auto">
                    <a class="nav-link" href="${pageContext.request.contextPath}/clothing?action=clothing">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="category.html">Categories</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="product.html">Product</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="contact.html">Cart <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Contact</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                           placeholder="Search...">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="cart.html">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>

<div class="container pt-5">
    <div class="row">
        <div class="col-md-4 order-md-1 col-lg-3 sidebar-filter">
            <h3 class="mt-0 mb-5">Showing <span class="text-primary">12</span> Products</h3>
            <h6 class="text-uppercase font-weight-bold mb-3">Categories</h6>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-1">
                    <label class="custom-control-label" for="category-1">Accessories</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-2">
                    <label class="custom-control-label" for="category-2">Coats &amp; Jackets</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-3">
                    <label class="custom-control-label" for="category-3">Hoodies &amp; Sweatshirts</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-4">
                    <label class="custom-control-label" for="category-4">Jeans</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-5">
                    <label class="custom-control-label" for="category-5">Shirts</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="category-6">
                    <label class="custom-control-label" for="category-6">Underwear</label>
                </div>
            </div>
            <div class="divider mt-5 mb-5 border-bottom border-secondary"></div>
            <h6 class="text-uppercase mt-5 mb-3 font-weight-bold">Size</h6>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="filter-size-1">
                    <label class="custom-control-label" for="filter-size-1">X-Small</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="filter-size-2">
                    <label class="custom-control-label" for="filter-size-2">Small</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="filter-size-3">
                    <label class="custom-control-label" for="filter-size-3">Medium</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="filter-size-4">
                    <label class="custom-control-label" for="filter-size-4">Large</label>
                </div>
            </div>
            <div class="mt-2 mb-2 pl-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="filter-size-5">
                    <label class="custom-control-label" for="filter-size-5">X-Large</label>
                </div>
            </div>
            <div class="divider mt-5 mb-5 border-bottom border-secondary"></div>
            <h6 class="text-uppercase mt-5 mb-3 font-weight-bold">Price</h6>
            <div class="price-filter-control">
                <input type="number" class="form-control w-50 pull-left mb-2" value="50" id="price-min-control">
                <input type="number" class="form-control w-50 pull-right" value="150" id="price-max-control">
            </div>
            <input id="ex2" type="text" class="slider " value="50,150" data-slider-min="10" data-slider-max="200"
                   data-slider-step="5" data-slider-value="[50,150]" data-value="50,150" style="display: none;">
            <div class="divider mt-5 mb-5 border-bottom border-secondary"></div>
            <a href="#" class="btn btn-lg btn-block btn-primary mt-5">Update Results</a>
        </div>

        <div class="col-md-8 order-md-2 col-lg-9">
            <div class="container-fluid">

                <div class="row   mb-5">
                    <div class="col-12">
                        <div class="dropdown text-md-left text-center float-md-left mb-3 mt-3 mt-md-0 mb-md-0">
                            <label class="mr-2">Sort by:</label>
                            <a class="btn btn-lg btn-light dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Relevance <span class="caret"></span></a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" x-placement="bottom-start"
                                 style="position: absolute; transform: translate3d(71px, 48px, 0px); top: 0px; left: 0px; will-change: transform;">
                                <a class="dropdown-item" href="#">Relevance</a>
                                <a class="dropdown-item" href="#">Price Descending</a>
                                <a class="dropdown-item" href="#">Price Ascending</a>
                                <a class="dropdown-item" href="#">Best Selling</a>
                            </div>
                        </div>
                        <div class="btn-group float-md-right ml-3">
                            <button type="button" class="btn btn-lg btn-light"><span class="fa fa-arrow-left"></span>
                            </button>
                            <button type="button" class="btn btn-lg btn-light"><span class="fa fa-arrow-right"></span>
                            </button>
                        </div>
                        <div class="dropdown float-right">
                            <label class="mr-2">View:</label>
                            <a class="btn btn-lg btn-light dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">9 <span class="caret"></span></a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown"
                                 x-placement="bottom-end"
                                 style="will-change: transform; position: absolute; transform: translate3d(120px, 48px, 0px); top: 0px; left: 0px;">
                                <a class="dropdown-item" href="#">12</a>
                                <a class="dropdown-item" href="#">24</a>
                                <a class="dropdown-item" href="#">48</a>
                                <a class="dropdown-item" href="#">96</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <c:forEach items='${requestScope["clothing"]}' var="clothing">
                        <div class="col-6 col-md-6 col-lg-4 mb-3">
                            <div class="product-grid">
                                <div class="product-image">
                                    <a href="#">
                                        <img class="pic-1" src="${clothing.getPicture()}"
                                             alt="picture">
                                        <img class="pic-2" src="${clothing.getPicture()}" alt="pic">
                                    </a>
                                    <span class="product-new-label">Sale</span>
                                    <span class="product-discount-label">${clothing.getStatus()}</span>
                                </div>
                                <div class="product-content">
                                    <h3 class="title"><a href="#">Women's Blouse</a></h3>
                                    <div class="price">$16.00
                                        <span>$20.00</span>
                                    </div>
                                    <a class="add-to-cart" href="">+ Add To Cart</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="row sorting mb-5 mt-5">
                    <div class="col-12">
                        <a class="btn btn-light">
                            <i class="fas fa-arrow-up mr-2"></i> Back to top</a>
                        <div class="btn-group float-md-right ml-3">
                            <button type="button" class="btn btn-lg btn-light"><span class="fa fa-arrow-left"></span>
                            </button>
                            <button type="button" class="btn btn-lg btn-light"><span class="fa fa-arrow-right"></span>
                            </button>
                        </div>
                        <div class="dropdown float-md-right">
                            <label class="mr-2">View:</label>
                            <a class="btn btn-light btn-lg dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">12 <span class="caret"></span></a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">12</a>
                                <a class="dropdown-item" href="#">24</a>
                                <a class="dropdown-item" href="#">48</a>
                                <a class="dropdown-item" href="#">96</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div
        <!-- Footer -->
<section id="footer">
    <div class="container">
        <div class="row text-center text-xs-center text-sm-left text-md-left">
            <div class="col-xs-12 col-sm-4 col-md-4">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Videos</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Videos</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href=""><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href="https://wwwe.sunlimetech.com" title="Design and developed by"><i class="fa fa-angle-double-right"></i>Imprint</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
                <ul class="list-unstyled list-inline social text-center">
                    <li class="list-inline-item"><a href=""><i class="fa fa-facebook"></i></a></li>
                    <li class="list-inline-item"><a href=""><i class="fa fa-twitter"></i></a></li>
                    <li class="list-inline-item"><a href=""><i class="fa fa-instagram"></i></a></li>
                    <li class="list-inline-item"><a href=""><i class="fa fa-google-plus"></i></a></li>
                    <li class="list-inline-item"><a href="" target="_blank"><i class="fa fa-envelope"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
                <p><u><a href="https://www.nationaltransaction.com/">National Transaction Corporation</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
                <p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="https://www.sunlimetech.com" target="_blank">Sunlimetech</a></p>
            </div>
        </div>
    </div>
</section>
</body>
</html>

