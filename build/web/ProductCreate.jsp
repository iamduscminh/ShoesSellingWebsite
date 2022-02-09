
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>
    <style>
        input{
            height: 20px;
        }
        .inp-500{
            width: 500px;
        }
        table{
            margin-left: 32px;
            position: relative;
        }
/*        table,th,td {
            border: 1px solid black;
        }*/
        table td{
            padding: 5px;
        }
        .btn{
            margin-top: 16px;
            margin-left: 32px;
        }
    </style>
    <body>
        <form action="createproduct" method="POST">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>ID</td>
                <td><input type="text" value="" name="prdid"/></td>
            </tr>   
            <tr>
                <td>Name</td>
                <td><input class="inp-500" type="text" value="" name="prdname" /></td>
            </tr>
            <tr>
                <td>Form</td>
                <td><input type="text" value="" name="prdform" /></td>
            </tr>
            <tr>
                <td>Category Id</td>
                <td>
                    <select name="prdcateid" >
                     <c:forEach items="${prdCates}" var="c" varStatus="loop">
                        <option value="${c.ctgId}">${c.ctgName}</option>
                     </c:forEach>     
                    </select>
                </td>
               
            </tr>
            <tr>
                <td>Description</td>
                <td><input class="inp-500" type="text" value="" name="prddes" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" value="" name="prdprice" /></td>
            </tr>
            <tr>
                <td>Status</td>
                <td><input type="text" value="" name="prdstatus" /></td>
            </tr>
            <tr>
                <td>Image 1</td>
                <td><input class="inp-500" type="text" value="" name="prdimg1" /></td>
            </tr>
            <tr>
                <td>Image 2</td>
                <td><input class="inp-500" type="text" value="" name="prdimg2" /></td>
            </tr>
            <tr>
                <td>Image 3</td>
                <td><input class="inp-500" type="text" value="" name="prdimg3" /></td>
            </tr>
            <tr>
                <td>Image 4</td>
                <td><input class="inp-500" type="text" value="" name="prdimg4" /></td>
            </tr>
        </table>
           
            
        <input class="btn" type="submit" value="Create"/>
        </form>
    </body>
</html>
