<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Операційна система</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Операційна система</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>Операційна система</p>

<?php
$useragent = $_SERVER["HTTP_USER_AGENT"];
if (substr_count($useragent, "Windows NT 10.0"))
    echo "Ви використовуєте Windows 10";
elseif (substr_count($useragent, "Windows NT 6.1"))
    echo "Ви використовуєте Windows 7";
elseif (substr_count($useragent, "Linux"))
    echo "Ви використовуєте Linux";
elseif (substr_count($useragent, "Macintosh"))
    echo "Ви використовуєте MacOS";
else
    echo "ОС не визначена";
?>

<br>
<p align="center">
    <a href="/ivan-rozumnyi/Лабораторна-робота-3.3/Web-додатків-засобами-мови-PHP-сторінка.php">Web додатків засобами мови PHP сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.3</em>
</p>

</body>
</html>