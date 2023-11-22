import java.sql.SQLOutput;
import java.util.Scanner;
// Game class
public class Game {
    static char[][] board;
    Player player1,player2;
    static int count;

    public Game(){
        board=new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
    void print(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println("Count: "+ count);
    }

    void markDown(char mark,int row,int col,Player p){

            if(board[row][col]==' '){
                board[row][col]=mark;
                count++;

            }else{
                System.out.println("Already marked,try new position");
                System.out.println(p.getName()+ " enter new position");
                Scanner input=new Scanner(System.in);
                int pos=input.nextInt();
                p.marks(pos);
            }

    }
    boolean markChecker(char mark1,char mark2){
        boolean status=mark2==mark1?false:true;
        return status;
    }

    boolean winningByRow(char mark){
        boolean status=false;
        int counter=0;
        //Row checking
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==mark){
                    counter++;
                }
            }
            if(counter==3){
                status=true;
            }else{
                counter=0;
            }
        }
        return status;
    }
    boolean winningByCol(char mark){
        boolean status=false;
        int counter=0;
        //Row checking
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]==mark){
                    counter++;
                }
            }
            if(counter==3){
                status=true;
            }else{
                counter=0;
            }
        }
        return status;
    }
    boolean winningByDiagonal(char mark){
        boolean status1=false;
        boolean status2=false;
        int counter=0;
        for(int i=0;i<board.length;i++){
            if(board[i][i]==mark){
                counter++;
            }
        }
        if(counter==3){
            status1=true;
        }
        counter=0;
        for(int i=0,j=board.length-1;i<board.length && j>=0;i++,j--){
            if(board[i][j]==mark){
                counter++;
            }
        }
        if(counter==3){
            status2=true;
        }

        return (status1 || status2);
    }
    boolean winningStatus(char mark){
       return (winningByCol(mark) || winningByDiagonal(mark) || winningByRow(mark));
    }
    void gameStart(Game game){
        player1=new Player("Player1",15,'X',game);
        player2=new Player("Player2",20,'Y',game);
        Scanner input=new Scanner(System.in);
        int pos;

        while(true){
            if(count<9) {
                System.out.println("Player1 enter the position");
                pos = input.nextInt();
                player1.marks(pos);
                print();
                if (winningStatus(player1.getMark()) == true) {
                    System.out.println("Player1 won:" + player1.getMark());
                    break;
                }
            }
            if(count<9) {
                System.out.println("Player2 enter the position");
                pos = input.nextInt();
                player2.marks(pos);
                print();
                if (winningStatus(player2.getMark()) == true) {
                    System.out.println("Player2 won:" + player1.getMark());
                    break;
                }
            }
            if(count==9){
                System.out.println("DRAW");
                break;
            }
        }

    }
}
