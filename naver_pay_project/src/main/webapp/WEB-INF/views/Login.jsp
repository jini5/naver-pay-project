<%@ page import="java.util.Arrays" %>
<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("./index.jsp");
    }

%>

<%

    ///////////////// 쿠키 값 중 로그인하기 위해서 무조건 있어야하는 값이 없는지 확인 //////////////////
    String[] mustCookies = {"COOKIE_ID", "COOKIE_PW", "COOKIE_HASH_PW", "AUTO_LOGIN"};
    Cookie[] cookies = request.getCookies();
    String[] cookiesName = Arrays.stream(request.getCookies()).map(c -> c.getName()).toArray(String[]::new);
    boolean isMustCookies = false;
    for (int i = 0; i < mustCookies.length; i++) {
        if (cookiesName != null) {
            for (int j = 0; j < cookiesName.length; j++) {
                if (mustCookies[i].equals(cookiesName[j])) {
                    isMustCookies = true;
                    break;
                }
            }
            if (!isMustCookies) {
                break;
            }
        }
    }

    // 하나라도 없으면 쿠키에 저장된 모든 요소 다 삭제
    if (!isMustCookies) {
        for (int i = 0; i < mustCookies.length; i++) {
            if (cookies != null) {
                for (int j = 0; j < cookies.length; j++) {
                    if (mustCookies[i].equals(cookies[j].getName())) {
                        cookies[j].setMaxAge(0);
                        cookies[j].setPath("/");
                        response.addCookie(cookies[j]);
                    }
                }
            }
        }
    }
%>

<%
    //////////////////////////// 자동 로그인 시도 ///////////////////////////
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName() != null) {
                if (cookie.getName().equals("AUTO_LOGIN")) {
                    String value = cookie.getValue();
                    if (value.equals("true")) {
%>
<script>
    location.href = "./DoAutoLoginServlet";
</script>
<%
                    }
                }
            }
        }
    }
%>



<%

    if (session.getAttribute("login") != null) {
        if (session.getAttribute("login") == Status.FAIL) {
%>
<script>alert("Login Fail!")</script>
<%

} else if (session.getAttribute("login") == Status.NULL) {

%>
<script>alert("Sign Up First.")</script>
<%
        }
        session.removeAttribute("login");
    }
%>

<%

    if (session.getAttribute("signup") != null) {

        if (session.getAttribute("signup") == Status.SUCCESS) {

%>
<script>alert("Sign Up Success!")</script>
<%
        }
        session.removeAttribute("signup");
    }
%>

<!-- -->


<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<html>
<head>
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

        <!--회원가입-->
        function goJoinForm() {
            location.href="JoinForm.jsp";
        }
    </script>

</head>
<body>
<div id="wrap">
    <form name="loginInfo" method="post" action="LoginSucceed.jsp"
          onsubmit="return checkValue()">

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
        <div class="checkbox_form">
            <label for="save">AUTO SAVE: </label>
            <input id="save" type="checkbox" name="save"/>
        </div>
        <input type="submit" value="로그인"/>
        <input type="button" value="회원가입" onclick="JoinForm()" />

    </form>

    <%
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

