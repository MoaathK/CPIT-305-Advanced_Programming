


import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.net.http.HttpClient;

public class Main {
    private static final String API_KEY = "5X39CIOXBFE50FP5";
    private static final String SIMPLE_URL = "https://www.alphavantage.co/query";
    public static void main(String[] args) {



        boolean done = true;
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Welcome to the stock market Software");
        do {
            System.out.print("Enter the stock symbol(Name): ");
            String stock = input.nextLine();
            System.out.println();
            if (stock.isEmpty()){
                done = false;
                break;
            }
            System.out.println("If you want the real-time prices Enter 1: ");
            System.out.println("-------------------------------------");
            System.out.println("If you want the weekly prices Enter 2:");
            System.out.println("-------------------------------------");
            System.out.println("If you want the monthly prices Enter 3:");
            System.out.print("what is your chose ?");
            value = input.nextInt();
            System.out.println();
            if (value == 1){
                getRealTimeData(stock);
            }
            else if (value == 2){
                getWeeklyData(stock);

            }else if (value == 3){
                getMonthlyData(stock);

            }else {
                System.out.println("This was not a number in the menu ");
            }
        }while (done);


    }
    public  static String fetchData(String stock, String function, String interval) {
        HttpClient client = HttpClient.newHttpClient();
        String url = SIMPLE_URL + "?function=" + function + "&symbol=" + stock;

        if (!interval.isEmpty()) {
            url += "&interval=" + interval;
        }

        url += "&apikey=" + API_KEY;


        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void getRealTimeData(String stockName){
        String data = fetchData(stockName,"TIME_SERIES_INTRADAY","5min");

        System.out.println(data);
    }
    public static void getWeeklyData(String stockName){
        String data = fetchData(stockName,"TIME_SERIES_WEEKLY","");
        System.out.println(data);
    }
    public static void getMonthlyData(String stockName){
        String data = fetchData(stockName,"TIME_SERIES_MONTHLY","");
        System.out.println(data);


    }
}