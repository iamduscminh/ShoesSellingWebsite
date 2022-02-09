<%-- 
    Document   : CategoryUpdate
    Created on : Nov 2, 2021, 7:49:38 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
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

        table td{
            padding: 5px;
        }
        .btn{
            margin-top: 16px;
            margin-left: 32px;
        }
    </style>
    <body>
       <form action="updatecategory" method="POST">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>Category ID</td>
                <td>${category.ctgId}<input type="hidden" value="${category.ctgId}" name="cateid"/></td>
            </tr>   
            <tr>
                <td>Category Name</td>
                <td><input  type="text" value="${category.ctgName}" name="catename" /></td>
            </tr>
        </table>
           
            
        <input class="btn" type="submit" value="Save"/>
        </form>
    </body>
</html>
