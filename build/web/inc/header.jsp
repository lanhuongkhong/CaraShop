<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lan.dev.lang.messages" />

<!-- HEADER JSP WITH UPDATED LINKS -->
<header id="header">
    <a href="index.html"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a class="active" href="HomeServlet"><fmt:message key="home" /></a></li>
        <li>
            <a href="ShopServlet?page=1"><fmt:message key="shop" /></a>
            <ul class="sub-menu">
                <c:forEach var="category" items="${categoryList}">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="blog.jsp"><fmt:message key="blog" /></a></li>
        <li><a href="about.jsp"><fmt:message key="about" /></a></li>
        <li><a href="contact.jsp"><fmt:message key="contact" /></a></li>
        <li><a href="cart.jsp"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li><a href="user.jsp"><i class="fa-solid fa-user"></i></a></li>
        <li>
            <c:if test="${sessionScope.user == null}">
            <a href="LoginServlet"><fmt:message key="login" /></a> 
            </c:if>
            <c:if test="${sessionScope.user != null}">
            <a href="LogoutServlet"><fmt:message key="logout" /></a>
            </c:if>
        </li>
        <!-- Dropdown menu for language selection -->
        <li>
            <select id="languageDropdown" onchange="changeLanguage()">
                <option value="en" <c:if test="${sessionScope.lang == 'en'}">selected</c:if>>EN</option>
                <option value="vi" <c:if test="${sessionScope.lang == 'vi'}">selected</c:if>>VN</option>
            </select>
        </li>
    </ul>
</header>

<script>
    function changeLanguage() {
        var selectedLang = document.getElementById("languageDropdown").value;
        window.location.href = "ChangeLanguageServlet?lang=" + selectedLang;
    }
</script>
