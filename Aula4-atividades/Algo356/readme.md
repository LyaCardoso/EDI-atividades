## Algoritmo 356
- Armazenar nomes e notas das PR 1 e PR2 de 15 alunos. Calcular e armazenar a média arredondada. Armazenar também a situação do aluno: AP ou RP. Imprimir uma listagem contendo nome notas media e situação de cada aluno tabulando

prog vetor4
int L ,c ,t, media[15];
string nomes[ 15] sit[15];
real pr1[15], pr2[15];
#trecho de entrada de 15 nomes
para( L<- O; L <= 14 ; L++)
{
imprima "\n\nDigite ", L + 1, " nome:
leia nomes[ L ]
enquanto( strtam(nomes[L]) >30)
{ imprima ° \nNomes com ate 30 caracteres"; 279

imprima "\n\nDigite ", L + 1 9" nome:
leia nomes[ L ]
}
#trecho que garante todos os nomes com 30 caracteres para fazer tabulacao
t<-30-strtam (nomes [L]);
para(c<-1; c <= t; c++)
{nomes[L]<-strconcat(nomes[L]. I'
imprima "\ndigite 1 nota:
leia prl[L];
imprima "\ndigite 2 nota:
leia pr2[L];
media[L] <- realint((prl[L] +pr2[L])12+0.0001);
se(media[ L ] >= 5 )
{ sit[ L ] <- "AP"; }
senao
{ sit[ L ] <- "RP"; }
}
#fim do trecho de entrada
#trecho de saida
imprima "\n\n\n\t\t\t\tRELACAO FINAL\n";
para( L<- 0; L <= 14 ; L++)
{ imprima " \n " , L+1, "- ",nomes [L] ,"\t",prl[L] , "\t", pr 2 [L]
"\t",niedia[L], "\t",sit[L]; }
#fim do trecho de saida
imprima "\n";
fimprog