<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("    <tr>");
            out.write("        <td>" + member.getId() + "</td>");
            out.write("        <td>" + member.getUsername() + "</td>");
            out.write("        <td>" + member.getAge() + "</td>");
            out.write("    </tr>");
        }
    %>
    </tbody>
</table>

</body>
</html>
<%--지금은 http://java.sun.com/jsp/jstl/core 지원하지 않아 주석처리--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<a href="/index.html">메인</a>--%>
<%--<table>--%>
<%--    <thead>--%>
<%--    <th>id</th>--%>
<%--    <th>username</th>--%>
<%--    <th>age</th>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="item" items="${members}">--%>
<%--        <tr>--%>
<%--            <td>${item.id}</td>--%>
<%--            <td>${item.username}</td>--%>
<%--            <td>${item.age}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>