<%@ page import="java.util.List" %>
<%@ page import="com.example.student.model.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
</head>
<body>
<h2>All Students</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Course</th>
    </tr>
    <%
        if (students != null) {
            for (Student s : students) {
    %>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getEmail()%></td>
        <td><%=s.getCourse()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="index.jsp">Home</a>
</body>
</html>
