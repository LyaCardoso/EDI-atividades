## Algoritmo 360 
- Criar um algoritmo que imprima o horóscopo de várias pessoas, a partir de sua data de nascimento (ddmm). O fim é determinado quando se digita 9999 para data; considere que a data foi digitada corretamente.

TABELA
Mês Último dia Signo
01 20 Capricórnio
02 19 Aquário
03 20 Peixes
04 20 Áries
05 20 Touro
06 20 Gêmeos
07 21 Câncer
08 22 Leão
09 22 Virgem
10 22 Libra
11 21 Escorpião
1 12 121 Sagitário

prog vetor8
int ultdia [12 ] , data, i, dia, mes;
string signo[ 12 ]
para( i<- 0; i< 12; i++)
{ imprima "\ndigite signo:
leia signo[i];
imprima "\ndigite ultimo dia:
leia ultdia [ i 1
}
imprima "\ndigite data no formato ddmm ou 9999 para terminar:
leia data;
enquanto( data < > 9999)
{ dia <- data div 100;
mes <- data % 100;
mes--;
se( dia > ultdia [ mes ] )
{mes<- (mes+ 1) %12; }
imprima "\nsigno: ",signo[ mes ], "\n"
imprima "\ndigite data no formato ddmm ou 9999 para terminar: U;
leia data;
}
imprima "\n";
fimprog