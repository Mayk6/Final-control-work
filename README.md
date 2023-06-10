# Итоговая контрольная работа

## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

## Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

![Task1](https://github.com/Mayk6/Final-control-work/assets/110410764/8ce05c45-4d49-4929-8775-deb5048d9578)


2. Создать директорию, переместить файл туда.

![Task2](https://github.com/Mayk6/Final-control-work/assets/110410764/16462136-4413-4dd2-8ca4-49661b7e5e63)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

![Task3](https://github.com/Mayk6/Final-control-work/assets/110410764/a35c0110-1aed-4e8d-9070-218395620de5)

4. Установить и удалить deb-пакет с помощью dpkg.

![Task4](https://github.com/Mayk6/Final-control-work/assets/110410764/1bcb7631-5316-47b1-b754-77e7d2656ef7)

5. Выложить историю команд в терминале ubuntu



6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

![Screenshot 2023-06-07 192406](https://github.com/Mayk6/Final-control-work/assets/110410764/1ebaa8c8-f2b8-471b-b36b-be48b776dbe5)

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
```sql
CREATE DATABASE mans_friends;
```

8. Создать таблицы с иерархией из диаграммы в БД
```sql
USE Human_friends;
CREATE TABLE animal
(
	id INT AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(30)
);

INSERT INTO animal (name)
VALUES ('вьючные'),
('домашние');  


CREATE TABLE pack_animals
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (20),
    id INT,
    FOREIGN KEY (id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (name, id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 
    
CREATE TABLE home_animals
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (20),
    id INT,
    FOREIGN KEY (id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (name, id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

CREATE TABLE cats 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(150),
    type_id int,
    Foreign KEY (type_id) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
```
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
```sql
INSERT INTO cats (Name, Birthday, Commands, type_id)
VALUES ('Стивен', '2019-03-18', 'кушать', 1),
('Мурзик', '2010-07-15', 'танцуй', 1),  
('Кеша', '2018-10-03', 'мяукай', 1); 

CREATE TABLE dogs 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(150),
    type_id int,
    Foreign KEY (type_id) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, type_id)
VALUES ('Глыба', '2010-05-09', 'ко мне, лапу', 2),
('Гульфик', '2019-12-12', 'сидеть, голос', 2),  
('Свобода', '2015-10-10', 'лежать, место', 2);

CREATE TABLE hamsters 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(150),
    type_id int,
    Foreign KEY (type_id) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, type_id)
VALUES ('Пушистый', '2021-07-14', 'пить', 3),
('Боец', '2022-02-15', 'жди', 3);

CREATE TABLE horses 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(50),
    type_id int,
    Foreign KEY (type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, type_id)
VALUES ('Пуля', '2018-11-21', 'рысь, тише', 1),
('Феррари', '2014-07-19', "рысь, хоп, тише, шагом", 1),  
('Пупа', '2021-02-13', "стой, вперед, хоп", 1);

CREATE TABLE donkeys 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(150),
    type_id int,
    Foreign KEY (type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, type_id)
VALUES ('Ушастый', '2019-02-19', 'хоп, стой', 2),
('Бодрый', '2012-12-12', 'хоп, стой', 2);

CREATE TABLE camels 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(30), 
    Birthday DATE,
    Commands VARCHAR(150),
    type_id int,
    Foreign KEY (type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, type_id)
VALUES ('Верблюд1', '2016-03-12', 'команда1', 3),
('Верблюд2', '2019-02-16', "команда3", 3);
```

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
```sql
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
```sql
CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Собаки' AS genus FROM dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;
```
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
```sql
SELECT h.Name, h.Birthday, h.Commands, pa.name, ya.Age_in_month 
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN pack_animals pa ON pa.id = h.type_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN pack_animals pa ON pa.id = d.type_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.name, ya.Age_in_month 
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.id = c.type_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.name, ya.Age_in_month 
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.id = d.type_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.name, ya.Age_in_month 
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.id = hm.type_id;
```
[Решение задач указанных ниже](https://github.com/Mayk6/Final-control-work/tree/main/pet-registry)
13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆ int переменной̆ на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.
