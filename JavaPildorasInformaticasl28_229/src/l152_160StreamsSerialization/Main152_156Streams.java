package l152_160StreamsSerialization;

import java.io.*;

public class Main152_156Streams {
    public static void main(String[] args) {
        try {
            myFileReader();
            myFileWriter();
            myBufferedReader();
            myBufferedWriter();
            myFileInputStream();
            fileInputOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //152
    public static void myFileReader() throws IOException {
        FileReader fileReader = new FileReader(new File("resources\\ficheroLectura.txt"));
        int caracter;
        while((caracter= fileReader.read())!=-1){
            System.out.print((char)caracter);
        }
        fileReader.close();
    }

    //153
    public static void myFileWriter () throws IOException {
        FileWriter fileWriter = new FileWriter(new File("resources\\ficheroEscritura.txt"));
        String cadena = "Esta cadena la escribo para mi FileWriter";
        fileWriter.write("Esta cadena la escribo para mi FileWriter");
        fileWriter.close();
    }

    //154 Buffer

    public static void myBufferedReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader( new File("resources\\ficheroLectura.txt")));
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();

    }

    public static void myBufferedWriter() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( new File("resources\\ficheroEscritura.txt")));
        bufferedWriter.write("Esta es mi primera línea");
        bufferedWriter.newLine();
        bufferedWriter.write("Esta es mi segunda línea");
        bufferedWriter.close();
    }

    // 155
    private static void fileInputOutputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("resources\\Morgana.png"));
        byte[] bytes = fileInputStream.readAllBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("resources\\copiaMorgana.png"));
        fileOutputStream.write(bytes);
//        for(byte b:bytes){
//            fileOutputStream.write(b);
//        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void myFileInputStream() {
    }

}

