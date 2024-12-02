<%-- 
    Document   : header
    Created on : Sep 13, 2024, 2:54:23 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header id="header">
    <a href="HomeServlet"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a class="active" href="HomeServlet">Home</a></li>
        <li>
            <a href="ShopServlet">Shop</a>
            <ul class="sub-menu">
                <c:forEach items="${categoryList}" var="category">
                    <li class="nemu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
        </li>
    </ul>
</li>
<li><a href="BlogServlet">Blog</a></li>
<li><a href="AboutServlet">About</a></li>
<li><a href="ContactServlet">Contact</a></li>
<li><a href="CartServlet"><i class="fa-solid fa-bag-shopping"></i></a></li>
<li>
    <c:if test="${sessionScope.user == null}">
        <a href="LoginServlet">Login</a>
    </c:if>

    <c:if test="${sessionScope.user != null}">
        <a href="LogoutServlet">Logout</a>
    </c:if>
</li>
</ul>
</header>
