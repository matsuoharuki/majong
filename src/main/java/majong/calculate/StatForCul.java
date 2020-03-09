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
    public int honba;//本場数
    public int yaku;//翻数
    public int hu;//符数
    public int score;//点数

    public StatForCul(int agarihai,boolean agarikata,boolean furo,int dora,boolean richi,boolean ippatsu,boolean flag13,boolean flag7,int jikaze,int bakaze,int honba,int yaku,int hu,int score){
        this.agarihai = agarihai;
        this.agarikata = agarikata;
        this.furo = furo;
        this.dora = dora;
        this.richi = richi;
        this.ippatsu = ippatsu;
        this.flag13 = flag13;
        this.flag7 = flag7;
        this.jikaze = jikaze;
        this.bakaze = bakaze;
        this.honba = honba;
        this.yaku = yaku;
        this.hu = hu;
        this.score = score;
    }

    public void importStat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("上がり牌はなんですか？:");
        agarihai = sc.nextInt();
        System.out.println("上がり方はロンですか？(y/n):");
        agarikata = booler(sc.next());
        System.out.println("鳴きましたか？(y/n):");
        furo = booler(sc.next());
        System.out.println("ドラは何枚ですか？:");
        dora = sc.nextInt();
        System.out.println("リーチしましたか？(y/n):");
        richi = booler(sc.next());
        System.out.println("一発でしたか？(y/n):");
        ippatsu = booler(sc.next());
        System.out.println("何家ですか？(東:1,南:2,西:3,北:4):");
        jikaze = sc.nextInt();
        System.out.println("何場ですか？(東:1,南:2):");
        bakaze = sc.nextInt();
        System.out.println("何本場ですか？:");
        honba = sc.nextInt();
    }

    private boolean booler(String s){
        if (s == "y") return true;
        else return false;
    }
}