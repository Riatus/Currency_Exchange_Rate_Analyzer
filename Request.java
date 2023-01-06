import java.util.Scanner;

public class Request {
    public String date1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first date dd/MM/yyyy");
        String date1 = scanner.nextLine();
        return date1;
    }
    public String date2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter second date dd/MM/yyyy");
        String date2 = scanner.nextLine();
        return date2;
    }
}
