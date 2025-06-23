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
        <div class="container__main_header"> Добавить работника </div>
        <form method="post">
            <input class="form-control" type="text" name="barber_name" placeholder="Имя">
            <input class="form-control" type="number" name="barber_experience" placeholder="Опыт работы">
            <select class="select-css" name="workplace_id">
                <#list workplaces as workplace>
                    <option value="${workplace.workplace_id}">${workplace.address}</option>
                </#list>
            </select>
            <input class="submit-btn" type="submit" value="Сохранить">
        </form>
    </div>
    <div class="container__main">
        <div class="container__main_header">Список работников</div>
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Опыт работы</th>
                <th>Место работы</th>
                <th>Удалить работника</th>
            </tr>
            </thead>
            <tbody>

            <#list barbers as barber>
                <tr>
                    <td>${barber.name}</td>
                    <td>${barber.experience}</td>
                    <td>${barber.workplace.address}</td>
                    <td>
                        <form action="/admin/barbers/delete/${barber.id}" method="POST">
                            <input type="hidden" name="barber_id" value="${barber.id}">
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