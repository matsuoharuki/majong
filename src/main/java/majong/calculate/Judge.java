package majong.calculate;

public class Judge{
    private StatForCul sfc;
    private int[] hai;
    private String[] haiID = {  "  ", "東", "南", "西", "北", "白", "発", "中", "  ", "  ",
                                "  ", "1m", "2m", "3m", "4m", "5m", "6m", "7m", "8m", "9m",
                                "  ", "1p", "2p", "3p", "4p", "5p", "6p", "7p", "8p", "9p",
                                "  ", "1s", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s",
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
            System.out.print( haiID[ hai[i] ] + " " );
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
        System.out.println( "junchan\t" + junchan() );
        System.out.println( "ryanpeko\t" + ryanpeko() );
        System.out.println( "chiniso\t" + chiniso() );
        System.out.println( "suanko\t" + suanko() );
        System.out.println( "kokushimusou\t" + kokushimusou() );
        System.out.println( "daisangen\t" + daisangen() );
        System.out.println( "daisushi\t" + daisushi() );
        System.out.println( "shousushi\t" + shousushi() );
        System.out.println( "tsuiso\t" + tsuiso() );
        System.out.println( "chinroutou\t" + chinroutou() );
        System.out.println( "ryuiso\t" + ryuiso() );
        System.out.println( "churenpoton\t" + churenpoton() );
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
        this.sfc.yaku += junchan();
        this.sfc.yaku += ryanpeko();
        this.sfc.yaku += chiniso();
        this.sfc.yaku += suanko();
        this.sfc.yaku += kokushimusou();
        this.sfc.yaku += daisangen();
        this.sfc.yaku += daisushi();
        this.sfc.yaku += shousushi();
        this.sfc.yaku += tsuiso();
        this.sfc.yaku += chinroutou();
        this.sfc.yaku += ryuiso();
        this.sfc.yaku += churenpoton();
        System.out.println( this.sfc.yaku );
    }

    public boolean yakuman(){
        if( suanko() > 0
                || kokushimusou() > 0
                || daisangen() > 0
                || daisushi() > 0
                || shousushi() > 0
                || tsuiso() > 0
                || chinroutou() > 0
                || ryuiso() > 0
                || churenpoton() > 0 )
            return true;
        else
            return false;
    }

    int yakuhai(){
        //daisangen==Tまたはshousangen==TならFalseを返す処理
        if( yakuman() )
            return 0;
        int i;
        int jihai[] = { 5, 6, 7, this.sfc.jikaze, this.sfc.bakaze };
        for( i=2; i<12; i+=3 ){
            for( int x: jihai ){
                if( hai[i]==x && hai[i+1]==x && hai[i+2]==x )
                    return 1;
            }
        }
        return 0;
    }

    int tanyao(){
        if( yakuman() )
            return 0;
        int i;
        for( i=0; i<14; i++ ){
            if( ( hai[i] < 10 ) || ( hai[i] % 10 == 1 ) || ( hai[i] % 10 ) == 9 )
            //字牌か1か9ならば
                return 0;
        }
        return 1;
    }

    int pinfu(){
        if( yakuman() )
            return 0;
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
        if( yakuman() )
            return 0;
        if( this.sfc.furo==false && this.sfc.agarikata==false )
            return 1;
        else
            return 0;
    }

    int ipeko(){
        if( yakuman() )
            return 0;
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
        if( yakuman() )
            return 0;
        if( hai[2]==hai[3]
            && hai[5]==hai[6]
            && hai[8]==hai[9]
            && hai[11]==hai[12] )
            return 2;
        return 0;
    }

    int sanshokudoujun(){
        if( yakuman() )
            return 0;
        int i;
        int mentsu[] = { 2, 5, 8, 11 };
        for( i=0; i<4; i++ ){
            if( hai[ mentsu[i%4] ]==hai[ mentsu[i%4]+1 ]
                    || hai[ mentsu[(i+1)%4] ]==hai[ mentsu[(i+1)%4]+1 ]
                    || hai[ mentsu[(i+2)%4] ]==hai[ mentsu[(i+2)%4]+1 ] )
                continue;
            if( hai[ mentsu[i%4] ]%10 == hai[ mentsu[(i+1)%4] ]%10
                    && hai[ mentsu[(i+1)%4] ]%10 == hai[ mentsu[(i+2)%4] ]%10 ){
                if( hai[ mentsu[i%4] ]/10 != hai[ mentsu[(i+1)%4] ]/10
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
        if( yakuman() )
            return 0;
        int i,j,k,cnt;
        for( i=1; i<4; i++ ){
            cnt = 0;
            for( j=1; j<10; j+=3 ){
                for( k=2; k<14; k+=3 ){
                    if( hai[k]/10==i && hai[k]%10==j && hai[k+1]%10==j+1 ){
                        cnt += 1;
                        break;
                    }
                }
            }
            if( cnt >= 3 ){
                if( this.sfc.furo == false )
                    return 2;
                else
                    return 1;
            }
        }
        return 0;
    }

    int chanta(){
        if( yakuman() )
            return 0;
        if( honroutou() > 0 || junchan()>0 )
            return 0;
        if( ( hai[0] > 10 ) && ( hai[0] % 10 != 1 ) && ( hai[0] % 10 ) != 9 )
            return 0;
        int i;
        for( i=2; i<12; i+=3 ){
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
        if( yakuman() )
            return 0;
        if( this.sfc.anko==3 )
            return 2;
        else
            return 0;
    }

    int shousangen(){
        if( yakuman() )
            return 0;
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
        if( yakuman() )
            return 0;
        int i;
        for( i=0; i<14; i++ ){
            if( ( hai[i] > 10 ) && ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 )
                return 0;
        }
        return 2;
    }
    
    int sanshokudoko(){
        if( yakuman() )
            return 0;
        int i;
        int mentsu[] = { 2, 5, 8, 11 };
        for( i=0; i<4; i++ ){
            if( hai[ mentsu[i%4] ]!=hai[ mentsu[i%4]+1 ]
                    || hai[ mentsu[(i+1)%4] ]!=hai[ mentsu[(i+1)%4]+1 ]
                    || hai[ mentsu[(i+2)%4] ]!=hai[ mentsu[(i+2)%4]+1 ] )
                continue;
            if( hai[ mentsu[i%4] ]%10 == hai[ mentsu[(i+1)%4 ] ]%10
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
        if( yakuman() || chiniso()>0 )
            return 0;
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

    int junchan(){
        if( yakuman() )
            return 0;
        if( honroutou() > 0 )
            return 0;
        if( ( hai[0] < 10 ) || ( ( hai[0] % 10 != 1 ) && ( hai[0] % 10 ) != 9 ) )
            return 0;
        int i;
        for( i=2; i<12; i+=3 ){
            if( ( hai[i] < 10 ) || ( ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 ) ){
                if( ( hai[i+2] < 10 ) || ( ( hai[i+2] % 10 != 1 ) && ( hai[i+2] % 10 ) != 9 ) )
                    return 0;
            }
        }
        if( this.sfc.furo == false )
            return 3;
        else
            return 2;
    }

    int ryanpeko(){
        if( yakuman() )
            return 0;
        if( this.sfc.furo )
            return 0;
        int i;
        for( i=2; i<12; i+=3 ){
            if( hai[i]==hai[i+1] )
                return 0;
        }
        if( hai[2]==hai[5] ){
            if( hai[8]==hai[11] )
                return 3;
        }else if( hai[2]==hai[8] ){
            if( hai[5]==hai[11] )
                return 3;
        }else if( hai[2]==hai[11] ){
            if( hai[5]==hai[8] )
                return 3;
        }
        return 0;
    }

    int chiniso(){
        if( yakuman() )
            return 0;
        int i,j;
        for( i=1; i<4; i++ ){
            j=0;
            while( hai[j]/10==i ){
                j++;
                if( j==14 ){
                    if( this.sfc.furo == false )
                        return 6;
                    else
                        return 5;
                }
            }
        }
        return 0;
    }

    int suanko(){
        if( this.sfc.anko==4 )
            return 13;
        else
            return 0;
    }

    int kokushimusou(){
        int i, flag;
        int[] yao = { 1, 2, 3, 4, 5, 6, 7, 11, 19, 21, 29, 31, 39 };
        for( i=0; i<14; i++ ){
            if( ( hai[i] > 10 ) && ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 )
            return 0;
        }
        for( int x: yao ){
            flag = 0;
            for( i=0; i<14; i++ ){
                if( x==hai[i] ){
                    flag = 1;
                    break;
                }
            }
            if( flag==0 ){
                return 0;
            }
        }
        return 13;
    }

    int daisangen(){
        int i,j,k;
        for( i=2; i<12; i+=3 ){
            if( hai[i]==5 || hai[i]==6 || hai[i]==7 ){
                for( j=i+3; j<12; j+=3 ){
                    if( hai[j]==5 || hai[j]==6 || hai[j]==7 ){
                        for( k=j+3; k<12; k+=3 ){
                            if( hai[k]==5 || hai[k]==6 || hai[k]==7 )
                                return 13;
                        }
                    }
                }
            }
        }
        return 0;
    }

    int daisushi(){
        int i,j,k,l;
        for( i=2; i<14; i+=3 ){
            if( hai[i]==1 ){
                for( j=2; j<14; j+=3 ){
                    if( hai[j]==2 ){
                        for( k=2; k<14; k+=3 ){
                            if( hai[k]==3 ){
                                for( l=2; l<14; l+=3 ){
                                    if( hai[k]==3 ){    
                                        return 13;
                                    }
                                }    
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    int shousushi(){
        int i,j,k;
        if( hai[0]<5 ){
            for( i=2; i<14; i+=3 ){
                if( hai[i]<5 ){ //hai[i]==1 || hai[i]==2 || hai[i]==3 || hai[i]==4
                    for( j=i+3; j<14; j+=3 ){
                        if( hai[j]<5 ){
                            for( k=j+2; k<14; k+=3 ){
                                if( hai[k]<5){   
                                    return 13;  
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    int tsuiso(){
        int i;
        for( i=0; i<14; i++ ){
            if( hai[i]>10 )
                return 0;
        }
        return 13;
    }

    int chinroutou(){
        int i;
        for( i=0; i<14; i++ ){
            if( hai[i] < 10 )
                return 0;
            if( ( hai[i] % 10 != 1 ) && ( hai[i] % 10 ) != 9 )
                return 0;
        }
        return 13;
    }

    int ryuiso(){
        int i,j,flag;
        int[] green = {6, 32, 33, 34, 36, 38};
        for( i=0; i<14; i++ ){
            flag = 0;
            for( j=0; j<6; j++ ){
                if( hai[i]==green[j] )
                flag = 1;
            }
            //flag==1 if hai[i] is contained in green[]
            if( flag == 0 )
                return 0;
        }
        return 13;
    }

    int churenpoton(){
        int i, j, k, cnt;
        if( this.sfc.furo==true )
            return 0;
        for( i=1; i<4; i++ ){
            //whether hai[] does not have other color
            //whether hai[] has 1 ~ 9
            cnt = 0;
            for( j=1; j<10; j++ ){
                for( k=0; k<14; k++ ){
                    if( hai[k] == 10*i + j ){
                        cnt++;
                    }
                }
            }
            if( cnt<9 )
                continue;
            //whether hai[] has 3 1s or more
            cnt = 0;
            for( k=0;k<14; k++ ){
                if( hai[k] == 10*i + 1 ){
                    cnt++;
                }
            }
            if( cnt<3 )
                continue;
            //whether hai[] has 3 9s or more
            cnt = 0;
            for( k=0;k<14; k++ ){
                if( hai[k] == 10*i + 9 ){
                    cnt++;
                }
            }
            if( cnt<3 )
                continue;
            return 13;
        }
        return 0;
    }

}