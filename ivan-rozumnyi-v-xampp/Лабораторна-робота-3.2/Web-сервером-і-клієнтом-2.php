<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Web сервером і клієнтом No1</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Web сервером і клієнтом No1</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<?php
$m = 8;
$n = 12;
echo "До змін:<br>";
echo "m = $m <br>";
echo "n = $n <br><br>";
if ($m != $n)
{
    $max = max($m, $n);
    $m = $max;
    $n = $max;
}
else
{
    $m = 0;
    $n = 0;
}
echo "Після змін:<br>";
echo "m = $m <br>";
echo "n = $n <br>";
?>

<br>
<p align="center">
    <a href="/ivan-rozumnyi/Лабораторна-робота-3.2/Web-сервером-і-клієнтом-сторінка.php">Web сервером і клієнтом сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.2</em>
</p>

</body>
</html>