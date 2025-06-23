<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Все записи</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <link rel="stylesheet" type="text/css" href="/static/registrations.css">
</head>
<body>
<#include "header.ftl">
<div class="container">
    <div class="container__main">
        <div class="container__main_header">
            Записи пользователей
        </div>
        <table>
            <thead>
            <tr>
                <th>Услуги</th>
                <th>Дата</th>
                <th>Время</th>
                <th>Мастер</th>
                <th>Адрес</th>
                <th>Отменить запись</th>
            </tr>
            </thead>
            <tbody>
            <#list activeRegs as reg>
                <tr class="regs__active">
                    <td>
                        <#list reg.offices as office>
                            <div>${office.name}</div>
                        </#list>
                    </td>
                    <td>${reg.date}</td>
                    <td>${reg.time}:00</td>
                    <td>${reg.barber.name}</td>
                    <td>${reg.barber.workplace.address}</td>
                    <td>
                        <form action="/registrations/cancel/${reg.registration_id}" method="POST">
                            <input type="hidden" name="registration_id" value="${reg.registration_id}">
                            <input type="submit" class="delete-button" value="Отменить">
                        </form>
                    </td>
                </tr>
            </#list>
            <#list expiredRegs as reg>
                <#list reg.offices as office>
                    <div>${office.name}</div>
                </#list>
                <td>${reg.date}</td>
                <td>${reg.time}:00</td>
                <td>${reg.barber.name}</td>
                <td>${reg.barber.workplace.address}</td>
            </#list>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>