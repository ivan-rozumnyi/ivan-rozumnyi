<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Оператор switch</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Оператор switch</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/lab3.1_php/картинки-для-сайта/картинка1.png" width="200">
</p>

<?php
$day = 3;
switch ($day) {
    case 1:
        echo "Понеділок";
        break;
    case 2:
        echo "Вівторок";
        break;
    case 3:
        echo "Середа";
        break;
    default:
        echo "Невідомий день";
}
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