package majong.calculate;

public class Cul{
    private StatForCul sfc;
    public Cul(StatForCul sfc){
        this.sfc = sfc;
    }

    public void cul(){
        int yaku;
        int hu;
        int score;
        yaku = sfc.yaku;
        hu = sfc.hu;
        boolean oya_flag = false;
        if(sfc.jikaze == 1) oya_flag = true;
        switch(yaku){
            case 1:
                if(hu<40) score=1500;
                else if(40<=hu&&hu<50) score=2000;
                else if(50<=hu&&hu<60) score=2400;
                else if(60<=hu&&hu<70) score=2900;
                else if(70<=hu&&hu<80) score=3400;
                else if(80<=hu&&hu<90) score=3900;
                else if(90<=hu&&hu<100) score=4400;
                else if(100<=hu&&hu<110) score=4800;
                else if(hu>110) score=5300;
                else score=0;
            case 2:
                

            case 3:

            case 4:

            default:
        }
    }
}