package Exercice3;

public class Main {
    public static void main(String[] args){
        try{
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.IsFile("C:\\Coding\\Java\\Lab5\\src\\Exercice3\\IsoCountries.csv"));
        System.out.println(fileReader.ReadFile("C:\\Coding\\Java\\Lab5\\src\\Exercice3\\IsoCountries.csv"));
        System.out.println(fileReader.ReadFileLines("C:\\Coding\\Java\\Lab5\\src\\Exercice3\\IsoCountries.csv"));
        System.out.println(fileReader.ReadFileLines("C:\\Coding\\Java\\Lab5\\src\\Exercice3\\IsoCountries.csv"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
