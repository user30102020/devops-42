<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Записаться</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
<#include "header.ftl">


<div class="container">
    <div class="container__main">
        <div class="container__main_header">
            Добро пожаловать! Запишитесь на стрижку:
        </div>
        <form class="container__main_form" method="POST">
            <div class="form_block" id="office_changer">
                <label>Выберите услугу:
                    <select class="select-css" name="offices">
                        <#list offices as office>
                            <option value="${office.office_id}">${office.name}</option>
                        </#list>
                    </select>
                    <button type="button" onclick="addOfficeChanger()">Добавить услугу</button><br>
                </label>
            </div>
            <div class="form_block">
                <label>Выберите заведение:
                    <select class="select-css" name="workplace">
                        <#list workplaces as workplace>
                            <option value="${workplace.workplace_id}">${workplace.address}</option>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="form_block">
                <label>Выберите мастера:
                    <select class="select-css" name="barber_id">
                        <#list barbers as barber>
                            <option value="${barber.id}">${barber.name}</option>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="form_block">
                <label> Выберите дату:
                    <input class="select-css" type="date" name="date"/>
                </label>
            </div>
            <div class="form_block">
                <label> Выберите время:
                    <select class="select-css" name="time">
                        <option value="12">12:00</option>
                        <option value="13">13:00</option>
                        <option value="14">14:00</option>
                        <option value="15">15:00</option>
                        <option value="16">16:00</option>
                        <option value="17">17:00</option>
                        <option value="18">18:00</option>
                        <option value="19">19:00</option>
                        <option value="20">20:00</option>
                    </select>
                </label>
            </div>
            <div class="form_block">
                <input class="submit-btn" type="submit" value="Записаться">
            </div>
        </form>
    </div>
</div>

</body>
<script>
    function addOfficeChanger() {
        const container = document.getElementById('office_changer');
        const newOfficeChanger = document.createElement('div');
        newOfficeChanger.className = 'form_block';
        newOfficeChanger.innerHTML = `
                <select class="select-css" name="offices">
                    <#list offices as office>
                        <option value="${office.office_id}">${office.name}</option>
                    </#list>
                </select>
            `;
        container.appendChild(newOfficeChanger);
    }
</script>
</html>