<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Пример No2</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Пример No2</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/lab3.1_php/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>Обчислення суми, різниці, добутку і частки</p>

<p>
    <img src="/lab3.1_php/картинки-для-лаби-3.1/2.png" alt="2.png">
</p>

<?php
$x = 10;
$y = 5;
echo "Сума = " . ($x + $y) . "<br>";
echo "Різниця = " . ($x - $y) . "<br>";
echo "Добуток = " . ($x * $y) . "<br>";
echo "Частка = " . ($x / $y);
?>

<br>
<p align="center">
    <a href="/lab3.1_php/Web-сервером-і-клієнтом-сторінка.php">Web сервером і клієнтом сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.1</em>
</p>

</body>
</html>