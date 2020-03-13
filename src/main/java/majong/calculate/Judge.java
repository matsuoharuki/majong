package majong.calculate;

public class Judge{
    private StatForCul sfc;
    private int[] hai;
    private String[] haiID = {  "  ", "東", "南", "西", "北", "白", "発", "中", "  ", "  ",
                                "  ", "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m",
                                "  ", "1s", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s",
                                "  ", "1p", "2p", "3p", "4p", "5p", "6p", "7p", "8p", "9p",
                                };

    public Judge( StatForCul sfc ){
        this.sfc = sfc;
        this.hai = sfc.getHai();
    }

    void init(){
        
    }

    public void yaku_pirnt(){
        int i;
        for( i=0; i<14; i++ ) 
            System.out.print( haiID[ hai[i] ] );
        System.out.println();
        System.out.println( "yakuhai\t" + yakuhai() );
        System.out.println( "tanyao\t" + tanyao() );
        System.out.println( "pinfu\t" + pinfu() );
        System.out.println( "menzentsumo\t" + menzentsumo() );
        System.out.println( "ipeko\t" + ipeko() );
        System.out.println( "toitoi\t" + toitoi() );
        System.out.println( "sanshokudoujun\t" + sanshokudoujun() );
        System.out.println( "ikkitsuukan\t" + ikkitsuukan() );
        System.out.println( "chanta\t" + chanta() );
        System.out.println( "sananko\t" + sananko() );
        System.out.println( "shousangen\t" + shousangen() );
        System.out.println( "honroutou\t" + honroutou() );
        System.out.println( "sanshokudoko\t" + sanshokudoko() );
        System.out.println( "honiso\t" + honiso() );
    }

    public void matome(){
        this.sfc.yaku += yakuhai();
        this.sfc.yaku += tanyao();
        this.sfc.yaku += pinfu();
        this.sfc.yaku += menzentsumo();
        this.sfc.yaku += ipeko();
        this.sfc.yaku += toitoi();
        this.sfc.yaku += sanshokudoujun();
        this.sfc.yaku += ikkitsuukan();
        this.sfc.yaku += chanta();
        this.sfc.yaku += sananko();
        this.sfc.yaku += shousangen();
        this.sfc.yaku += honroutou();
        this.sfc.yaku += sanshokudoko();
        this.sfc.yaku += honiso();
        System.out.println( this.sfc.yaku );
    }

    int yakuhai(){
        //daisangen==Tまたはshousangen==TならFalseを返す処理
        int i;
        int jihai[] = { 5, 6, 7, this.sfc.jikaze, this.sfc.bakaze };
        for( i=2; i<12; i+=3 ){
            for( int x: jihai ){
                if( hai[i]==x && hai[i+1]==x && hai[i+1]==x )
                    return 1;
            }
        }
        return 0;
    }

    int tanyao(){
        int i;
        for( i=0; i<14; i++ ){
            if( ( hai[i] < 10 ) || ( hai[i] % 10 == 1 ) || ( hai[i] % 10 ) == 9 )
            //字牌か1か9ならば
                return 0;
        }
        return 1;
    }

    int pinfu(){
        if( this.sfc.furo )
            return 0;
        if( hai[0]==5 || hai[0]==6 || hai[0]==7 || hai[0]==this.sfc.jikaze || hai[0]==this.sfc.bakaze )
            return 0;
        if( hai[2]==hai[3] || hai[5]==hai[6] || hai[8]==hai[9] || hai[11]==hai[12] ) 
            return 0;
        if( this.sfc.agarihai==hai[2]
             || this.sfc.agarihai==hai[4]
             || this.sfc.agarihai==hai[5]
             || this.sfc.agarihai==hai[7] 
             || this.sfc.agarihai==hai[8] 
             || this.sfc.agarihai==hai[10] 
             || this.sfc.agarihai==hai[11] 
             || this.sfc.agarihai==hai[13] )
             return 1;

        return 0;
    }

    int menzentsumo(){
        if( this.sfc.furo==false && this.sfc.agarikata==false )
            return 1;
        else
            return 0;
    }

    int ipeko(){
        if( this.sfc.furo )
            return 0;
        int i,j;
        for( i=2; i<12; i+=3 ){
            if( hai[i]==hai[i+1] )
                continue;
            for( j=i+3; i+j<14; j+=3 ){
                if( hai[i]==hai[j]
                    && hai[i+1]==hai[j+1]
                    && hai[i+2]==hai[j+2] )
                    return 1;
            }
        }
        return 0;
    }

    int toitoi(){
        //if( suankou ) return false;
        if( hai[2]==hai[3]
            && hai[5]==hai[6]
            && hai[8]==hai[9]
            && hai[11]==hai[12] )
            return 2;
        return 0;
    }

    int sanshokudoujun(){
        int i;
        int mentsu[] = { 2, 5, 8, 11 };
        for( i=0; i<4; i++ ){
            if( hai[ mentsu[i%4] ]==hai[ mentsu[i%4]+1 ]
                    || hai[ mentsu[(i+1)%4] ]==hai[ mentsu[(i+1)%4]+1 ]
                    || hai[ mentsu[(i+2)%4] ]==hai[ mentsu[(i+2)%4]+1 ] )
                continue;
            if( hai[ mentsu[i%4] ]%10 == hai[ mentsu[(i+1)%4]%10 ]
                    && hai[ mentsu[(i+1)%4] ]%10 == hai[ mentsu[(i+2)%4] ]%10 ){
                if( hai[ mentsu[i%4] ]/10 != hai[ mentsu[(i+1)%4]/10 ]
                        && hai[ mentsu[(i+1)%4] ]/10 != hai[ mentsu[(i+2)%4] ]/10
                        && hai[ mentsu[(i+2)%4] ]/10 != hai[ mentsu[i%4] ]/10 ){
                    if( this.sfc.furo == false )
                        return 2;
                    else
                        return 1;
                }
            }
        }
        return 0;
    }

    int ikkitsuukan(){
        int i,j,k,cnt;
        for( i=1; i<4; i++ ){
            cnt = 0;
            for( j=1; j<10; j++ ){
                for( k=0; k<14; k++ ){
                    if( hai[k]/10==i && hai[k]%10==j ){
                        cnt += 1;
                        break;
                    }
                }
            }
            if( cnt==9 ){
                if( this.sfc.furo == false )
                    return 2;
                else
                    return 1;
            }
        }
        return 0;
    }

    int chanta(){
        if( honroutou() > 0 )
            return 0;
        if( ( hai[0] > 10 ) && ( hai[0] % 10 != 1 ) && ( hai[0] % 10 ) != 9 )
            return 0;
        int i;
        for( i=2; i<12; i++ ){
            if( ( hai[i] > 10 ) && ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 ){
                if( ( hai[i+2] > 10 ) && ( hai[i+2] % 10 != 1 ) && ( hai[i+2] % 10 ) != 9 )
                    return 0;
            }
        }
        if( this.sfc.furo == false )
            return 2;
        else
            return 1;
    }

    int sananko(){
        if( this.sfc.anko==3 )
            return 1;
        else
            return 0;
    }
    int shousangen(){
        int i,j;
        if( hai[0]==5 || hai[0]==6 || hai[0]==7 ){
            for( i=2; i<12; i+=3 ){
                if( hai[i]==5 || hai[i]==6 || hai[i]==7 ){
                    for( j=i+3; j<12; j+=3 ){
                        if( hai[j]==5 || hai[j]==6 || hai[j]==7 )
                            return 2;
                    }
                }
            }
        }
        return 0;
    }

    int honroutou(){
        int i;
        for( i=0; i<14; i++ ){
            if( ( hai[i] > 10 ) && ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 )
            return 0;
        }
        return 2;
    }
    
    int sanshokudoko(){
        int i;
        int mentsu[] = { 2, 5, 8, 11 };
        for( i=0; i<4; i++ ){
            if( hai[ mentsu[i%4] ]!=hai[ mentsu[i%4]+1 ]
                    || hai[ mentsu[(i+1)%4] ]!=hai[ mentsu[(i+1)%4]+1 ]
                    || hai[ mentsu[(i+2)%4] ]!=hai[ mentsu[(i+2)%4]+1 ] )
                continue;
            if( hai[ mentsu[i%4] ]%10 == hai[ mentsu[(i+1)%4 ]%10 ]
                    && hai[ mentsu[(i+1)%4] ]%10 == hai[ mentsu[(i+2)%4] ]%10 ){
                if( hai[ mentsu[i%4] ]/10 != hai[ mentsu[(i+1)%4]/10 ]
                        && hai[ mentsu[(i+1)%4] ]/10 != hai[ mentsu[(i+2)%4] ]/10
                        && hai[ mentsu[(i+2)%4] ]/10 != hai[ mentsu[i%4] ]/10 )
                    return 2;
            }
        }
        return 0;
    }

    int honiso(){
        int i,j;
        for( i=1; i<4; i++ ){
            j=0;
            while( hai[j]/10==i || hai[j]<10 ){
                j++;
                if( j==14 ){
                    if( this.sfc.furo == false )
                        return 3;
                    else
                        return 2;
                }
            }
        }
        return 0;
    }
}