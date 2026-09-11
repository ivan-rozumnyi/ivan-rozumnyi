<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>По зростанню</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">По зростанню</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<p>По зростанню</p>

<form method="POST">
<?php
for ($i = 0; $i < 5; $i++) {
    echo "<input type='text' name='numbers[]'><br>";
}
?>
<br>
<input type="submit" value="Сортувати">
</form>

<?php
if ($_POST) {
    $arr = $_POST["numbers"];
    sort($arr);
    echo "<br>Результат:<br>";
    foreach ($arr as $value) {
        echo $value . " ";
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