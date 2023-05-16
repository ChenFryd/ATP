//package Exercise1;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        createWorkers();
//    }
//    private static void createWorkers(){
//        WorkerFactory factory = new WorkerFactory();
//        Scanner scanner = new Scanner(System.in);
//        String input = "0";
//        while (input != "stop"){
//            input = scanner.nextLine();
//            try {
//                factory.createWorker(input);
//            } catch (Exception e)
//            {
//                System.out.println("Invalid input");
//            }
//
//        }
//
//    }
//}