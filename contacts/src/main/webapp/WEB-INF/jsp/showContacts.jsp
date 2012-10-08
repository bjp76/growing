<%@include file="taglib.jsp" %>
<html>
<head>
    <title><spring:message code="App.Title"></spring:message></title>
    <script type="text/javascript" src="js/contacts.js"></script>
</head>
<body>
<center>


    <div>
    <form action="searchContacts.do" method="post">
        <table style="border-collapse: collapse;" width="500" border="0" bordercolor="#006699">
            <tbody>
            <tr>
                <td>Enter Contact Name</td>
                <td><input name="name" type="text">

                    <input value="Search" type="submit">

                    <input value="New Contact" onclick="javascript:go('saveContact.do');" type="button">

                </td>
            </tr>
            </tbody>
        </table>
    </form>
    </div>

    <c:if test="${empty contacts}">
        <spring:message code="no.contact.present"></spring:message>
    </c:if>



    <c:if test="${! empty contacts}">
        <table style="border-collapse: collapse;" width="500" border="1" bordercolor="#006699">
            <tr bgcolor="lightblue">
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Mobile</th>
                <th></th>
            </tr>
            <c:forEach var="contact" items="${contacts}">
            <tr>
                <td><c:out value="${contact.id}"></c:out></td>
                <td><c:out value="${contact.name}"></c:out></td>
                <td><c:out value="${contact.address}"></c:out></td>
                <td><c:out value="${contact.mobile}"></c:out></td>
                <td> <a href="updateContact.do?id=${contact.id}">Edit</a>
                    <a href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </c:if>

</center>

</body>
</html>