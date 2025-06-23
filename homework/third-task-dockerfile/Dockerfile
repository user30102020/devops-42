FROM ubuntu:latest
MAINTAINER Bril M.S.

# Обновление пакетов и установка nginx и postgresql
RUN apt-get update && \
    apt-get install -y nginx postgresql && \
    apt-get clean

# Создание пользователя
RUN useradd -ms /bin/bash dockeruser

# Установка рабочей директории
WORKDIR /home/dockeruser/app

# Переменные окружения для postgres
ENV PGDATA=/var/lib/postgresql/data

# Добавление html-файла
ADD index.html /var/www/html/index.html

# Копирование sql-base в контейнер
COPY base.sql /docker-entrypoint-initdb.d/base.sql

# Настройка volume для postgres
VOLUME ["/var/lib/postgresql/data"]

# Открываем порты
EXPOSE 80 5437

# Переход под созданного пользователя
USER dockeruser

# Запуск сервисов nginx и postgres
CMD bash -c "sudo service postgresql start && sudo service nginx start && tail -f /dev/null"
