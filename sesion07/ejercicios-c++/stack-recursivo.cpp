#include <iostream>
#include <stack>
using namespace std;
 
void factorial(int n) {
    stack<int> pila;
    int resultado = 1;
    for (int i = n; i > 1; i--) {
        pila.push(i);
    }
    while (!pila.empty()) {
        resultado *= pila.top();
        pila.pop();
    }
    cout << "Factorial: " << resultado << endl;
}
 
int main() {
    factorial(5); // Output: 120
    return 0;
}