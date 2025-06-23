<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Услуги</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <link rel="stylesheet" type="text/css" href="/static/offices.css">
</head>
<body>
<#include "header.ftl">
<div class="container">
    <div class="container__main">
        <div class="container__main_header">
            Наши мастера
        </div>
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Опыт работы</th>
                <th>Место работы</th>
            </tr>
            </thead>
            <tbody>
            <#list barbers as barber>
                <tr>
                    <th>${barber.name}</th>
                    <th>${barber.experience} лет</th>
                    <th>${barber.workplace.address}</th>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
</html>