<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <link rel="stylesheet" type="text/css" href="/static/signs.css">
</head>
<body>

<#include "header.ftl">

<div class="container">
    <div class="container__main">
        <form class="form-content" method="post">
            <div class="form-heading">Регистрация</div>

            <#if error?? && error=='true'>
                <div class="error">Произошла ошибка. ${error}</div>
            </#if>

            <label>
                <input class="form-control" name="firstname" type="text" placeholder="Как Вас зовут?">
            </label>
            <label>
                <input class="form-control" name="email" type="email" placeholder="Email">
            </label>
            <label>
                <input class="form-control" name="password" type="password" placeholder="Пароль">
            </label>
            <input class="submit-btn" type="submit" value="Войти">
            <exp id="ex"><a href="/sign-up"><div class="button_text">Зарегестрироваться</div></a></exp>
        </form>
    </div>
</div>

</body>
</html>