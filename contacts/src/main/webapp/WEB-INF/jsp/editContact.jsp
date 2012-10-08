<%@include file="taglib.jsp" %>

<html>
<head>
    <script type="text/javascript" src="js/contacts.js"></script>
    <title><spring:message code="App.Title"></spring:message> </title>
</head>
<body>

<table style="border-collapse: collapse;" width="750" align="center" bgcolor="lightblue" border="1" bordercolor="#006699" height="500">
    <tbody>
    <tr>
        <td align="center"><h3>Edit Contact Form</h3></td>
    </tr>
    <tr valign="top" align="center">
        <td align="center">

        <form:form action="updateContact.do" method="post" commandName="editContact">
            <table style="border-collapse: collapse;" width="500" border="0" bordercolor="#006699" cellpadding="2" cellspacing="2">
                <tbody>
                <tr>
                    <td width="100" align="right">Id</td>
                    <td width="150"> ${editContact.id} <form:hidden path="id" /></td>
                    <td align="left"> </td>
                </tr>
                <tr>
                    <td width="100" align="right">Name</td>
                    <td>  <form:input path="name"></form:input></td>
                    <td align="left"> <form:errors path="name" cssstyle="color:red"></form:errors></td>
                </tr>
                <tr>
                    <td width="100" align="right">DOB</td>
                    <td><form:input path="dob"></form:input></td>
                    <td align="left"><form:errors path="dob" cssstyle="color:red"></form:errors></td>
                </tr>
                 <tr>
                     <td width="100" align="right">Gender</td>
                     <td> <form:select path="gender">
                         <form:option value="M" label="Male" /><form:option value="F" label="Female"/>
                     </form:select>
                     </td>
                     <td> </td>
                 </tr>
                 <tr>
                     <td width="100" align="right">Address</td>
                     <td><form:input path="address"></form:input></td>
                     <td align="left"> <form:errors path="address" cssstyle="color:red"></form:errors></td>
                 </tr>
                 <tr>
                     <td width="100" align="right">Email</td>
                     <td><form:input path="email"></form:input></td>
                     <td align="left"><form:errors path="email" cssstyle="color:red"></form:errors></td>
                 </tr>
                 <tr>
                     <td width="100" align="right">Mobile</td>
                     <td><form:input path="mobile"></form:input></td>
                     <td align="left">  <form:errors path="mobile" cssstyle="color:red"></form:errors></td>
                 </tr>
                 <tr valign="bottom">
                     <td colspan="3" align="center">
                      <input value="Delete" onclick="javascript:deleteContact('deleteContact.do?id=${editContact.id}');" type="button">
                      <input name="" value="Save" type="submit">
                      <input value="Back" onclick="javascript:go('viewAllContacts.do');" type="button">
                     </td>
                 </tr>


                </tbody>
            </table>
        </form:form>
        </td>
    </tr>
</tbody>
</table>
</body>
</html>
