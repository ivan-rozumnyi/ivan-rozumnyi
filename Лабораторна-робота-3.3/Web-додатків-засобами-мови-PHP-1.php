<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Web додатків засобами мови PHP No1</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Web додатків засобами мови PHP No1</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<form method="POST">
    Число 1:
    <input type="text" name="a"><br><br>
    Число 2:
    <input type="text" name="b"><br><br>
    Операція:
    <select name="op">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br><br>
    <input type="submit" value="Обчислити">
</form>

<?php
if ($_POST) {
    $a = $_POST["a"];
    $b = $_POST["b"];
    $op = $_POST["op"];
    switch ($op) {
        case "+":
            echo "Результат: " . ($a + $b);
            break;
        case "-":
            echo "Результат: " . ($a - $b);
            break;
        case "*":
            echo "Результат: " . ($a * $b);
            break;
        case "/":
            if ($b == 0)
                echo "Ділення на нуль неможливе!";
            else
                echo "Результат: " . ($a / $b);
            break;
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