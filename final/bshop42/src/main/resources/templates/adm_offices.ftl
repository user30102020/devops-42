<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Услуги</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <link rel="stylesheet" type="text/css" href="/static/offices.css">
    <link rel="stylesheet" type="text/css" href="/static/forms.css">
</head>
<body>
<#include "header.ftl">
<div class="container">
    <div class="container__main">
        <div class="container__main_header"> Добавить услугу </div>
        <form method="post">
            <input class="form-control" type="text" name="office_name" placeholder="Название">
            <input class="form-control" type="number" name="office_price" placeholder="Цена">
            <input class="form-control" type="text" name="office_description" placeholder="Описание">
            <input class="submit-btn" type="submit" value="Сохранить">
        </form>
    </div>
    <div class="container__main">
        <div class="container__main_header">Список услуг</div>
        <table>
            <thead>
            <tr>
                <th>Название</th>
                <th>Цена</th>
                <th>Описание</th>
                <th>Удалить услугу</th>
            </tr>
            </thead>
            <tbody>

            <#list offices as office>
                <tr>
                    <td>${office.name}</td>
                    <td>${office.price}</td>
                    <td>${office.description}</td>
                    <td>
                        <form action="/admin/offices/delete/${office.office_id}" method="POST">
                            <input type="hidden" name="office_id" value="${office.office_id}">
                            <input type="submit" class="delete-button" value="Удалить">
                        </form>
                    </td>
                </tr>
            </#list>

            </tbody>
        </table>
    </div>
</div>

</div>


</form>

</body>
</html>