<!doctype html>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/res/style.css">
</head>

<body>
<div>
    <form action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="sign in">
    </form>
</div>

</body>