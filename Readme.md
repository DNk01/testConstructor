Для того, чтобы запустить проект локально, нужно скачать Docker, затем в командной строке написать:
docker run -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=training -p 3306:3306 -d  mysql:5.7
(Если порт 3306 занят, можно написать 3307:3306)
После чего, нужно подключиться к БД, сделать это можно в графе Database (находится в правой части Idea)
Затем нажать на "+" -> Выбрать "MySql" ->
Host - "localhost", Port - 3306, User - root, Password - 123456.
-> Test connection.
Если подключение успешно, вы подключиться к БД, и проект будет запускаться локально.