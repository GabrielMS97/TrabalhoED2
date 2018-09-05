package Busca;

import Funcionamento.Gasto;

public class Hashing {

    public Gasto[] tHash(Gasto vetor[]) {
        Gasto tabelaHash[] = new Gasto[vetor.length]; // Cria a tabela hash
        for (int i = 0; i < vetor.length; i++) { // Preenche a tabela com objetos do tipo Gasto
            if (tabelaHash[i] == null) {
                tabelaHash[i] = new Gasto();
            }
        }

        for (int i = 0; i < vetor.length; i++) { // Para cada elemento do vetor, até o fim do vetor ser alcançado

            int posInicial = funcaoHash(vetor[i].getDeputy_id()); // Calcula qual a posição que o elemento deveria ocupar na tabela hash
            int j = 0; // variável de controle
            int colisao = 0; // Inicia o contador de colisões
            while (j == 0) {
                int pos = posInicial + colisao;
                if (pos + 1 > tabelaHash.length) { // Se não, se a posição estiver fora da tabela Hash
                    posInicial = 0;
                    colisao = 0;
                }
                else if (tabelaHash[pos].getDeputy_id() == null && pos <= tabelaHash.length) { // Se a posição que o elemento deve ocupar, acrescida do número de colisões estiver livre, e a mesma estiver dentro da tabela hash
                    tabelaHash[pos] = vetor[i]; // A tabela hash recebe o vetor na posição i, na posição que foi calculada
                    j = 1;
                } else {
                    colisao++;
                }
            }
        }
        return tabelaHash;
    }

    public int funcaoHash(int id) {
        int pos = id % 11;
        return pos;
    }
}
