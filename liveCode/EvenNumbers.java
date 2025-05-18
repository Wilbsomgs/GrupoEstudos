import java.util.Arrays;
public class EvenNumbers{
    public static void main(String[] args){
        int[] numbers = new int[]{5,3,8,0,11,18};
        String inputs;
        int evenNumber = 0, oddNumber = 0;
        
        for(int i =0; i < 6; i++){
           
            
            if(numbers[i] == 0){
                continue;
            }else if(numbers[i] % 2 == 0){
                evenNumber++;
            } else{
                oddNumber++;
            }
        }
        
        inputs = Arrays.toString(numbers);
        
        System.out.println("Entrada" + inputs);
        System.out.println("Números pares: " + evenNumber);
        System.out.println("Números ímpares: " + oddNumber);
   }
}