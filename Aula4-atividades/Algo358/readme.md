## Algoritmo 358
- Criar um algoritmo que leia o preço de compra e o preço de venda de 100 mercadorias O algoritmo devera imprimir quantas mercadorias proporcionam

m lucro < 10 %
10 % <= lucro <= 20 %
m lucro > 20 %
prog vetor6
real precocompra[100] ,precovenda[100] ,lucro;
int totlucromenor10,totlucromenor20,totlucromaior20, A;
totiucromenorlø <- 0;
totlucromenor20 <- 0;
totlucromaior20 <- 0;
para(A <- 0; A <>100; A++)
{ imprima \nPreco de compra: ; leia precoconipra [A];
imprima "\nPreco de venda: "; leia precovenda [A];
}
para(A<-0;A < 100;A++)
{
lucro <- precovenda[A] - precocompra[A]
se(l ucro<10.0)
{totl ucromenorlø+i-; }
senao
{ se(lucro <= 20.0)
{ totlucronienor20++; }
senao
{ totlucromaior20++; }
}
}
imprima "\ntotal de mercadorias com lucro < 10%: ",totlucromenor10;
imprima "\ntotal de mercadorias com 10% <= lucro
11 ,totlucromenor20;
imprima "\ntotal de mercadorias com lucro > 20%: ",totlucromaior20;
imprima "\n";
fimprog