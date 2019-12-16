
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Детальная информация</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/report.css' />" />
</head>
<body>

<div class="container">

<div class ="logoDiv">
    <img src='<c:url value="/resource/loading/logoNC.JPG"></c:url>' />
</div>


    <div class ="btns">
        <button  onclick="func()">Фильтрация</button>
        <input   id="downloadBtn" type="submit" value="Загрузить"/>
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

        <tr>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>

        </tr>
        <tr>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>

        </tr>
        <tr>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>

        </tr>
        <tr>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>

        </tr>

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
