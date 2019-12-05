<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/basic.css" rel="stylesheet">
    ​
    <script src="<c:url value="/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>
    ​
    <title>${title}</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${action} film <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="film" class="form-horizontal">
                        <form:hidden path="idFilm"/>
                        <div class="form-group">
                            <label for="idDirector" class="col-sm-3 control-label" >Director:</label>
                            <div class="col-sm-9">
                                <form:select path="idDirector" multiple="false" class="form-control">
                                    <c:forEach var="director" items="${listDirector}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${director.idDirector == film.idDirector}">
                                                <option selected value="${director.idDirector}">${director.lastName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${director.idDirector}">${director.lastName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Film name:</label>
                            <div class="col-sm-9">
                                <form:input path="name" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="year" class="col-sm-3 control-label">Year:</label>
                            <div class="col-sm-9">
                                <form:input path="year" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>