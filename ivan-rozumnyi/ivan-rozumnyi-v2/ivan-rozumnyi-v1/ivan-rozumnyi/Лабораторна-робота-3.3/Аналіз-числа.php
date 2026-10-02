<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Аналіз числа</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Аналіз числа</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>Аналіз числа</p>

<form method="POST">
    Введіть число:
    <input type="text" name="num">
    <input type="submit" value="Перевірити">
</form>

<?php
if ($_POST) {
    $num = $_POST["num"];
    if (!is_numeric($num)) {
        echo "Введено не число!";
    } else {
        if ($num % 2 == 0)
            $par = "парне";
        else
            $par = "непарне";
        if ($num > 0)
            $sign = "додатне";
        elseif ($num < 0)
            $sign = "від’ємне";
        else
            $sign = "нуль";
        $digits = strlen(str_replace("-", "", $num));
        echo "Число $par, $sign, кількість розрядів: $digits";
    }
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