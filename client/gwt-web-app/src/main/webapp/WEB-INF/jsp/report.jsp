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
        <button class ="btns_class" id ="filtrateBtn" style="display: inline-block" onclick="func()">Фильтрация</button>

        <form style="display: inline-block"   action="downloadDetailInfo">
             <input  class ="btns_class" type="submit"  id="downloadBtn"  value="Загрузить"/>
        </form>

        <form  style="display: inline-block" action="downloadDetailInfoPdf">
            <input class ="btns_class"  id="printBtn" type="submit" value="Печать"/>
        </form>

    </div>

        <input class="filtr_inputs" id="nameFiltr" name="nameFiltr"  style="display: none" type="text" onkeyup="filtrateStudents()" placeholder="Поиск по студенту" size="12" >
        <input class="filtr_inputs" id="dateFiltr" name="dateFiltr"  style="display: none" type="text" onkeyup="filtrateDates()" placeholder="Поиск по дате" size="12" >


    <table class ="tbl" id ="tbl" cellspacing='0'>
        <tr>
            <th>Студент</th>
            <th>Дата интервью</th>
            <th>Начало интервью</th>
            <th>Конец интервью</th>
            <th>Время интервью с HR</th>
            <th>Время интервью с INTERVIEWER</th>
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
            <td><%=report.getStartInterview()%></td>
            <td><%=report.getEndInterview()%></td>
            <td><%=report.getHrTime()%></td>
            <td><%=report.getInterviewTime()%></td>
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
        if (x.style.display === "none" && y.style.display === "none") {
            x.style.display = "inline";
            y.style.display = "inline";
        }
    }

    function filtrateStudents() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("nameFiltr");
        filter = input.value.toUpperCase();
        table = document.getElementById("tbl");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }


    function filtrateDates() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("dateFiltr");
        filter = input.value.toUpperCase();
        table = document.getElementById("tbl");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

</body>
</html>
