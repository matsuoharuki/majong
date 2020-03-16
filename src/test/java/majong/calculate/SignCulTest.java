package majong.calculate;

import org.junit.Test;
import static org.junit.Assert.*;

public class SignCulTest {

    private int[] test1 = {21,21,1,1,1,11,12,13,14,15,16,17,18,19};//sfc.hu = 32
    private int[] test2 = {1,1,11,12,13,15,16,17,21,22,23,31,32,33};//sfc.hu = 26
    private int[] test3 = {3,3,11,12,13,12,13,14,15,16,17,19,19,19};//sfc.hu = 38
    private int[] test4 = {1,1,2,2,2,14,14,14,22,23,24,36,37,38};//sfc.hu = 36
    private int[] test5 = {1,1,2,2,3,3,4,4,5,5,6,6,7,7};//sfc.hu = 25
    private int[] test6 = {1,2,3,4,5,6,7,11,19,21,29,31,39,1};//sfc.hu = 0
    private int[] test7 = {11,11,21,22,23,24,25,26,27,28,29,31,32,33};//sfc.hu = 7:20 7_2:30 7_3:22 7_4:24

    int dora=3;//ドラの数
    private boolean richi=false;//false -> 立直なし true -> 立直あり
    private boolean ippatsu=false;//false -> 一発なし true -> 一発あり
    private int jikaze=1;//1 -> 東 2 -> 南 3 -> 西 4 -> 北
    private int bakaze=1;//1 -> 東 2 -> 南
    private int honba=0;//本場数
    private int hai[] = {3,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    @Test public void test1SignCul() {
    int agarihai=1;//上り牌が何だったか,牌と1対1対応の数字で数字
    boolean agarikata=false;//false -> ツモ true -> ロン
    boolean furo=false;// false -> 面前 -> true -> 鳴き
    
    StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
    addArray(sfc, test1);
    SignCul sc = new SignCul(sfc);
    sc.signCul();
    System.out.println(sfc.hu);
    }

    @Test public void test2SignCul() {
        int agarihai=1;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=false;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test2);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test3SignCul() {
        int agarihai=14;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=true;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test3);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test4SignCul() {
        int agarihai=14;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=true;//false -> ツモ true -> ロン
        boolean furo=true;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test4);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test5SignCul() {
        int agarihai=1;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=true;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test4);
        sfc.flag7 = true;
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test6SignCul() {
        int agarihai=1;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=true;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test6);
        sfc.flag13 = true;
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test7SignCul() {
        int agarihai=24;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=false;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test7);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test7_2SignCul() {
        int agarihai=24;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=true;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test7);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test7_3SignCul() {
        int agarihai=24;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=false;//false -> ツモ true -> ロン
        boolean furo=true;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test7);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    @Test public void test7_4SignCul() {
        int agarihai=25;//上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata=false;//false -> ツモ true -> ロン
        boolean furo=false;// false -> 面前 -> true -> 鳴き
        
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        addArray(sfc, test7);
        SignCul sc = new SignCul(sfc);
        sc.signCul();
        System.out.println(sfc.hu);
    }

    private void addArray (StatForCul sfc,int[] array){
        for(int i=0;i<14;i++){
        sfc.struct[i] = array[i];
        }
    }
}

