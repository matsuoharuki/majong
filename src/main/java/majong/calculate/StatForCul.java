package majong.calculate;
import java.util.Scanner;

public class StatForCul {
    public int agarihai;//上り牌が何だったか,牌と1対1対応の数字で数字
    public boolean agarikata;//false -> ツモ true -> ロン
    public boolean furo;// false -> 面前 -> true -> 鳴き
    public int dora;//ドラの数
    public boolean richi;//false -> 立直なし true -> 立直あり
    public boolean ippatsu;//false -> 一発なし true -> 一発あり
    public boolean flag13;//fasle -> 国士ではない true -> 国士
    public boolean flag7;//false -> 七対子ではない true -> 七対子
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