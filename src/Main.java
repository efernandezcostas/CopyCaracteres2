import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Texto texto = new Texto();
        texto.leerTexto();
        texto.copiarTexto();
    }
}

class Texto {
    ArrayList<String> listaLineas = new ArrayList<>();

    public void leerTexto(){
        String resultado;

        try(
                FileReader fr = new FileReader("texto1.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
            while (true) {
                resultado = br.readLine();
                if (resultado != null)  listaLineas.add(resultado);
                else break;
            }

        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void copiarTexto(){
        try (
                FileWriter fw = new FileWriter("texto2.txt");
                PrintWriter pw = new PrintWriter(fw);
        ){
            for (String linea : listaLineas){
                pw.println(linea);
            }
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
