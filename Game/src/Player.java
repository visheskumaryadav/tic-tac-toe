public class Player {
    private  String name;
    private char mark;
    private int age;
    Game game;
    public Player(String name,int age,char mark,Game game){
        this.name=name;
        this.age=age;
        this.mark=mark;
        this.game=game;
    }

    void setMark(char mark){
        this.mark=mark;
    }
    char getMark(){
        return mark;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void marks(int pos){

        switch (pos){
            case 1: game.markDown(mark,0,0,this);break;
            case 2: game.markDown(mark,0,1,this);break;
            case 3: game.markDown(mark,0,2,this);break;
            case 4: game.markDown(mark,1,0,this);break;
            case 5: game.markDown(mark,1,1,this);break;
            case 6: game.markDown(mark,1,2,this);break;
            case 7: game.markDown(mark,2,0,this);break;
            case 8: game.markDown(mark,2,1,this);break;
            case 9: game.markDown(mark,2,2,this);break;
            default:
                System.out.println("Invalid position");
        }
    }
}
