<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Цикл for</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Цикл for</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/lab3.1_php/картинки-для-сайта/картинка1.png" width="200">
</p>

<?php
for ($i = 0; $i <= 10; $i++) {
    if ($i % 2 == 0) {
        echo $i . "<br>";
    }
}
?>

<br>
<p align="center">
    <a href="/ivan-rozumnyi/Лабораторна-робота-3.1/Web-сервером-і-клієнтом-сторінка.php">Web сервером і клієнтом сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.1</em>
</p>

</body>
</html>