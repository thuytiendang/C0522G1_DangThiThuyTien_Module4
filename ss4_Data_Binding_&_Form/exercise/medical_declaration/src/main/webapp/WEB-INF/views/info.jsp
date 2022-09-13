<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Medical Information</h2>
<table>
    <tr>
        <td colspan="6">
            Họ và tên: ${medicalDeclaration.name}
        </td>
    </tr>
    <tr>
        <td colspan="2">
            Năm sinh: ${medicalDeclaration.dateOfBirth}
        </td>
        <td colspan="2">
            Giới tính: ${medicalDeclaration.gender}
        </td>
        <td colspan="2">
            Quốc tịch: ${medicalDeclaration.country}
        </td>
    </tr>
    <tr>
        <td colspan="6">
           Sổ hộ chiếu hoặc giấy cccd hoặc các giấy thông hành khác: ${medicalDeclaration.idCard}
        </td>
    </tr>
    <tr>
        <td colspan="6">
            Thông tin đi lại: ${medicalDeclaration.vehicle}
        </td>
    </tr>
    <tr>
        <td colspan="3">
           Số hiệu phương tiện: ${medicalDeclaration.vehiclePLate}
        </td>
        <td colspan="3">
            Số ghế: ${medicalDeclaration.numberOfSeat}
        </td>
    </tr>
    <tr>
        <td colspan="3">
           Ngày khởi hành: ${medicalDeclaration.startDate}
        </td>
        <td colspan="3">
           Ngày kết thúc: ${medicalDeclaration.endDate}
        </td>
    </tr>
    <tr>
        <td colspan="6">
           Trong vòng 14 ngày qua,có đến tỉnh/thành phố: ${medicalDeclaration.addressTravel}
        </td>
    </tr>
</table>
</body>
</html>
