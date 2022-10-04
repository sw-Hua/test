<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!--     最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <br>
    <table class="table table-bordered table-hover table-striped container" style="max-width: 900px" >
        <tr  style="background-color:rgb(40,40,40);color: rgb(225,225,225)">
            <th width="10%">ID</th>
            <th width="15%">name</th>
            <th width="10%">type</th>
            <th width="10%">price</th>
            <th width="10%">num</th>
            <th width="12%">oprate</th>
        </tr>
        <c:forEach items="${cart }" var="t">
            <tr>
                <td><p>${t.id }</p></td>
                <td><p>${t.foodname }</p></td>
                <td><p>${t.type }</p></td>
                <td><p>${t.price }</p></td>
                <td><p>${t.num }</p></td>
                <td>
                    <a href="/delete?id=${t.id}">
                        <button class="btn-danger">delete food</button>
                    </a>
                    <a href="/add?id=${t.id}">
                        <button class="btn btn-info">add</button>
                    </a>
                    <a href="/sub?id=${t.id}">
                        <button class="btn btn-info">sub</button>
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <a href="/payment.jsp" style="margin-left: 130px">
        <button class="btn-success">submit order</button>
    </a>


</div>
</body>
</html>
