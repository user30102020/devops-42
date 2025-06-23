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
            Наши услуги
        </div>
        <table>
            <thead>
            <tr>
                <th>Название</th>
                <th>Цена</th>
                <th>Описание</th>
            </tr>
            </thead>
            <tbody>
            <#list offices as office>
                <tr>
                    <th>${office.name}</th>
                    <th>${office.price}</th>
                    <th>${office.description}</th>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
</html>