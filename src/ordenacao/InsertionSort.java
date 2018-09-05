package ordenacao;

import Funcionamento.Gasto;

public class InsertionSort {
    public Gasto[] ordena (Gasto vetor[])
    {
        Gasto vet[] = new Gasto[vetor.length];
        for (int i = 0; i < vetor.length; i++)
        {
            Gasto v = vetor[i];
            vet[i] = v;
        }
        long tempoInicial = System.currentTimeMillis();
        for (int i = 1; i < vet.length; i++)
        {
            Gasto aux = vet[i];
            int j = i;
            while((j>0) && (vet[j-1].getReceipt_value() > aux.getReceipt_value()))
            {
                vet[j] = vet[j-1];
                j--;
            }
            vet[j] = aux;
        }
        System.out.println("O InsertionSort executou em: " + (System.currentTimeMillis() - tempoInicial));
        return vet;
    }
}
