<%@ page import="java.util.List" %>
<%@ page import="com.netcracker.tc.server.persistence.model.report.Report" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Детальная информация</title>
   <!-- <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/report.css' />" />-->
    <style>
        body {
            background-color: #C9DDE8;
        }

        .container {
            background-color: white;
            margin-top: 5px;
            border-radius: 8px;
            padding-left: 10px;
            padding-right: 13px;
        }

        .filtr_inputs {
            visibility: hidden;
            display: inline;
            width: 10%;
            font-size: 12px;
            padding: 5px;
            margin-top: 10px;
        }

        .btn {
            background-color: #4AB0CE;
            color: white;
            width:10%;
            font-size: 14px;
            border: 1px solid white;
            font-weight: 500;
            padding: 4px 7px;
            border-radius: 3px;
            margin-top: 10px;
        }

        .tbl {
            font-family:Arial, Helvetica, sans-serif;
            color:black;
            font-size:12px;
            text-shadow: 1px 1px 0px #fff;
            background-color:white;
            border:#fff 1px solid;
            border-collapse:separate;

        }
        .tbl tr:hover td {
            background-color: #E8E8FF;
        }

        .tbl th {
            font-weight:bold;
            padding:10px 10px 10px 10px;
            border-top:1px solid #fafafa;
            border-bottom:1px solid #e0e0e0;
        }
        .tbl th:first-child{
            text-align: left;
            padding-left:20px;

        }
        .tbl tr{
            text-align: center;
            padding-left:10px;
        }
        .tbl tr td:first-child{
            text-align: left;
            padding-left:20px;
            border-left: 0;
        }
        .tbl tr td {
            padding:10px;
            border-top: 1px solid #e0e0e0;
            border-bottom:1px solid #e0e0e0;
        }
        .img-class{
            width:15px;
            height:15px;
        }
    </style>
</head>
<body>

<div class ="logoDiv">
    <img src='<c:url value="/resource/loading/logoNC.JPG"></c:url>' />
</div>

<div class="container">

        <form style="display:inline" action="downloadDetailInfo">
             <input class="btn" type="submit" id="downloadBtn" value="Загрузить"/>
        </form>

        <form style="display:inline" action="downloadDetailInfoPdf">
            <input class="btn" type="submit" id="printBtn" value="Печать"/>
        </form>
    <br/>

        <input class="filtr_inputs" id="nameFiltr" name="nameFiltr"  type="text" onkeyup="filtrateStudents()" placeholder="Поиск по студенту"  >
        <input class="filtr_inputs" id="dateFiltr" name="dateFiltr"  type="text" onkeyup="filtrateDates()" placeholder="Поиск по дате"  >


    <table class ="tbl" id ="tbl" cellspacing='0'>
        <tr>
            <th>Студент  <img src='<c:url value="/resource/loading/filter.png"></c:url>' id="filtr_st_img" class="img-class" ></th>
            <th>Дата интервью  <img src='<c:url value="/resource/loading/filter.png"></c:url>' id="filtr_da_img" class="img-class" ></th>
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
<br/>
</div>

<script>

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


    var input1 = document.getElementById("nameFiltr");
    var input2 = document.getElementById("dateFiltr");

    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var img1 = document.getElementById("filtr_st_img");
    var img2 = document.getElementById("filtr_da_img");

    img1.onclick = function(){
        input2.style.visibility = "hidden";
        input1.style.visibility = "visible";
    }
    img2.onclick = function(){
        input1.style.visibility = "hidden";
        input2.style.visibility = "visible";
    }
</script>

</body>
</html>
