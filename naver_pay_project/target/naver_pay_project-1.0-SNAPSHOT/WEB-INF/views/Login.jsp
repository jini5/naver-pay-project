<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<html>
<head>
    <%
        // 인코딩 처리
        request.setCharacterEncoding("euc-kr");
    %>
    <title>로그인 화면</title>

    <script type="text/javascript">

        function checkValue()
        {
            inputForm = eval("document.loginInfo");
            if(!inputForm.id.value)
            {
                alert("아이디를 입력하세요");
                inputForm.id.focus();
                return false;
            }
            if(!inputForm.password.value)
            {
                alert("비밀번호를 입력하세요");
                inputForm.password.focus();
                return false;
            }
        }

        // 회원가입 버튼 클릭시 회원가입 화면으로 이동
        function goJoinForm() {
            location.href="JoinForm.jsp";
        }
    </script>

</head>
<body>
<div id="wrap">
    <form name="loginInfo" method="post" action="LoginSucceed.jsp"
          onsubmit="return checkValue()">

        <!-- 이미지 추가 -->
        <br>네이버 페이 프로젝트<br>

        <table>
            <tr>
                <td bgcolor="PowderBlue">아이디</td>
                <td><input type="text" name="id" maxlength="50"></td>
            </tr>
            <tr>
                <td bgcolor="PowderBlue">비밀번호</td>
                <td><input type="password" name="password" maxlength="50"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="로그인"/>
        <input type="button" value="회원가입" onclick="JoinForm()" />
    </form>

    <%
        // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
        // LoginSucceed.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
        String msg=request.getParameter("msg");

        if(msg!=null && msg.equals("0"))
        {
            out.println("<br>");
            out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
        }
        else if(msg!=null && msg.equals("-1"))
        {
            out.println("<br>");
            out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
        }
    %>
</div>
</body>
</html>

