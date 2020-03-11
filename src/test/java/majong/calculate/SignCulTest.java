package majong.calculate;

import org.junit.Test;
import static org.junit.Assert.*;

public class SignCulTest {
    @Test public void testSignCul() {
    int agarihai=1;//上り牌が何だったか,牌と1対1対応の数字で数字
    boolean agarikata=false;//false -> ツモ true -> ロン
    boolean furo=false;// false -> 面前 -> true -> 鳴き
    int dora=3;//ドラの数
    boolean richi=false;//false -> 立直なし true -> 立直あり
    boolean ippatsu=false;//false -> 一発なし true -> 一発あり
    int jikaze=1;//0 -> 東 1 -> 南 3 -> 西 4 -> 北
    int bakaze=1;//0 -> 東 1 -> 南
    int honba=0;//本場数
    int hai[] = {3,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    StatForCul sfc = new StatForCul(hai, agarihai, agarikata, furo, dora, richi, ippatsu, jikaze, bakaze, honba);
    SignCul sc = new SignCul(sfc);
    sc.signCul();
    System.out.print("Hello World");
    
    }
}
