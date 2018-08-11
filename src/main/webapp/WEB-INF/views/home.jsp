<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Zip Code Challenge</title>
</head>
<body>

Entered Zip :<br/> ${inputZip} <br/><br/>
MergdMap: <br/>
<c:forEach items="${sortedZip}" var="entry">
    [ ${entry[0]},  ${entry[1]}],
</c:forEach>
<div>${errorMsg}</div>
</body>
</html>
