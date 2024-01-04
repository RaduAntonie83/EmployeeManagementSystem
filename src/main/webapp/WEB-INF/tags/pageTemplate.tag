<%@tag description="base page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle"%>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body style="background: url('https://img.freepik.com/free-vector/dark-blue-gradient-background_78370-2078.jpg?size=626&ext=jpg&ga=GA1.1.1222169770.1703030400&semt=ais') center/cover no-repeat; height: 100vh; margin: 0;">
    <jsp:include page="/WEB-INF/pages/menu.jsp" />
    <main class="container-fluid mt-5">
        <jsp:doBody/>
    </main>
    <jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>