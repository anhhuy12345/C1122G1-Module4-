<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/29/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Soccer's Player</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center" style="color: brown">Soccer's Player List</h1>
<div>
    <div>
        <form action="/soccer/searchByName" method="get">
            <input type="text" name="soccerNameSearch" value="${soccerNameSearch}">
            <button type="submit">Search</button>
        </form>
    </div>
    <div>
        <button type="button" class="btn btn-primary" onclick="window.location.href='http://localhost:8080/soccer/create'">
            Add new FootballPlayer
        </button>
    </div>

</div>
<table class="table table-striped able-bordered table-hover">
    <tr>
        <th>Mã cầu thủ</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Kinh nghiệm</th>
        <th>Vị trí</th>
        <th>Kinh Nghiệm</th>
    </tr>
    <c:forEach var="soccerPlayer" items="${soccerList}">

        <tr>
            <td>${soccerPlayer.id}</td>
            <td>${soccerPlayer.name}</td>
            <td>${soccerPlayer.birthDay}</td>
            <td>${soccerPlayer.experience}</td>
            <td>${soccerPlayer.position}</td>
            <td><img src="${soccerPlayer.picture}" alt="" width="50px" height="50px"></td>
            <td>
            <td><button class="btn btn-primary btn-sm" onclick="window.location.href='http://www.localhost:8080/soccer/showUpdateForm/${soccerPlayer.id}'">update</button></td>
            </td>
            <td>
                <button type="button" onclick="infoDelete(${soccerPlayer.id},'${soccerPlayer.name}')"
                        class="btn btn-danger btn-sm"
                        data-toggle="modal" data-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="modal fade" id="AddModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Box</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/soccer/addNewSoccer" method="post"  >
                <div class="modal-body">
                    <label for="id" class="col-form-label">Số Thứ Tự</label>
                    <input type="text" class="form-control" id="id">
                    <label for="name" class="col-form-label">Tên Cầu Thủ</label>
                    <input type="text" class="form-control" id="name">
                    <label for="birthDay" class="col-form-label">Ngày Sinh</label>
                    <input type="text" class="form-control" id="birthDay">
                    <label for="experience" class="col-form-label">Kinh Nghiệm</label>
                    <input type="text" class="form-control" id="experience">
                    <label for="position" class="col-form-label">Vị Trí</label>
                    <input type="text" class="form-control" id="position">
                    <label for="picture" class="col-form-label">Hình Ảnh</label>
                    <input type="text" class="form-control" id="picture">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--Modal delete--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Box</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/soccer/deleteSoccer" method="post">
                <div class="modal-body">
                    <input hidden type="text" id="idDelete" name="idDelete">
                    <span>You may want to delete </span><span style="color: red" class="fw-bolder"
                                                              id="nameDelete"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
