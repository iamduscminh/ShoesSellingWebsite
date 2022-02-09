
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Category</title>
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
        <form action="createcategory" method="POST">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>Category ID</td>
                <td><input type="text" value="" name="ctgid"/></td>
            </tr>   
            <tr>
                <td>Category Name</td>
                <td><input class="inp-500" type="text" value="" name="ctgname" /></td>
            </tr>
           
        </table>
            
        <input class="btn" type="submit" value="Create"/>
        </form>
    </body>
</html>
