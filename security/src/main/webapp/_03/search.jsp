<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<meta charset="UTF-8">
<title></title>
<link href="${pageContext.request.contextPath}/css/Task.css"
	rel="stylesheet" type="text/css" />
<script
	src=" http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/scripts/Task.js"></script>
</head>
<body>
	
<div class="page">
        <section id="main">
            <a href="/Task" class="back">Back to task list</a>

    <h1>Task 1 - between tags</h1>

    <form method="get" action="">
        Search: <input type="text" name="query" value=""/><input type="submit" value="Search" />
    </form>
    <br /><br />







    <div class="wrong solution">
        <b>Wrongly escaped HTML:</b>
        <pre>Searched for <i></i></pre>
    </div>

    <div class="right solution">
        <b>Correctly escaped:</b>
        <div>
            Searched for 
        </div>

        <b>Correctly escaped HTML:</b>
        <pre>Searched for <i></i></pre>
    </div>
        </section>
		<footer>
				www.insecurelabs.org is an educational tool. It's hosted by <a href="http://appharbor.com">AppHarbor</a>
		</footer>

    </div>

</body>
</html>