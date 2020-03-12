package majong.calculate;

import org.junit.Test;
import static org.junit.Assert.*;

public class JudgeMainTest {
    @Test public void testMajongMain() {
        int[] hai           = { 12, 12, 
                                13, 13, 13,
                                14, 15, 16,
                                22, 23, 24,
                                35, 36, 37 };
        int agarihai        = 22;       //上り牌が何だったか,牌と1対1対応の数字で数字
        boolean agarikata   = false;    //false -> ツモ true -> ロン
        boolean furo        = false;    // false -> 面前 -> true -> 鳴き
        int dora            = 0;        //ドラの数
        boolean richi       = false;    //false -> 立直なし true -> 立直あり
        boolean ippatsu     = false;    //false -> 一発なし true -> 一発あり
        int jikaze          = 1;        //1 -> 東 2 -> 南 3 -> 西 4 -> 北
        int bakaze          = 0;        //0 -> 東 1 -> 南
        int honba           = 1;        //本場数
    
        StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
        Judge yaku = new Judge(sfc);
        yaku.yaku_pirnt();
        yaku.matome();    
    }
}