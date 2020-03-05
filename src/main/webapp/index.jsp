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
    <form name="parserform" action="controller" method="POST" enctype='multipart/form-data'>
        <div class="my-flex-block">
            <div class="my-flex-block_file">
                <input class="input_item_file" type="file" name="file" id="file" readonly>
            </div>
        </div>
        <div class="my-flex-block" style="height: 10%">
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
        <div class="my-flex-block" style="height: 15%">
            <input class="input_item_submit" type="submit" value="submit">
        </div>
    </form>
</div>
</body>
</html>