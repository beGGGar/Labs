
import java.util.Scanner;

/**
 *
 * @author vdmoi
 */
public class Main {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        int max = 100;
        int maxNum = max;
        int minNum = 1;
        int compareNum = maxNum/2;
        String ans;
        Scanner in = new Scanner(System.in);   
        
        while(compareNum != -1){
            System.out.println("Is your number more than " + compareNum + "?  y/n");// + " " + minNum + " " + maxNum + " " + "?  y/n");
            ans = in.nextLine();
            switch(ans){
                case ("y"):
                    if(compareNum>=maxNum){
                        compareNum = -1;
                        break;
                    }
                    minNum = compareNum;
                    compareNum = minNum + (maxNum - minNum+1)/2;
                    minNum = minNum+1;
                    break;
                case ("n"):
                    if(compareNum < minNum){
                        compareNum = -1;
                        break;
                    }
                    maxNum = compareNum;
                    compareNum = maxNum - (maxNum - minNum+1)/2;
                    break;
                case ("e"):
                    compareNum = -1;
                    break;
                default:
                    System.out.print("Wrong value. Try again: ");
                    break;
            }
            if(compareNum == minNum && compareNum == maxNum){
                break;
            }
        }
        while(compareNum >0){
            System.out.println("Is your number " + compareNum + "? y/n ");
            ans = in.nextLine();
            switch(ans){
                case("y"):
                    System.out.println("!Congratulations!");
                    compareNum = -2;
                    break;
                case("n"):
                    compareNum = -1;
                    break;
                default:
                    System.out.print("Wrong value. Try again: ");
                    break;
            }
        }
        if(compareNum == -1)System.out.println("You are liyer");
        in.close();
    }
    
}
