<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Строкові функції No3</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Строкові функції No3</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка3.png" width="200">
</p>

<p>Заданим словом поставити знак оклику</p>

<?php
$word = "PHP";
$text = file_get_contents("text.txt");
$sentences = preg_split('/(?<=[.!?])\s+/', $text);
foreach ($sentences as &$sentence) {
    if (stripos($sentence, $word) !== false) {
        $sentence = "! " . $sentence;
    }
}
echo implode(" ", $sentences);
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