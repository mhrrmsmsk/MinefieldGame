import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final char MINE_CELL = '*';
    private static final char EMPTY_CELL = '-';
    int row;
    int column;
    int size;
    int success=0;
    char[][] board;
    char[][] map;
    boolean isCheck=true;

Scanner scanner=new Scanner(System.in);
Random random =new Random();
    public Game(int row, int column) {
        this.row = row;
        this.column = column;
        this.size=column*row;
        this.board=new char[row][column];
        this.map=new char[row][column];
    }
    void run(){
        generateMap();
        initializeGame();
        while (isCheck){
            int col,row;
            System.out.println("========");
            print(board);
            System.out.print("Row :");
            row=scanner.nextInt();
            System.out.print("Column :");
            col=scanner.nextInt();
            if (row>=0&&row<this.row && col>=0 && col<this.column){
                if (map[row][col]!=MINE_CELL){
                    // haritada mayınları kontrol eden metot
                    check(row,col);
                    success++;
                    if (success==size-(size/4)){
                        System.out.println("congratulations! You Won...");
                        print(map);
                        break;
                    }
                }else {
                    System.out.println("Game over!");
                    isCheck=false;
                }

            }else {
                System.out.println("You entered a value outside the board please try again!");
            }

        }

}
    void check(int row, int col) {
        if (map[row][col] == EMPTY_CELL) {
            int mineCount = 0;

            // Sağa bakma
            if (col < (this.column - 1) && map[row][col+1] == MINE_CELL) {
                mineCount++;
            }

            // Sola bakma
            if (col > 0 && map[row][col-1] == MINE_CELL) {
                mineCount++;
            }

            // Yukarıya bakma
            if (row > 0 && map[row-1][col] == MINE_CELL) {
                mineCount++;
            }

            // Aşağıya bakma
            if (row < (this.row - 1) && map[row+1][col] == MINE_CELL) {
                mineCount++;
            }

            // Sol üst çapraza bakma
            if (row > 0 && col > 0 && map[row-1][col-1] == MINE_CELL) {
                mineCount++;
            }

            // Sağ üst çapraza bakma
            if (row > 0 && col < (this.column - 1) && map[row-1][col+1] == MINE_CELL) {
                mineCount++;
            }

            // Sağ alt çapraza bakma
            if (row < (this.row - 1) && col < (this.column - 1) && map[row+1][col+1] == MINE_CELL) {
                mineCount++;
            }

            // Sol alt çapraza bakma
            if (row < (this.row - 1) && col > 0 && map[row+1][col-1] == MINE_CELL) {
                mineCount++;
            }

            board[row][col] = (char) ('0' + mineCount);
        }
    }

void generateMap(){
        // haritayı oluşturma
    for (int i=0;i<row;i++){
        for (int j=0;j<column;j++){
            map[i][j]=EMPTY_CELL;
        }
    }
    // oyun tahtasını oluşturma
    for (int i=0;i<row;i++){
        for (int j=0;j<column;j++){
            board[i][j]=EMPTY_CELL;
        }
    }
}
  public void initializeGame(){
// rastgele mayın yerleştirme
        int randRow,randColmn;
        int count=0;
        while (count!=size/4){
            randRow=random.nextInt(row);
            randColmn=random.nextInt(column);
            if (map[randRow][randColmn]!=MINE_CELL){
                map[randRow][randColmn]=MINE_CELL;
                count++;
            }
        }
  }
  void print(char[][] arr){
        // oyun tahtasını ekrana yazdıran metot
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
  }


}
