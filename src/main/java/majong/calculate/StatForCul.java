package majong.calculate;
import java.util.Scanner;

public class StatForCul {
    public int agarihai;//上り牌が何だったか,牌と1対1対応の数字で数字
    public boolean agarikata;//0 -> ツモ 1 -> ロン
    public boolean furo;// 0 -> 面前 -> 1 -> 鳴き
    public int dora;//ドラの数
    public boolean richi;//0 -> 立直なし 1 -> 立直あり
    public boolean ippatsu;//0 -> 一発なし 1 -> 一発あり
    public boolean flag13;//0 -> 国士ではない 1 -> 国士
    public boolean flag7;//0 -> 七対子ではない 1 -> 七対子
    public int jikaze;//0 -> 東 1 -> 南 3 -> 西 4 -> 北
    public int bakaze;//0 -> 東 1 -> 南
    
    public void importStat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("上がり牌はなんですか？:");
        agarihai = sc.nextInt();
        System.out.println("上がり方はなんですか？:");
        if (sc.nextInt() == 0){
            agarikata = false;
        } else{
            agarikata = true;
        }
        
    }
}