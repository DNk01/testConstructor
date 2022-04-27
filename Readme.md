Для того, чтобы запустить проект локально, нужно скачать Docker, затем в командной строке написать:
docker run --name main -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=testConstructor -d postgres:13.3
(Если порт 5432 занят, можно написать 5433:5432)
После чего, нужно подключиться к БД, сделать это можно в графе Database (находится в правой части Idea)
Затем нажать на "+" -> Выбрать "Postgresql" ->
Host - "localhost", Port - 5432, User - root, Password - 123456.
-> Test connection.
Если подключение успешно, вы подключиться к БД, и проект будет запускаться локально.