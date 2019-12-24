<%@ page import="java.util.List" %>
<%@ page import="com.netcracker.tc.server.persistence.model.report.Report" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Детальная информация</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/report.css' />" />
</head>
<body>

<div class ="logoDiv">
    <img src='<c:url value="/resource/loading/logoNC.JPG"></c:url>' />
</div>

<div class="container">
    <div class ="btns">
        <button  onclick="func()">Фильтрация</button>

        <form action="downloadDetailInfo">
        <input   type="submit"  id="downloadBtn"  value="Загрузить"/>
        </form>

        <input   id="printBtn" type="submit" value="Печать"/>
    </div>

    <br/>
        <input  id="nameFiltr" style="display: none" type="text" placeholder="По студенту" size="20">
        <input id="dateFiltr"  style="display: none"type="text" placeholder="По дате" size="20">
        <input class ="btn" id="filtrBtn"  style="display: none" type="submit" value="Фильтрация"/>
   <br/>

    <table class ="tbl" cellspacing='0'>
        <tr>
            <th>Студент</th>
            <th>Дата интервью</th>
            <th>Начало интервью с HR</th>
            <th>Конец интервью с HR</th>
            <th>Начало  интервью с INTERVIEWER</th>
            <th>Конец интервью с INTERVIEWER</th>
        </tr>

        <%
            List<Report> list = (List) request.getAttribute("reportList");
        %>

        <%
            for (Report report : list) {
        %>
        <tr>
            <td><%=report.getStudent()%></td>
            <td><%=report.getDateInterview()%></td>
            <td><%=report.getStartTimeHr()%></td>
            <td><%=report.getEndTimeHr()%></td>
            <td><%=report.getStartTimeInterviewer()%></td>
            <td><%=report.getEndTimeInterviewer()%></td>
        </tr>
        <%
            }
        %>

    </table>

</div>

<script>
    function func(){
        var x = document.getElementById("nameFiltr");
        var y = document.getElementById("dateFiltr");
        var z = document.getElementById("filtrBtn");
        if (x.style.display === "none" && y.style.display === "none" && z.style.display === "none") {
            x.style.display = "inline";
            y.style.display = "inline";
            z.style.display = "inline";

        }

    }
</script>

</body>
</html>
