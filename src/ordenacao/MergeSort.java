package ordenacao;

import Funcionamento.Gasto;

public class MergeSort {
    public Gasto[] ordena (Gasto vetor[])
    {
        Gasto vet[] = new Gasto[vetor.length];
        for (int i = 0; i < vetor.length; i++)
        {
            Gasto v = vetor[i];
            vet[i] = v;
        }
        long tempoInicial = System.currentTimeMillis();
        mergeSort(vet, 0, vet.length-1);
        System.out.println("O MergeSort executou em: " + (System.currentTimeMillis() - tempoInicial));
        return vet;
    }
    
    public void mergeSort (Gasto vetor[], int inicio, int fim)
    {
        if (inicio < fim)
        {
            int meio = ((inicio+fim)/2);
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio+1, fim);
            merge(vetor, inicio, meio, fim);
        }
        else
        {
            return;
        }
    }
    
    public void merge (Gasto vetor[], int inicio, int meio, int fim)
    {
        Gasto auxiliar[] = new Gasto[vetor.length]; 
        for (int i = inicio; i <= fim; i++)
        {
            auxiliar[i] = vetor[i];
        }
        
        int i = inicio;
        int j = meio+1;
        int k = inicio;
        
        while(i <= meio && j <= fim)
        {
            if (auxiliar[i].getReceipt_value() < auxiliar[j].getReceipt_value())
            {
                vetor[k] = auxiliar[i];
                i++;
            }
            else
            {
                vetor[k] = auxiliar[j];
                j++;
            }
            k++;
        }
        
        while (i <= meio)
        {
            vetor[k] = auxiliar[i];
            i++;
            k++;
        }
        
        while (j <= fim)
        {
            vetor[k] = auxiliar[j];
            j++;
            k++;
        }
    }
}
