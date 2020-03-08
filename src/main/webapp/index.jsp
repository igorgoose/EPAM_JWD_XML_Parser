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
<body style="background-image: url(img/background3reverse.png); background-repeat: no-repeat; background-size: cover; background-position: center center;">
<div class="my-flex-container" style="height: 260px">
    <form name="parserform" action="controller" method="POST" enctype='multipart/form-data'>
        <div class="my-flex-block" >
            <div class="my-flex-block_file">
                <input class="input_item_file" type="file" name="file" id="file" accept=".xml" readonly>
            </div>
        </div>
        <div class="my-flex-block" style="height: 30px">
            <div class="my-flex-block_radio">
                <label>
                    <input class="input_item_radio" type="radio" name="command" value="PARSE_DOM" checked>
                </label>
                <label class="radio_label">DOM</label>
            </div>
            <div class="my-flex-block_radio">
                <label>
                    <input class="input_item_radio" type="radio" name="command" value="PARSE_SAX">
                </label>
                <label class="radio_label">SAX</label>
            </div>
            <div class="my-flex-block_radio">
                <label>
                    <input class="input_item_radio" type="radio" name="command" value="PARSE_STAX">
                </label>
                <label class="radio_label">STAX</label>
            </div>
        </div>
        <div class="my-flex-block">
            <input class="input_item_submit" type="submit" value="submit" height="40px">
        </div>
    </form>
</div>
</body>
</html>