package Modelo;

import Visual.JanelaArquivosTxt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;

public class ArquivosTxt {

    private String nome;
    private String mensagem;
    private static File arquivo;
    private String path;

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArquivosTxt() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ArquivosTxt(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public void RenomearArquivo(String nome) {

        try {
            File fTmp = new File("C:\\Users\\Paulo Brito\\Desktop\\" + nome + ".tmp");
            File fTxt = new File("C:\\Users\\Paulo Brito\\Desktop\\" + nome + ".txt");
            fTxt.createNewFile();
            Writer arquivo = new FileWriter(fTmp);

            fTmp.renameTo(fTxt);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String toStringArrayList(ArrayList< String> linhas) {
        String result = "";
        for (int i = 0; i < linhas.size(); i++) {
            result += linhas.get(i) + "\n";
        }
        return result;
    }

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";

        ArrayList< String> linhas = new ArrayList< String>();

        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else {
                break;
            }
            linha = buffRead.readLine();
            if (linha != null) {
                linhas.add(linha);
            }
        }

        buffRead.close();
        JOptionPane.showMessageDialog(null,
                toStringArrayList(linhas), "Conteúdo do arquivo",
                JOptionPane.DEFAULT_OPTION);
    }

    public void Salvando(String nome, ArrayList< String> mensagem) {

        path = "C:\\Users\\Paulo Brito\\Desktop\\" + nome + ".txt";

        File arquivo = new File(path);

        try {

            if (!arquivo.exists()) {
//cria um arquivo (vazio)
                arquivo.createNewFile();
            }

//caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();

//escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < mensagem.size(); i++) {

                bw.write(mensagem.get(i));
                bw.newLine();
            }

            bw.close();
            fw.close();

//faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(fr);

//equanto houver mais linhas
            fw = new FileWriter(arquivo, true);

            bw = new BufferedWriter(fw);

            while (br.ready()) {
//lê a proxima linha
                String linha = br.readLine();

//faz algo com a linha
                System.out.println(linha);

                bw.write(linha);
                bw.newLine();

            }
            br.close();
            fr.close();

            JOptionPane.showMessageDialog(null, "O arquivo " + arquivo.getName() + " foi salvo em: \n" + arquivo.getPath()
                    + "\nCom Sucesso!", "Salvo com Sucesso", JOptionPane.OK_CANCEL_OPTION);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro em " + ex);
        } finally {

        }

    }

    public void Salvando(JTextField NomeArquivo, JTextField Caixa1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
