package majong.calculate;
//import java.util.Scanner;

public class SignCul{

    private StatForCul sfc;
    public SignCul(StatForCul sfc){
        this.sfc = sfc;
    }
    
    public void signCul(){
        /*基本符*/ 
        int based_hu = 20;

        if(pinfuTsumo(this.sfc)){
            sfc.hu = 20;
        } else if(sfc.flag7){
            sfc.hu = 25;
        } else {
        int now_hu;
        now_hu = based_hu;
        /* 面前加符*/
        if(!sfc.agarikata){
            now_hu += 2;
        } else {
            if(!sfc.furo) now_hu += 10;
        }
        /*各メンツの符*/
        for(int i=2;i<14;i+=3){
            if(!(sfc.struct[i]==sfc.struct[i+1])) break;
            if((11<sfc.struct[i]&&sfc.struct[i]<19)&&(21<sfc.struct[i]&&sfc.struct[i]<29)&&(31<sfc.struct[i]&&sfc.struct[i]<39)){
                now_hu += 4;
            } else {
                now_hu += 8;
            }
        }
        
        /*雀頭符*/
        if(0<sfc.struct[0]&&sfc.struct[0]<8){
            if(sfc.struct[0] == sfc.jikaze+1){
                now_hu += 2;
            }else if(sfc.struct[0] == sfc.bakaze+1){
                now_hu += 2;
            } else if(4<sfc.struct[0]&&sfc.struct[0]<8){
                now_hu += 2;
            }

        }
        /*待ち符*/
        
        if(sfc.agarihai==sfc.struct[0]){
            now_hu += 2;
        }else if(sfc.agarihai<10){
            now_hu += 2;
        }
        else{
        for(int i=2;i<14;i+=3){
            if(sfc.agarihai==sfc.struct[i]){
                if(sfc.struct[i]==sfc.struct[i+1]){
                    now_hu += 2;
                    break;
                } else if(sfc.struct[i]%10==7){
                    now_hu += 2;
                    break;
                } else{
                    break;
                }
            }
            else if(sfc.agarihai==sfc.struct[i+1]){
                now_hu += 2;
                break;
            }
            else if(sfc.agarihai==sfc.struct[i+2]){
                if(sfc.struct[i]==sfc.struct[i+1]){
                    now_hu += 2;
                    break;
                } else if(sfc.struct[i]%10==3){
                    now_hu += 2;
                    break;
                } else{
                    break;
                }
            }

        }
    }
        
        sfc.hu = now_hu;
    }

    }
    private boolean pinfuTsumo(StatForCul sfc){
        return false;
    }
}