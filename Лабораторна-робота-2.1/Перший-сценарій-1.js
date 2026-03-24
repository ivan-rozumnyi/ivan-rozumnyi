// 
function print(text) {
    document.getElementById("output").innerHTML += text + "<br>";
}

// пример площа круга

var R = 5;
var S_circle = Math.PI * R * R;

print("<h3>Площа круга</h3>");
print("Радіус = " + R);
print("Площа = " + S_circle.toFixed(2));


// пример площа трапеції
var a = 6;
var b = 10;
var h = 4;

var S_trap = (a + b) / 2 * h;

print("<h3>Площа трапеції</h3>");
print("a = " + a + ", b = " + b + ", h = " + h);
print("Площа = " + S_trap);


// пример правильний n-кутник
var n = 6;
var R2 = 5;

var side = 2 * R2 * Math.tan(Math.PI / n);
var P = n * side;
var S_polygon = (P * R2) / 2;

print("<h3>Правильний n-кутник</h3>");
print("n = " + n + ", R = " + R2);
print("Сторона = " + side.toFixed(2));
print("Периметр = " + P.toFixed(2));
print("Площа = " + S_polygon.toFixed(2));


// пример обчислення виразу
var x = 2;

var y = (8 * x * x + 12) / (7 * x * x + 10);

print("<h3>Обчислення виразу</h3>");
print("x = " + x);
print("Результат = " + y.toFixed(4));