<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 20/11/24
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ</title>
</head>
<body>
<form action="/danh-muc/add" method="post">
    Id: <input type="text" name="id" value="${dm.id}">
    <h3>${message5}</h3>
    <br>
    Mã danh mục: <input type="text" name="maDanhMuc" value="${dm.maDanhMuc}">
    <h3>${message}</h3>
    <br>
    Tên danh mục: <input type="text" name="tenDanhMuc" value="${dm.tenDanhMuc}">
    <h3>${message1}</h3>
    <br>
    Trạng thái:  <input type="text" name="trangThai" value="${dm.trangThai}">
    <h3 id="m2">${message2}</h3>
    <br>
    Ngày tạo: <input type="date" name="ngayTao" value="${dm.ngayTao}">
    <h3>${message3}</h3>
    <br>
    Ngày sửa: <input type="date" name="ngaySua" value="${dm.ngaySua}">
    <h3>${message4}</h3>
    <br>
    <button type="submit" onclick="ConfirmAndAlert1()">Add</button>
    <button type="submit" formaction="/danh-muc/update" onclick="ConfirmAndAlert2()">Update</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Mã danh mục</th>
        <th>Tên danh mục</th>
        <th>Trạng thái</th>
        <th>Ngày tạo</th>
        <th>Ngày sửa</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listCatagory}" var="dm">
            <tr>
                <td>${dm.id}</td>
                <td>${dm.maDanhMuc}</td>
                <td>${dm.tenDanhMuc}</td>
                <td>${dm.trangThai}</td>
                <td>${dm.ngayTao}</td>
                <td>${dm.ngaySua}</td>
                <td>
                    <button>
                        <a href="/danh-muc/detail?id=${dm.id}">Detail</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Mã danh mục</th>
        <th>Tên sản phẩm</th>
        <th>Trạng thái</th>
        <th>Tên danh mục</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.idDanhMuc.tenDanhMuc}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    function ConfirmAndAlert1() {
        const m2 = document.getElementById("m2").value;
        if (confirm('Bạn có muốn add không?')) {
            alert('Add thành công');
        } else  {
            event.preventDefault();
            return false;
        }
    }
    //thiếu trường hợp có validate thì hiển thị
    function ConfirmAndAlert2() {
        if (confirm('Bạn có muốn update không?')) {
            alert('Update thành công');
        } else {
            event.preventDefault();
            return false;
        }
    }
</script>
</body>
</html>
