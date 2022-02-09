
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Account</title>
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
       <form action="updateaccount" method="POST">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Values</th>
            </tr>
            <tr>
                <td>Account ID</td>
                <td>${account.accId}<input type="hidden" value="${account.accId}" name="accid"/></td>
            </tr>   
            <tr>
                <td>User Name</td>
                <td><input class="inp-500" type="text" value="${account.username}" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" value="${account.password}" name="password" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><input type="text" value="${account.firstName}" name="fname" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input class="inp-500" type="text" value="${account.lastName}" name="lname" /></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><select name="accrole" >
                    <option value="true"  selected="">User</option>
                    <option value="false">Admin</option>   
                    </select>
                </td>
              
            </tr>
        </table>
           
            
        <input class="btn" type="submit" value="Save"/>
        </form>
    </body>
</html>
