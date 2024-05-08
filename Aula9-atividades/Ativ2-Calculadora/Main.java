import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static double calcularInfixa(String expressao) {
        Stack<Double> operandos = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numero = new StringBuilder();
                while (i < expressao.length()
                        && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
                    numero.append(expressao.charAt(i));
                    i++;
                }
                operandos.push(Double.parseDouble(numero.toString()));
                i--;
            } else if (isOperator(c)) {
                while (!operadores.empty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    realizarOperacao(operandos, operadores.pop());
                }
                operadores.push(c);
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (operadores.peek() != '(') {
                    realizarOperacao(operandos, operadores.pop());
                }
                operadores.pop();
            }
        }

        while (!operadores.empty()) {
            realizarOperacao(operandos, operadores.pop());
        }

        return operandos.pop();
    }

    public static double calcularPosfixa(String expressao) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numero = new StringBuilder();
                while (i < expressao.length()
                        && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
                    numero.append(expressao.charAt(i));
                    i++;
                }
                stack.push(Double.parseDouble(numero.toString()));
                i--;
            } else if (isOperator(c)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static double calcularPrefixa(String expressao) {
        Stack<Double> stack = new Stack<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numero = new StringBuilder();
                while (i >= 0 && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
                    numero.insert(0, expressao.charAt(i));
                    i--;
                }
                stack.push(Double.parseDouble(numero.toString()));
                i++;
            } else if (isOperator(c)) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private static void realizarOperacao(Stack<Double> operandos, char operador) {
        double operand2 = operandos.pop();
        double operand1 = operandos.pop();
        switch (operador) {
            case '+':
                operandos.push(operand1 + operand2);
                break;
            case '-':
                operandos.push(operand1 - operand2);
                break;
            case '*':
                operandos.push(operand1 * operand2);
                break;
            case '/':
                operandos.push(operand1 / operand2);
                break;
        }
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static String infixaParaPosfixa(String expressao) {
        StringBuilder posfixa = new StringBuilder();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                posfixa.append(c);
            } else if (isOperator(c)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)
                        && operadores.peek() != '(') {
                    posfixa.append(operadores.pop());
                }
                operadores.push(c);
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    posfixa.append(operadores.pop());
                }
                if (!operadores.isEmpty() && operadores.peek() == '(') {
                    operadores.pop(); // Removendo o '('
                }
            }
        }

        while (!operadores.isEmpty()) {
            posfixa.append(operadores.pop());
        }

        return posfixa.toString();
    }

    public static String infixaParaPrefixa(String expressao) {
        StringBuilder prefixa = new StringBuilder();
        Stack<Character> operadores = new Stack<>();
        StringBuilder expressaoInvertida = new StringBuilder(expressao).reverse();

        for (int i = 0; i < expressaoInvertida.length(); i++) {
            char c = expressaoInvertida.charAt(i);
            if (Character.isDigit(c)) {
                prefixa.append(c);
            } else if (c == ')') {
                operadores.push(c);
            } else if (c == '(') {
                while (!operadores.isEmpty() && operadores.peek() != ')') {
                    prefixa.append(operadores.pop());
                }
                if (!operadores.isEmpty() && operadores.peek() == ')') {
                    operadores.pop(); // Removendo o ')'
                }
            } else if (isOperator(c)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) > precedencia(c)
                        && operadores.peek() != '(' && operadores.peek() != ')') {
                    prefixa.append(operadores.pop());
                }
                operadores.push(c);
            }
        }

        while (!operadores.isEmpty()) {
            prefixa.append(operadores.pop());
        }

        return prefixa.reverse().toString();
    }

    public static String posfixaParaInfixa(String expressao) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String novaExpressao = "(" + operand1 + c + operand2 + ")";
                stack.push(novaExpressao);
            }
        }

        return stack.pop();
    }

    public static String prefixaParaPosfixa(String expressao) {
        Stack<String> stack = new Stack<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char c = expressao.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String novaExpressao = operand1 + operand2 + c;
                stack.push(novaExpressao);
            }
        }

        return stack.pop();
    }

    public static String posfixaParaPrefixa(String expressao) {
        String infix = posfixaParaInfixa(expressao);
        return infixaParaPrefixa(infix);
    }

    public static String prefixaParaInfixa(String expressao) {
        String posfixa = prefixaParaPosfixa(expressao);
        return posfixaParaInfixa(posfixa);
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo à Calculadora!");
        System.out.println("Digite a expressão matemática:");
        String expressao = scanner.nextLine();

        System.out.println("Escolha a notação (infixa, posfixa, prefixa):");
        String notacao = scanner.nextLine();

        double resultado = 0;
        switch (notacao.toLowerCase()) {
            case "infixa":
                resultado = calcularInfixa(expressao);
                break;
            case "posfixa":
                resultado = calcularPosfixa(expressao);
                break;
            case "prefixa":
                resultado = calcularPrefixa(expressao);
                break;
            default:
                System.out.println("Notação inválida!");
                return;
        }

        System.out.println("Resultado: " + resultado);

        if (notacao.equalsIgnoreCase("infixa")) {
            String posfixa = infixaParaPosfixa(expressao);
            System.out.println("Expressão Posfixada: " + posfixa);
            String prefixa = infixaParaPrefixa(expressao);
            System.out.println("Expressão Prefixada: " + prefixa);
        } else if (notacao.equalsIgnoreCase("posfixa")) {
            String infix = posfixaParaInfixa(expressao);
            System.out.println("Expressão Infixada: " + infix);
            String prefixa = posfixaParaPrefixa(expressao);
            System.out.println("Expressão Prefixada: " + prefixa);
        } else if (notacao.equalsIgnoreCase("prefixa")) {
            String infix = prefixaParaInfixa(expressao);
            System.out.println("Expressão Infixada: " + infix);
            String posfixa = prefixaParaPosfixa(expressao);
            System.out.println("Expressão Posfixada: " + posfixa);
        }
    }
}