package ordenacao;

import Funcionamento.Gasto;

public class BubbleSort {
    public Gasto[] ordena (Gasto vetor[])
    {
        Gasto vet[] = new Gasto[vetor.length];
        for (int i = 0; i < vetor.length; i++)
        {
            Gasto v = vetor[i];
            vet[i] = v;
        }
        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < vet.length; i++)
        {
            for (int j = 0; j < vet.length-1; j++)
            {
                if (vet[j].getReceipt_value() > vet[j+1].getReceipt_value())
                {
                    Gasto aux = vet[j+1];
                    vet[j+1] = vet[j];
                    vet[j] = aux;
                }
            }
        }
        System.out.println("O BubbleSort executou em: " + (System.currentTimeMillis() - tempoInicial));
        return vet;
    }
}
