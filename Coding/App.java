import java.util.*;
class client{
    int lc;
    String[] likes;
    int dc;
    String[] dislikes = new String[5];
    client(){
        lc = 0;
        dc = 0;
    }
}

public class App {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        List<String> all_like = new ArrayList();
        List<String> all_dislike = new ArrayList();
        String c = scan.nextLine();
        int e = Integer.parseInt(c);
        client[] clients = new client[e];
        if(e>=1 && e<=100000){
            for (int i = 0; i < e; i++) {
                client client = new client();
                String l = scan.nextLine();
                String[] likes = l.split(" ");
                int lc = Integer.parseInt(likes[0]);
                client.lc = lc;
                for(int x = 0 ; x<lc ;x++){
                    client.likes[x] = likes[x+1];
                }
                if (isValid(likes) && (lc >= 1) && (lc <= 5)) {
                    if ((likes.length - 1 != lc)) {
                        System.out.println("||| ERROR |||");
                        break;
                    }
                } else {
                    System.out.println("||| ERROR |||");
                    break;
                }
                String d = scan.nextLine();
                String[] dislikes = d.split(" ");
                int dc = Integer.parseInt(dislikes[0]);
                if (isValid(dislikes) && (dc >= 0) && (dc <= 5)) {
                    if ((dislikes.length - 1 != dc)) {
                        System.out.println("||| ERROR |||");
                        break;
                    }
                } else {
                    System.out.println("||| ERROR |||");
                    break;
                }
                client.dc = dc;
                for(int x = 0 ; x<dc ;x++){
                    client.dislikes[x] = dislikes[x+1];
                }
                clients[i] = client;
            }
        }
        else{
            System.out.println("||| ERROR|||");
        }
        merge(clients,all_like,all_dislike,e);
        String liked[] = all_like.toArray(new String[all_like.size()]);
        System.out.println(liked[0]+liked[5]);
        scan.close();
    }

    private static boolean isValid(String[] str) {
        for (int j = 1; j < str.length; j++) {
            char[] charArray = str[j].toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!Character.isLowerCase(charArray[i]) && !Character.isDigit(charArray[i]) && (charArray.length>15 || charArray.length<1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void merge(client[] clients, List<String> likes, List<String> dislikes, int e){
        for(int i=0; i<e;i++){
            likes.addAll(Arrays.asList(clients[i].likes));
            dislikes.addAll(Arrays.asList(clients[i].dislikes));
        }
    }
}