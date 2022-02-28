import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random= new Random();
        int number=random.nextInt(100);
        Scanner scanner=new Scanner(System.in);
        int input;
        boolean isWin=false;
        boolean isIncorrectInput=false;
        int[] wrongAnswers=new int[5];
        System.out.println("ans: "+number);
        System.out.println("    SAYI TAHMİN OYUNU   ");
        for (int right = 0; right < 5; right++) {
            System.out.print("Sayı giriniz :");

            input=scanner.nextInt();
            if((input<0) || (input>100)){
                if(!isIncorrectInput){
                    right-=1;
                    System.out.println("Sayı 0-100 arası olmalıdır!");
                    isIncorrectInput=true;
                    continue;
                }
                else {
                    System.out.println("Tekrar hatalı işlem yaptınız, hak sayınız azalıyor. Kalan Hak : "+(5-(right+1)));
                }
            }
            else if(input==number){
                System.out.println("Tebrikler sayıyı bildiniz! Sayı : "+number);
                isWin=true;
                break;
            }
            else if(input<number){
                wrongAnswers[right]=input;
                System.out.println("Girdiğiniz "+input+" sayısı, cevaptan küçük!");
            }
            else if (input>number){
                wrongAnswers[right]=input;
                System.out.println("Girdiğiniz "+input+" sayısı, cevaptan büyük!");
            }
            System.out.println("Kalan hak :"+(5-(right+1)));
        }
        if(!isWin){
            System.out.println("Hakkınız bitti, kaybettiniz.");
            System.out.println("Cevap : "+number);
        }
        System.out.println("Girdiğiniz Yanlış Cevaplar : ");
        for (int i:wrongAnswers){
            if(i!=0){
                System.out.print(i+"  ");
            }
        }
    }
}
