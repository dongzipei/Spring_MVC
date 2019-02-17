<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<form action="upload/fileUpload" method="post" enctype="multipart/form-data">
    上传:<input type="file" name="upload"><br/>
    <input type="submit" value="提交">
<a href="/user/sayHello">异常处理</a>
</form>
</body>
</html>
