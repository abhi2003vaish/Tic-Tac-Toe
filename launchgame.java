import java.util.*;
class tictactoe
{
    static char[][] board;
    public tictactoe()
    {
       board= new char[3][3];
       initboard();
    }


 void initboard()
{
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[i].length;j++)
        {
            board[i][j]=' ';
        }
    }


}
static void display()
{
    System.out.println("-------------");
    for(int i=0;i<board.length;i++)
    {
        System.out.print("| ");
        for(int j=0;j<board[i].length;j++)
        {
 System.out.print(board[i][j]+" | ");
}
System.out.println();
System.out.println("-------------");
}
}
static void placemark(int row,int column,char mark)

{
    if(row>=0 && row<=2 && column>=0 && column<=2)
    board[row][column]=mark;
else
System.out.println("invaild position");
}

static boolean wincolumn()
{
    for(int j=0;j<3;j++)
    {
        if(board[0][j]!=' '&&(board[0][j]==board[1][j])&&(board[1][j]==board[2][j]))
        return true;
    }
    return false;
}
static boolean winrow()
{
    for(int i=0;i<3;i++)
    {
        if(board[i][0]!=' ' &&(board[i][0]==board[i][1])&&(board[i][1]==board[i][2]))
        return true;
    }
    return false;
}
static boolean diagonalwin()
{
    if(((board[0][0]!=' '&& board[0][0]==board[1][1])&&(board[1][1]==board[2][2]))||((board[0][2]!=' ' && board[0][2]==board[1][1])&&(board[1][1]==board[2][0])))
return true;
else
return false;
}
}
class humanplayer
{
    String name;
    char mark;
    humanplayer(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    void makemove()
    {
        Scanner sc =new Scanner(System.in);
        int row;
        int column;
        do
        {
System.out.println("enter row and column");
        row=sc.nextInt();
    column=sc.nextInt();
        } 
        while(!isvaildmove(row,column));
        tictactoe.placemark(row,column,mark);


    }
    boolean isvaildmove(int row,int column)
    {
        if(row >=0 && row <=2 && column >=0 && column <=2)
        {
            if(tictactoe.board[row][column] == ' ')
            {
            return true;
            }
        }
        return false;
    }
    }










public class launchgame {
    public static void main(String[] args) {
    tictactoe t=new tictactoe();
    


        humanplayer p1=new humanplayer("abhishek ",'X' );
        humanplayer p2=new humanplayer("narender ",'O' );
        humanplayer cp;
        cp=p1;
        while(true)
        {
        
        System.out.println(cp.name+"turn");
        cp.makemove();
        tictactoe.display();
        if(tictactoe.wincolumn()||tictactoe.winrow()||tictactoe.diagonalwin())
        {
            System.out.println(cp.name+"has won");
            break;
        }
         
        else{
            if(cp==p1)
            cp=p2;
            else
            cp=p1;
        }
    }
    }
}
