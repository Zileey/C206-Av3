package br.inatel.cdg.avaliacao3;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Arquivo {
    public void escrever(Pedido p1){

        OutputStream os  = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            os = new FileOutputStream("arquivoPedidos.txt",true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Pedido n:");
            bw.newLine();
            bw.write(p1.id + "\n");
            bw.newLine();
            bw.write("Tipo de madeira");
            bw.newLine();
            bw.write(p1.tipoMadeira + "\n");
            bw.newLine();
            bw.write("Preço de produção");
            bw.newLine();
            bw.write(p1.precoProducao + "\n");
            bw.newLine();
            bw.write("Preço de venda");
            bw.newLine();
            bw.write(p1.precoVenda + "\n");
            bw.newLine();



        }catch (Exception e){
            System.out.println(e);
        }finally {

            try{

                bw.close();

            }catch(Exception e){
            System.out.println(e);
        }
    }
    }

    public ArrayList<Pedido> ler(){

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linhaLer;

        ArrayList<Pedido> noArquivo = new ArrayList<>();

        try{

            is = new FileInputStream("arquivoPedidos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();
            while (linhaLer != null){
                if(linhaLer.contains("Pedido n:")){
                    Pedido aux = new Pedido(); //variável auxiliar
                    aux.id = Integer.parseInt(br.readLine());
                    aux.tipoMadeira = br.readLine();
                    aux.precoVenda = Double.parseDouble(br.readLine());
                    aux.precoProducao = Double.parseDouble(br.readLine());
                    noArquivo.add(aux);
                }
                linhaLer = br.readLine();
            }


        }catch (Exception e){

            System.out.println(e);
        }finally {
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }

        return noArquivo;
    }
}
