# Sesión 7: Pilas (Stacks) en C++

## 📖 Introducción

Las **pilas (stacks)** son una estructura de datos fundamental en la informática. Siguen el principio **LIFO (Last In, First Out)**, lo que significa que el último elemento agregado es el primero en ser retirado. Su uso es común en sistemas que requieren un control de orden inverso en las operaciones, como el manejo de memoria en llamadas recursivas, la validación de expresiones matemáticas y el control de navegación en aplicaciones web.

## 🔎 Conceptos y Fundamentos

### 1️ ¿Qué es una Pila?

Una pila es una estructura de datos **lineal** que permite insertar y eliminar elementos solo por un extremo, llamado **tope (top)**. Existen dos operaciones fundamentales:

- **Push**: Insertar un elemento en la pila.
- **Pop**: Retirar el elemento en el tope de la pila.

### 2️ Características Principales

- **LIFO**: El último en entrar es el primero en salir.
- **Acceso restringido**: Solo se puede acceder al último elemento.
- **Eficiencia**: Las operaciones push y pop son O(1), lo que significa que son extremadamente rápidas.

### 3️ Aplicaciones de Pilas en la Vida Real

1. **Gestión de memoria en programación**: En los lenguajes de programación, la pila se usa para manejar las llamadas a funciones y la recursión.
2. **Navegación en páginas web**: Cuando navegamos por páginas web, el historial de navegación usa una pila para gestionar el botón "Atrás".
3. **Validación de expresiones matemáticas**: Se usan pilas para evaluar expresiones con paréntesis y operadores matemáticos.
4. **Compiladores y análisis de sintaxis**: Los compiladores usan pilas para analizar estructuras de código como llaves {} y paréntesis ().
5. **Deshacer y rehacer en editores de texto**: Los programas de edición como Microsoft Word o Photoshop almacenan las acciones en una pila para permitir la funcionalidad de "deshacer".

## Ejercicio 1: Gestión de Navegación en un Navegador Web

**Historia de Usuario**

- **Como** usuario de un navegador web.
- **Quiero** poder regresar a páginas anteriores y avanzar a páginas siguientes.
- **Para** navegar de manera eficiente sin perder el historial de navegación.

**Código Fuente en C++**
```cpp
# include &lt;iostream&gt;
# include &lt;stack&gt;

using namespace std;

int main() {
stack&lt;string&gt; historial;
historial.push("www.google.com");
historial.push("www.github.com");
historial.push("www.stackoverflow.com");
cout << "Página actual: " << historial.top() << endl;
historial.pop();
cout << "Retrocediendo... Ahora en: " << historial.top() << endl;
return 0;
}
```
## Ejercicio 2: Validación de Expresiones Matemáticas

**Historia de Usuario**

- **Como** desarrollador de un compilador matemático.
- **Quiero** verificar que las expresiones con paréntesis sean correctas.
- **Para** evitar errores de sintaxis en los cálculos.

**Código Fuente en C++**
```cpp
# include &lt;iostream&gt;
# include &lt;stack&gt;

using namespace std;

bool validarExpresion(string expr) {
stack&lt;char&gt; pila;
for (char c : expr) {
if (c == '(') {
pila.push(c);
} else if (c == ')') {
if (pila.empty()) return false;
pila.pop();
}
}
return pila.empty();
}

int main() {
string expresion = "(5+3)\*(2+(4-1))";
if (validarExpresion(expresion))
cout << "Expresión válida." << endl;
else
cout << "Expresión inválida." << endl;
return 0;
}
```
## Ejercicio 3: Sistema de Deshacer/Rehacer en un Editor de Texto

**Historia de Usuario**

- **Como** usuario de un editor de texto.
- **Quiero** poder deshacer y rehacer acciones.
- **Para** corregir errores sin perder información importante.

**Código Fuente en C++**
```cpp
# include &lt;iostream&gt;
# include &lt;stack&gt;

using namespace std;

int main() {
stack&lt;string&gt; acciones;
acciones.push("Escribir 'Hola'");
acciones.push("Agregar negrita");
acciones.push("Insertar imagen");
cout << "Última acción: " << acciones.top() << endl;
acciones.pop();
cout << "Deshacer... Ahora la última acción es: " << acciones.top() << endl;
return 0;
}
```
## Ejercicio 4: Evaluación de Expresiones Postfijas

**Historia de Usuario**

- **Como** ingeniero de software.
- **Quiero** evaluar expresiones matemáticas en notación postfija.
- **Para** implementar un calculador eficiente.

**Código Fuente en C++**
```cpp
# include &lt;iostream&gt;
# include &lt;stack&gt;

using namespace std;

int evaluarPostfija(string expr) {
stack&lt;int&gt; pila;
for (char c : expr) {
if (isdigit(c)) {
pila.push(c - '0');
} else {
int b = pila.top(); pila.pop();
int a = pila.top(); pila.pop();
if (c == '+') pila.push(a + b);
else if (c == '-') pila.push(a - b);
else if (c == '\*') pila.push(a \* b);
else if (c == '/') pila.push(a / b);
}
}
return pila.top();
}

int main() {
cout << evaluarPostfija("23+5\*") << endl; // Output: 25
return 0;
}
```
## Ejercicio 5: Control de Llamadas Recursivas

**Historia de Usuario**

- **Como** programador de un motor de juegos.
- **Quiero** gestionar llamadas recursivas en la pila de ejecución.
- **Para** evitar desbordamientos de memoria y optimizar rendimiento.

**Código Fuente en C++**
```cpp
# include &lt;iostream&gt;
# include &lt;stack&gt;

using namespace std;

void factorial(int n) {
stack&lt;int&gt; pila;
int resultado = 1;
for (int i = n; i > 1; i--) {
pila.push(i);
}

while (!pila.empty()) {
resultado \*= pila.top();
pila.pop();
}
cout << "Factorial: " << resultado << endl;
}

int main() {
factorial(5); // Output: 120
return 0;
}
```
**Conclusión**

Las pilas son estructuras esenciales en la programación. Se utilizan en múltiples aplicaciones, como navegadores, compiladores y sistemas de control de procesos. Su eficiencia y simplicidad las hacen ideales para escenarios que requieren acceso **LIFO**.