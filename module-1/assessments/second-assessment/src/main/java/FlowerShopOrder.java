import java.io.File;
import java.util.Scanner;

public class FlowerShopOrder {

    public static void main(String[] args) {
        FlowerShopOrder newOrder= new FlowerShopOrder("roses",5);

    }

   private String bouquetType;
   private int numberOfRoses;

   public String getBouquetType(){return bouquetType;}
    public int getNumberOfRoses(){return numberOfRoses;}
    public double subtotal(){return numberOfRoses*2.99 + 19.99;}

    public FlowerShopOrder(String bouquetType, int numberOfRoses) {
       this.bouquetType= bouquetType;
       this.numberOfRoses = numberOfRoses;


    }

    public double delivery(boolean sameDayDelivery, String zipCode){
       if (sameDayDelivery) {
           if (zipCode.startsWith("2")){
               return 9.98;}
           else if (zipCode.startsWith("3")){
               return 12.98;
           }
           else {
               return 5.99;
           }
       }

       else if (zipCode.startsWith("1")){
           return 0;
       }
       else if (zipCode.startsWith("2")) {
           return 3.99;
       }
       else if (zipCode.startsWith("3")) {
           return 6.99;
       }
       else {
           return 19.99;
       }
    }


    @Override

    public String toString(){
     return "ORDER" +  " - " + bouquetType + " - " + numberOfRoses + " roses" + subtotal();

    }
        //find file path

    File dataFile = new File(path);

        Scanner in = new Scanner(dataFile);









}
