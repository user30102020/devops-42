<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Админ</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <link rel="stylesheet" type="text/css" href="/static/adm_panel.css">
</head>
<body>
<#include "header.ftl">
<div class="container">
    <div class="container__main">
        <div class="container__main_header">
            Панель администратора. Управление:
        </div>
        <div class="admin__options">
            <a href="/admin/registrations">Записями пользователей</a>
            <a href="/admin/offices">Услугами</a>
            <a href="/admin/barbers">Работниками</a>
        </div>
    </div>
</div>
</body>
</html>