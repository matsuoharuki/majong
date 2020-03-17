package majong.calculate;
import java.util.Scanner;

public class StatForCul {
    final public int agarihai;//上り牌が何だったか,牌と1対1対応の数字で数字
    final public boolean agarikata;//false -> ツモ true -> ロン
    final public boolean furo;// false -> 面前 -> true -> 鳴き
    final public int dora;//ドラの数
    final public boolean richi;//false -> 立直なし true -> 立直あり
    final public boolean ippatsu;//false -> 一発なし true -> 一発あり
    final public int jikaze;//1 -> 東 2 -> 南 3 -> 西 4 -> 北
    final public int bakaze;//1 -> 東 2 -> 南
    final public int honba;//本場数

    public boolean flag13;//fasle -> 国士ではない true -> 国士
    public boolean flag7;//false -> 七対子ではない true -> 七対子
    public int yaku;//翻数
    public int hu;//符数
    public int score;//点数
    public int anko;//暗刻の数

    private int[] hai;//牌ベクトル
    public int[] struct= new int[14];//牌の構造

    public StatForCul(int[] hai,int agarihai,boolean agarikata,boolean furo,int dora,boolean richi,boolean ippatsu,int jikaze,int bakaze,int honba){
        this.hai = hai;

        this.agarihai = agarihai;
        this.agarikata = agarikata;
        this.furo = furo;
        this.dora = dora;
        this.richi = richi;
        this.ippatsu = ippatsu;
        this.jikaze = jikaze;
        this.bakaze = bakaze;
        this.honba = honba;

        this.flag13 = false;
        this.flag7 = false;
        this.yaku = 0;
        this.hu = 0;
        this.score = 0;
        this.anko = 0;
        
    }

    public int[] getHai(){
        return this.hai;
    }
    /*
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
    */
    private boolean booler(String s){
        if (s == "y") return true;
        else return false;
    }
    
}