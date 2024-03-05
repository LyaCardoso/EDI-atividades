## Algoritmo 351
- Criar um algoritmo que armazene cinco nomes em um vetor e depois possa ser digitado um número que corresponde a uma pessoa e imprimir esse nome.

prog procuranomepelonumero
int L. num
string nomes [5];
para( L<- O; L <= 4 ; L++)
{ imprima "\nnome " , L + 1 9": "; leia
nomes[L] ;}
#entra com numero para procurar pela
posi cao
imprima "\nDigite o numero da pessoa: II;
leia num;
enquanto(num < 1 II num > 5)
{
imprima " \n Numero fora do intervalo";
imprima " \n Digite o numero da pessoa:
leia num;
}
imprima,."\n", nomes[ num -1]
imprima " \n " ;
fimprog

Exemplo de Saída
nome 1: ANITA
nome 2: GUTO
nome 3: JOAO
nome 4: PEDRO
nome 5: FILIPE
Digite o numero da pessoa: 3
JOAO