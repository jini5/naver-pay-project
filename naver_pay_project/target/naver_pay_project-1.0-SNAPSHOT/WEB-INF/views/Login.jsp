<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: ���� 4:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<html>
<head>
    <title>�α��� ȭ��</title>

    <script type="text/javascript">

        function checkValue()
        {
            inputForm = eval("document.loginInfo");
            if(!inputForm.id.value)
            {
                alert("���̵� �Է��ϼ���");
                inputForm.id.focus();
                return false;
            }
            if(!inputForm.password.value)
            {
                alert("��й�ȣ�� �Է��ϼ���");
                inputForm.password.focus();
                return false;
            }
        }

        <!--ȸ������-->
        function goJoinForm() {
            location.href="JoinForm.jsp";
        }
    </script>

</head>
<body>
<div id="wrap">
    <form name="loginInfo" method="post" action="LoginSucceed.jsp"
          onsubmit="return checkValue()">

        <br>���̹� ���� ������Ʈ<br>

        <table>
            <tr>
                <td bgcolor="PowderBlue">���̵�</td>
                <td><input type="text" name="id" maxlength="50"></td>
            </tr>
            <tr>
                <td bgcolor="PowderBlue">��й�ȣ</td>
                <td><input type="password" name="password" maxlength="50"></td>
            </tr>
        </table>
        <br>
        <div class="checkbox_form">
            <label for="save">AUTO SAVE: </label>
            <input id="save" type="checkbox" name="save"/>
        </div>
        <input type="submit" value="�α���"/>
        <input type="button" value="ȸ������" onclick="JoinForm()" />

    </form>

    <%
        String msg=request.getParameter("msg");

        if(msg!=null && msg.equals("0"))
        {
            out.println("<br>");
            out.println("<font color='red' size='5'>��й�ȣ�� Ȯ���� �ּ���.</font>");
        }
        else if(msg!=null && msg.equals("-1"))
        {
            out.println("<br>");
            out.println("<font color='red' size='5'>���̵� Ȯ���� �ּ���.</font>");
        }
    %>
</div>
</body>
</html>

