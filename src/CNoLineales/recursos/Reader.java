package CNoLineales.recursos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    protected BufferedReader br;
    protected File file;
    protected String path = "src/CNoLineales/Grafos/TXT/";

    public Reader(){
        this.br = null;
        this.file = null;
    }

    public void leerArchivo(ArrayList<String[]> data) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del archivo:");
        String fileName = scanner.nextLine();
        scanner.close();
        path = path +"/"+fileName;
        file = new File(path);
        if(file.exists()){
            this.br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line != null){
                data.add(line.split(","));
                line = br.readLine();
            }
            br.close();
        }
        else{
            throw new IOException("no se encuentra el archivo");
        }
        
    }
}
