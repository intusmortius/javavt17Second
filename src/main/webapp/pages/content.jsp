<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/basic.css" rel="stylesheet">
    ​
    <script src="<c:url value="/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>
    ​
    <title>CRUD - ${title}</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}<small> crud operations</small></h1>
                    </div>
                </div>
                <div class="alert alert-info" role="alert">
                    <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/${instrument}/pdfReport?view=pdfView" target="_blank">Download PDF report</a>
                    <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/${instrument}/xlsxReport.xlsx?view=excelView" target="_blank">Download Excel report</a>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Director</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-brands">
                            <thead>
                            <th><button class="sort" data-sort="director-last_name">Name</button></th>
                            <th><button class="sort" data-sort="founded-year">Surname</button></th>
                            <th><button class="sort" data-sort="headquarter">Year</button></th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="director" items="${listDirector}" varStatus="status">
                                <tr>
                                    <td class="director-last_name">${director.lastName}</td>
                                    <td class="director-first">${director.firstName}</td>
                                    <td class="founded-year">${director.year}</td>
                                    <td class="action">
                                        <a href="${pageContext.request.contextPath}/${instrument}/edit-director/${director.idDirector}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/${instrument}/delete-director/${director.idDirector}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/${instrument}/addDirector">Add new director &raquo</a></div>
                    </div>
                    ​
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Films</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-models">
                            <thead>
                            <th><button class="sort" data-sort="brand-name">Name</button></th>
                            <th><button class="sort" data-sort="model-name">Director</button></th>
                            <th><button class="sort" data-sort="production-year">Released</button></th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="film" items="${listFilm}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${film.director.toString()}</td>
                                    <td class="model-name">${film.name}</td>
                                    <td class="production-year">${film.year}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/${instrument}/edit-film/${film.idFilm}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath}/${instrument}/delete-film/${film.idFilm}">Delete</a>
                                    </td>
                                    ​
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/${instrument}/addFilm">Add new film &raquo</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/list.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/content-list.js"></script>
</body>
</html>