<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Declaration</title>
    <style>
        table {
            width: 100%;
        }

        input {
            width: 100%;
        }

        h2, h4, h6 {
            text-align: center;
        }

        span {
            color: red;
        }
    </style>
</head>
<body>
<h2 style="color: #0095ff">TỜ KHAI Y TẾ</h2>
<h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM </h4>
<h6 style="color: red">khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử phạt hình
    sự</h6>

<form:form action="/addMedicalDeclaration" method="post" modelAttribute="medicalDeclaration">
    <table>
        <tr>
            <td colspan="6">
                <label>Họ và tên: (Ghi chữ IN HOA)<span>(*)</span></label><br>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <label>Năm sinh:<span>(*)</span></label><br>
                <form:select cssStyle="width: 100%" path="dateOfBirth">
                    <form:option value="1990"/>
                    <form:option value="1991"/>
                    <form:option value="1992"/>
                    <form:option value="1993"/>
                    <form:option value="1994"/>
                    <form:option value="1995"/>
                    <form:option value="1996"/>
                    <form:option value="1997"/>
                    <form:option value="1998"/>
                    <form:option value="1999"/>
                    <form:option value="2000"/>
                </form:select>

            </td>
            <td colspan="2">
                <label>Giới tính:<span>(*)</span></label><br>
                <form:select cssStyle="width: 100%" path="gender">
                    <form:option value="male"/>
                    <form:option value="female"/>
                    <form:option value="LGBT"/>
                </form:select>
            </td>
            <td colspan="2">
                <label>Quốc tịch:<span>(*)</span></label><br>
                <form:select cssStyle="width: 100%" path="country">
                    <form:option value="Việt Nam"/>
                    <form:option value="Trung Quốc"/>
                    <form:option value="Nhật Bản"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <label>Sổ hộ chiếu hoặc giấy cccd hoặc các giấy thông hành khác:<span>(*)</span></label><br>
                <form:input path="idCard"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <label>Thông tin đi lại:<span>(*)</span></label><br>
            </td>
        </tr>
        <tr>
            <td>
                <form:radiobutton path="vehicle" value="Máy bay"/> Máy bay
            </td>
            <td>
                <form:radiobutton path="vehicle" value="Tàu thuyền"/> Tàu thuyền
            </td>
            <td>
                <form:radiobutton path="vehicle" value="Ô tô"/> Ô tô
            </td>
            <td colspan="3">
                Khác:(Ghi rõ)
                <form:input path="vehicle"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <label>Số hiệu phương tiện:<span>(*)</span></label><br>
                <form:input path="vehiclePLate"/>
            </td>
            <td colspan="3">
                <label>Số ghế:<span>(*)</span></label><br>
                <form:input path="numberOfSeat"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <label>Ngày khởi hành:<span>(*)</span></label><br>
                <form:input type="date" path="startDate"/>
            </td>
            <td colspan="3">
                <label>Ngày kết thúc:<span>(*)</span></label><br>
                <form:input type="date" path="endDate"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?<span>(*)</span></label><br>
                <form:input path="addressTravel"/>
            </td>
        </tr>
        <tr>
            <td colspan="6" style="text-align: center">
                <input type="submit" value="Gửi tờ khai">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
