package majong.calculate;
//import java.util.Scanner;

public class SignCul{

    private StatForCul sfc;
    public SignCul(StatForCul sfc){
        this.sfc = sfc;
    }
    
    public void signCul(){
        /*基本符*/ 
        private int based_hu = 20;

        if(pinfuTsumo()) sfc.hu = 20;
        if(sfc.flag7) sfc.hu = 25;
        
        private int now_hu;
        now_hu = based_hu;
        /* 面前加符*/
        if(!sfc.agarikata){
            now_hu += 2;
        } else {
            if(!sfc.furo) now_hu += 10;
        }
        /*各メンツの符*/
        
        /*雀頭符*/
        
        /*待ち符*/

    }
}