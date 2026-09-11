<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Строкові функції No10</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Строкові функції No10</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка3.png" width="200">
</p>

<p>Слова та підрахувати кількість входжень</p>

<?php
$text = file_get_contents("text.txt");
$word = "PHP";
$count = substr_count(strtolower($text), strtolower($word));
if ($count > 0) {
    echo "Слово '$word' зустрічається $count разів.";
} else {
    echo "Слово '$word' не знайдено.";
}
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