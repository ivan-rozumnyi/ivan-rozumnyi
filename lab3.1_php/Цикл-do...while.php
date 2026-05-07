<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Цикл do...while</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Цикл do...while</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/lab3.1_php/картинки-для-сайта/картинка1.png" width="200">
</p>

<?php
$i = 12;
do {
    if ($i % 2 == 0) {
        echo $i;
    }
    $i++;
} while ($i < 10);
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