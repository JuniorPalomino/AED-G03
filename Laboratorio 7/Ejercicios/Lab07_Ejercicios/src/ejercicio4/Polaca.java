package ejercicio4;

import actividad1.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Polaca {

    private final Stack<Character> pila = new StackArray<>(100);
    private final Map<Character, Integer> prioridades = new HashMap<>();

    public Polaca() {
        prioridades.put('(', 0);
        prioridades.put(')', 0);
        prioridades.put('+', 1);
        prioridades.put('-', 1);
        prioridades.put('*', 2);
        prioridades.put('/', 2);
        prioridades.put('S', 3);
    }

    public String readFile(String ruta) {
        String resultado = "";
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = buffer.readLine()) != null) {
                resultado += calcularExpresion(linea) + "\n";
            }
            buffer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public String calcularExpresion(String infija) throws ExceptionIsEmpty {
        String postfija = inToPos(infija);
        return Integer.toString(resultExpresion(postfija));
    }

    public String inToPos(String infija) throws ExceptionIsEmpty {
        String postfija = "";
        char[] caracteres = infija.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            if (Character.isDigit(c)) {
                postfija += c;
            } else if (esOperador(c)) {
                while (!pila.isEmpty() && prioridades.get(pila.top()) >= prioridades.get(c)) {
                    postfija += pila.pop();
                }
                pila.push(c);
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (pila.top() != '(') {
                    postfija += pila.pop();
                }
                pila.pop();
            }
        }
        while (!pila.isEmpty()) {
            postfija += pila.pop();
        }
        return postfija;
    }

    public boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == 'S';
    }

    public int resultExpresion(String postfija) throws ExceptionIsEmpty {
        char[] caracteres = postfija.toCharArray();
        Stack<Integer> pilaNumeros = new StackArray<>(100);
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            if (Character.isDigit(c)) {
                pilaNumeros.push(Character.getNumericValue(c));
            } else {
                int b = pilaNumeros.pop();
                int a = pilaNumeros.pop();
                switch (c) {
                    case '+':
                        pilaNumeros.push(a + b);
                        break;
                    case '-':
                        pilaNumeros.push(a - b);
                        break;
                    case '*':
                        pilaNumeros.push(a * b);
                        break;
                    case '/':
                        pilaNumeros.push(a / b);
                        break;
                    case 'S':
                        pilaNumeros.push((int) Math.pow(a, b));
                        break;
                }
            }
        }
        return pilaNumeros.pop();
    }

}
