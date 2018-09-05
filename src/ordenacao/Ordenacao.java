package ordenacao;

import Busca.Hashing;
import Funcionamento.Gasto;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.log;
import static java.rmi.server.LogStream.log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ordenacao {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long tempoInicial;
         /*awk -F\" '{OFS="\"";for(i=2;i<NF;i+=2)gsub(/,/,"@",$i);print}' deputies_dataset.csv > t1
          // sed 's/,/;/g' /ice/Downloads/t1 > /ice/Downloads/t2
          // sed 's/\@/,/g' /ice/Downloads/t2 > /ice/Downloads/t3.
        */
        //String shellCommand = "awk -F\\\" '{OFS=\"\\\"\";for(i=2;i<NF;i+=2)gsub(/,/,\"@\",$i);print}' /ice/Downloads/deputies_dataset.csv > /ice/Downloads/t1.csv";
        /*String shellCommand = "sed 's/,/;/g' /ice/Downloads/t1.csv > /ice/Downloads/t2.csv";
        String shellCommand = "sed 's/\\@/,/g' /ice/Downloads/t2.csv > /ice/Downloads/t3.csv";
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(shellCommand);
        //commands.add(shellCommand2);
        //commands.add(shellCommand3);
        try {
            ProcessBuilder p = new ProcessBuilder(commands);
            Process process = p.start();
        } catch (IOException ioe) {
            System.err.println("Erro ao executar comando shell" + ioe.getMessage());
            throw ioe;
        }*/
       
        /*BubbleSort b = new BubbleSort();
        MergeSort m = new MergeSort();
        Random gerador = new Random();
        int vetor[];
        int tam = gerador.nextInt(100000);
        System.out.println(tam);
        vetor = new int[tam];
        for (int i = 0; i < tam; i++) {
            vetor[i] = gerador.nextInt();
            //  System.out.println(vetor[i]);
        }
        int vetorSaida3[] = m.ordena(vetor);
        int vetorSaida1[] = b.ordena(vetor);   */
        
        Integer tam = 1000;
        String diretorioArquivo = "/ice/Downloads/deputies_dataset_tratado.csv";
        BufferedReader leitor = null;
        String delimitador = ";";
        tempoInicial = System.currentTimeMillis();
        Gasto gastos [] = new Gasto[tam];
        int contador = 0;
        try {
            String linhaDeLeitura = "";
            leitor = new BufferedReader(new FileReader(diretorioArquivo));
            linhaDeLeitura = leitor.readLine();
            while ((linhaDeLeitura = leitor.readLine() ) != null && contador < tam) {
                String[] gasto = linhaDeLeitura.split(delimitador);
                Integer deputadoId = Integer.parseInt(gasto[2]);
                Integer valor;
                valor = Integer.parseInt(gasto[9]);
                gastos[contador] = new Gasto(gasto[0], gasto[1], deputadoId, gasto[3], gasto[4], gasto[5], gasto[6], gasto[7], gasto[8], valor);
                contador++;
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("O BufferedReader executou em: " + (System.currentTimeMillis() - tempoInicial));
        System.out.println("O contador parou em: " + contador);
        System.out.println(gastos.length);
        /*QuickSort q = new QuickSort();
        Gasto vetorSaida[] = q.ordena(gastos);
        for (int i = 0; i < tam; i++){
            System.out.println(vetorSaida[i].getDeputy_name() + " " +  vetorSaida[i].getReceipt_value());
        }
        MergeSort m = new MergeSort();
        Gasto vetorSaida3[] = m.ordena(gastos);
        for (int i = 0; i < tam; i++) {
            System.out.println(vetorSaida3[i].getDeputy_name() + " " +  vetorSaida3[i].getReceipt_value());
        }
        InsertionSort in = new InsertionSort();
        Gasto vetorSaida2[] = in.ordena(gastos);
        for (int i = 0; i < tam; i++) {
            System.out.println(vetorSaida2[i].getDeputy_name() + " " +  vetorSaida2[i].getReceipt_value());
        }
        BubbleSort b = new BubbleSort();
        Gasto vetorSaida4[] = b.ordena(gastos);*/
        System.out.println("Hash");
        Hashing h = new Hashing();
        Gasto gastosH [] = h.tHash(gastos);
        for (int i = 0; i < tam; i++) {
            System.out.println(gastosH[i].getDeputy_name()+ "," + i);
        }
    }

}
