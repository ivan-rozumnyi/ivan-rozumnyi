<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Строкові функції No1</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Строкові функції No1</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка3.png" width="200">
</p>

<p>Текст заданий символ</p>

<?php
$file = "text.txt";
$symbol = "а";
$text = file_get_contents($file);
$text = str_replace($symbol, "", $text);
file_put_contents($file, $text);
echo $text;
?>

<br>
<p align="center">
    <a href="/ivan-rozumnyi/Лабораторна-робота-3.5/Строкові-функції-сторінка.php">Web сервером і клієнтом сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.5</em>
</p>

</body>
</html>