import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String[] valores = Valores();
        int pos;
        boolean loop = true;

        while (true) {
       
        Board(valores);
        WinCondiction(valores);
        LoseCondiction(valores);
        TieCondiction(valores);

        System.out.println("Escolha uma posicao: ");
        pos = scan.nextInt();

        while(loop){
        if(valores[pos-1] != "X" && valores[pos-1] != "O"){
            loop = false;
        }
        }
        valores[pos-1] = "X";   
        loop = true;

        WinCondiction(valores);
        LoseCondiction(valores);
        TieCondiction(valores);
        
        while(loop){
        pos = Computer();
        if(valores[pos-1] != "X" && valores[pos-1] != "O"){
            loop = false;
        }
        }
        valores[pos-1] = "O";
        }
    }

    public static void Board(String[] valores) {

        System.out.println(String.format("%s|%s|%s", valores[0],valores[1],valores[2]));
        System.out.println(String.format("%s|%s|%s", valores[3],valores[4],valores[5]));
        System.out.println(String.format("%s|%s|%s", valores[6],valores[7],valores[8]));
    }

    public static void WinCondiction(String[] valores){

        for(int i = 0; i < 9; i += 3){
            if( valores[0 + i] == "X" && valores[1 +i] == "X" && valores[2+i] == "X"  ){
                System.out.println("Voce Venceu");
                System.exit(0);
            }
        }

        for(int i = 0; i < 3; i++){
            if( valores[0 + i] == "X" && valores[3 +i] == "X" && valores[6+i] == "X"  ){
                System.out.println("Voce Venceu");
                System.exit(0);
            }
        }
        
        if( valores[0] == "X" && valores[4] == "X" && valores[8] == "X"  ){
            System.out.println("Voce Venceu");
            System.exit(0);
        }

        if( valores[2] == "X" && valores[4] == "X" && valores[6] == "X"  ){
            System.out.println("Voce Venceu");
            System.exit(0);
        }
    }

    public static void LoseCondiction(String[] valores){

        for(int i = 0; i < 9; i += 3){
            if( valores[0 + i] == "O" && valores[1 +i] == "O" && valores[2+i] == "O"  ){
                System.out.println("Voce Perdeu");
                System.exit(0);
            }
        }

        for(int i = 0; i < 3; i++){
            if( valores[0 + i] == "O" && valores[3 +i] == "O" && valores[6+i] == "O"  ){
                System.out.println("Voce Perdeu");
                System.exit(0);
            }
        }
        
        if( valores[0] == "O" && valores[4] == "O" && valores[8] == "O"  ){
            System.out.println("Voce Perdeu");
            System.exit(0);
        }

        if( valores[2] == "O" && valores[4] == "O" && valores[6] == "O"  ){
            System.out.println("Voce Perdeu");
            System.exit(0);
        }
    }

    public static void TieCondiction(String[] valores){

        int aux = -1;

        for(int i = 0; i < 9; i++ ){
            if(valores[i] == "X" || valores[i] == "O"){
                aux++;
            }
        }

        if(aux == 8){
            System.out.println("Empate");
            System.exit(0);
        }
    }

    public static String[] Valores() {
        
        String[] valor = {"1","2","3","4","5","6","7","8","9"};

        return valor;
    }

    public static int Computer(){
        Random GerarRandom = new Random();

        int num = 1 + GerarRandom.nextInt(8);
        return num;
    }
}