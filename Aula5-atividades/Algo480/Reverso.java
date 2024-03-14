public class Reverso {
    public int reverso(int num) {
        int soma, r;
        soma = 0;
        while(num != 0) {
            r = num % 10;
            soma = soma * 10 + r;
            num = num / 10;
        }
        return soma;
    }
}