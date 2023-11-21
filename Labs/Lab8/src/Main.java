import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.net.http.HttpClient;


public class Main {
    private static final String API_KEY = "5X39CIOXBFE50FP5";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the stock market Software");
            System.out.print("Enter the stock symbol(Name): ");
            String stock = input.nextLine();
            System.out.println("\nIf you want the real-time prices Enter 1: ");
            System.out.println("-------------------------------------");
            System.out.println("If you want the weekly prices Enter 2:");
            System.out.println("-------------------------------------");
            System.out.println("If you want the monthly prices Enter 3:");
            System.out.println("-------------------------------------");
            System.out.println("Type 7 to exit: ");
            System.out.print("what is your chose ?");
            int value = input.nextInt();
            System.out.println();
            if (value == 1){
                getRealTimeData(stock);
            }
            else if (value == 2){
                getWeekData(stock);

            }else if (value == 3){
                getMonthlyData(stock);
            }
            else {
                System.out.println("This was not a number in the menu ");
            }



        }




    public static void getRealTimeData(String stock){
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+stock+"&interval=5min&apikey="+API_KEY+"&datatype=csv";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            String[] lines = response.body().split("\n");
            if (lines.length > 1) {

                String[] latestData = lines[1].split(",");
                String lastUpdatedPrice = latestData[3];
                System.out.println("Last Updated Price: " + lastUpdatedPrice);
            } else {
                System.out.println("No data available");
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void printTheData(String stock,int numOfDays,String type){


        String url = "https://www.alphavantage.co/query?function="+type+"&symbol="+stock+"&interval=5min&apikey="+API_KEY+"&datatype=csv";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String[] lines = response.body().split("\n");
            int daysToPrint = Math.min(lines.length - 1, numOfDays);
            for (int i = 1; i < daysToPrint; i++) {
                String[] data = lines[i].split(",");
                String date = data[0];
                String closingPrice = data[4];
                System.out.println("Date: " + date + ", Closing Price: " + closingPrice);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void getMonthlyData(String stockName){
        printTheData(stockName,31,"TIME_SERIES_MONTHLY");


    }
    public static void getWeekData(String stockName){
        printTheData(stockName,6,"TIME_SERIES_WEEKLY");


    }
}