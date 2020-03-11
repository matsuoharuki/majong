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

        if(pinfuTsumo()){
            sfc.hu = 20;
        } else if(sfc.flag7){
            sfc.hu = 25;
        } else {
        private int now_hu;
        now_hu = based_hu;
        /* 面前加符*/
        if(!sfc.agarikata){
            now_hu += 2;
        } else {
            if(!sfc.furo) now_hu += 10;
        }
        /*各メンツの符*/
        for(i=2;i<14;i+=3){
            if(!(sfc.struct[i]==sfc.struct[i+1]==sfc.struct[i+2])) break;
            if((11<sfc.struct[i]&&sfc.struct<19)&&(21<sfc.struct[i]&&sfc.struct<29)&&(31<sfc.struct&&sfc.struct<39)){
                now_hu += 4;
            } else {
                now_hu += 8;
            }
        }
        
        /*雀頭符*/
        if(0<sfc.struct[0]<8){
            if(sfc.struct[0] == sfc.jikaze+1){
                now_hu += 2;
            }else if(sfc.struct[0] == sfc.bakaze+1){
                now_hu += 2;
            } else if(4<sfc.struct[0]<8){
                now_hu += 2;
            }

        }
        /*待ち符*/
        if(sfc.agarihai==sfc.struct[0]){
            now_hu += 2;
        }
        for(i=2;i<14;i+=3){
            if(sfc.agarihai!=(sfc.struct[i]&&sfc.struct[i+1]&&sfc.struct[i+2])) break;
        }
    }
    }
    private boolean pinfuTsumo(StatForCul sfc){
        return false;
    }
}