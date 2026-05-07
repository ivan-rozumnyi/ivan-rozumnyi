<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Пример</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Пример</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/lab3.1_php/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>Обчислення відстані між двома точками</p>

<p>
    <img src="/lab3.1_php/картинки-для-лаби-3.1/1.png" alt="1.png">
</p>

<?php
$x1 = 2;
$y1 = 3;
$x2 = 7;
$y2 = 8;
$d = sqrt(pow($x2 - $x1, 2) + pow($y2 - $y1, 2));
echo "Відстань = " . $d;
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