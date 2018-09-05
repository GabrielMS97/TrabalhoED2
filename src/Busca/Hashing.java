package Busca;

import Funcionamento.Gasto;

public class Hashing {

    public Gasto[] tHash(Gasto vetor[]) {
        Gasto tabelaHash[] = new Gasto[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            if (tabelaHash[i] == null) {
                tabelaHash[i] = new Gasto();
            }
        }
        int pos = funcaoHash(vetor[i].getDeputy_id());

        int j = 0;
        int colisao = 0;
        while (j == 0) {
            if (tabelaHash[pos + colisao] == null && pos + colisao <= tabelaHash.length) {
                tabelaHash[pos + colisao] = vetor[i];
                colisao = 0;
                j = 1;
            } else {
                if (pos + 1 > tabelaHash.length) {
                    pos = 0;
                    colisao = 0;
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
