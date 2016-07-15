<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

	<%@include file="../shared/header.jsp" %>

	<jsp:include page="../shared/title.jsp">
		<jsp:param value="Contact Us" name="title"/>
	</jsp:include>
	
</head>

<body>

	<%@include file="../shared/menu.jsp" %>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
			<div class="col-xs-12">
				<h3>Contact Us</h3>
				<hr/>
				<p>NIIT Ghatkopar</p>	
        	</div>					
        </div>
        <!-- /.row -->


        <!-- Footer -->
        
        <%@include file="../shared/footer.jsp" %>
        

    </div>
    <!-- /.container -->

	<%@include file="../shared/scripts.jsp" %>

</body>

</html>
