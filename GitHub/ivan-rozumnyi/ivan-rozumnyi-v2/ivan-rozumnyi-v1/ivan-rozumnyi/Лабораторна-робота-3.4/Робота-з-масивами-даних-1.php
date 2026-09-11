<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Робота з масивами даних No1</title>
</head>
<body bgcolor="#EEEEEE" text="black" link="blue">

<h1 align="center">Робота з масивами даних No1</h1>
<hr>

<!-- главная картинка -->
<p align="center">
    <img src="/ivan-rozumnyi/картинки-для-сайта/картинка1.png" width="200">
</p>

<?php
$users = array(
    "user1" => array(
        "ПІБ" => "Розумний Іван",
        "Вік" => 20,
        "Відвідування" => 15
    ),
    "user2" => array(
        "ПІБ" => "Петренко Андрій",
        "Вік" => 22,
        "Відвідування" => 35
    ),
    "user3" => array(
        "ПІБ" => "Сидоренко Сергій",
        "Вік" => 24,
        "Відвідування" => 25
    )
);
echo "<h3>Користувачі з кількістю відвідувань більше 10:</h3>";
foreach ($users as $user) {
    if ($user["Відвідування"] > 10) {
        echo "ПІБ: " . $user["ПІБ"] . "<br>";
        echo "Вік: " . $user["Вік"] . "<br>";
        echo "Відвідування: " . $user["Відвідування"] . "<br><br>";
    }
}
?>

<br>
<p align="center">
    <a href="/ivan-rozumnyi/Лабораторна-робота-3.4/Робота-з-масивами-даних-сторінка.php">Робота з масивами даних сторінку</a>
</p>

<p align="center">
    <em>Ця сторінка для лабораторної роботи 3.4</em>
</p>

</body>
</html>