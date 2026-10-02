<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Визначення мови</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Визначення мови</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>Визначення мови</p>

<?php
$lang = $_SERVER["HTTP_ACCEPT_LANGUAGE"];
if (substr_count($lang, "ua")) {
    echo "Ви використовуєте українську мову!<br>";
} else {
    echo "You use another language!<br>";
}
if (@$_SERVER["HTTP_REFERER"]) {
    $ref = $_SERVER["HTTP_REFERER"];
    echo "<a href='$ref'>Попередня сторінка</a>";
} else {
    echo "Попередня сторінка відсутня";
}
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