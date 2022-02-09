
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Size</title>
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
        <form action="createsize" method="POST">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>Product ID</td>
                <td>
                    <select name="prdid" >
                     <c:forEach items="${products}" var="p" varStatus="loop">
                        <option value="${p.prdId}">${p.prdId}</option>
                     </c:forEach>     
                    </select>
                </td>
            </tr>   
            <tr>
                <td>Product Size</td>
                <td><input type="text" value="" name="prdsize" /></td>
            </tr>
            <tr>
                <td>Amount</td>
                <td><input type="text" value="" name="prdamount" /></td>
            </tr>
        </table>
           
            
        <input class="btn" type="submit" value="Create"/>
        </form>
    </body>
</html>
