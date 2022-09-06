<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value='/js/jquery-1.12.2.min.js' />"></script>
<script>
$(document).ready(function(){
$('#clickme').click(function() {
	$( "#somediv" ).empty();
    $.getJSON("<c:url value='/ch04/_03/allBooks.json' />", function(categoriesJson) {
        var $table = $('<table border="1">').appendTo($('#somediv'));
        $.each(categoriesJson, function(index, category) {
            $('<tr>').appendTo($table)
                .append($('<td>').text(category.bookId))
                .append($('<td>').text(category.title))
                .append($('<td>').text(category.author))
                .append($('</tr>'));
        });
    });
});
});
</script>
</head>
<body>
<div id='somediv'>
</div>
<button id='clickme' >Click Me</button>
</body>
</html>