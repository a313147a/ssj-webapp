<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/30
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="/static/jq/jquery-1.11.3/jquery.min.js" ></script>
<body>
<input type="file" id="file1" name="file1">
<button onclick="importFile();">上传</button>

    <script>
        function importFile(){
            var baseURL = window.location.protocol+'//'+window.location.host+'/';
            alert(window.location.protocol+'//'+window.location.host+'/');
            var formData = new FormData();
            formData.append("files", $("#file1")[0].files[0]);
            $.ajax({
                type:'POST',
                url:baseURL + "ssj/add",
                data:formData,
                contentType:false,
                processData:false,//这个很有必要，不然不行
                dataType:"json",
                mimeType:"multipart/form-data",
                success:function(data){
                    if(200==data.code){
                        alert("保存成功");
                        //window.parent.Consult.table.refresh();
                        ConInfoDlg.close();
                    }else{
                        alert("保存shibai");
                        //Feng.error("保存失败!"+data.message);
                    }
                }
            });
        }
    </script>
</body>
</html>
