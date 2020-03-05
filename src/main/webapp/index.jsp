<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.03.2020
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>XML Parser</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="my-flex-container">
    <form name="parserform" action="controller" method="POST">
        <div class="my-flex-block">
            <div class="my-flex-block">
                <input type="submit" name="command" value="PARSE_DOM">
            </div>
            <div class="my-flex-block">
                <input type="submit" name="command" value="PARSE_SAX">
            </div>
            <div class="my-flex-block">
                <input type="submit" name="command" value="PARSE_STAX">
            </div>
        </div>
    </form>
</div>
</body>
</html>
