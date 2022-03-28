import java.util.List;
import java.util.ArrayList;
public class declrarative_prog {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<Integer>();
        prices.add(10);
        prices.add(50);
        prices.add(80);
        int[] pricesWithjGST = prices.stream().mapToInt((Integer p) -> p + (int) (p*0.18)).toArray();
        for( int i = 0 ; i < pricesWithjGST.length ; i++ ){
            System.out.println(pricesWithjGST[i]);
        }
        
    }
}
