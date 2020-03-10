package majong.calculate;

public class Judge{
    StatForCul sfc;
    void init(){
        
    }

    boolean yakuhai( int hai[] ){
        //daisangen==Tまたはshousangen==TならFalseを返す処理
        int i;
        int jihai[] = { 5, 6, 7, sfc.jikaze, sfc.bakaze };
        for( i=2; i<12; i+=3 ){
            for( int x: jihai ){
                if( hai[i]==x && hai[i+1]==x && hai[i+1]==x )
                    return true ;
            }
        }
        return false ;
    }

    boolean tanyao( int hai[] ){
        int i;
        for( i=0; i<14; i++ ){
            if( ( hai[i] < 10 ) || ( hai[i] % 10 == 1 ) || ( hai[i] % 10 ) == 9 )
            //字牌か1か9ならば
                return false ;
        }
        return true ;
    }

    boolean pinfu( int hai[] ){
        if( sfc.furo )
            return false;
        if( hai[0]==5 || hai[0]==6 || hai[0]==7 || hai[0]==sfc.jikaze || hai[0]==sfc.bakaze )
            return false ;
        if( hai[2]==hai[3] || hai[5]==hai[6] || hai[8]==hai[9] || hai[11]==hai[12] ) 
            return false ;
        if( sfc.agarihai==hai[2]
             || sfc.agarihai==hai[4]
             || sfc.agarihai==hai[5]
             || sfc.agarihai==hai[7] 
             || sfc.agarihai==hai[8] 
             || sfc.agarihai==hai[10] 
             || sfc.agarihai==hai[11] 
             || sfc.agarihai==hai[13] )
             return true ;

        return false ;
    }
    boolean menzentsumo( int hai[] ){
        if( sfc.furo==false && sfc.agarikata==false )
            return true ;
        else
            return false ;
    }
    boolean ipeko( int hai[] ){
        if( sfc.furo )
            return false ;
        int i,j;
        for( i=2; i<12; i+=3 ){
            if( hai[i]==hai[i+1] )
                continue ;
            for( j=3; i+j<14; j+=3 ){
                if( hai[i]==hai[j]
                    && hai[i+1]==hai[j+1]
                    && hai[i+2]==hai[j+2] )
                    return true ;
            }
        }
        return false ;
    }
    boolean toitoi( int hai[] ){
        //if( suankou ) return false ;
        if( hai[2]==hai[3]
            && hai[5]==hai[6]
            && hai[8]==hai[9]
            && hai[11]==hai[12] )
            return true ;
        return false;
    }
    boolean sanshokudoujun( int hai[] ){
        int i;
        int mentsu[] = { 2, 5, 8, 11 };
        for( i=0; i<4; i++ ){
            if( hai[ mentsu[i%4] ]==hai[ mentsu[i%4]+1 ]
                    && hai[ mentsu[(i+1)%4] ]==hai[ mentsu[(i+1)%4]+1 ]
                    && hai[ mentsu[(i+2)%4] ]==hai[ mentsu[(i+2)%4]+1 ] )
                return false ;
            if( hai[ mentsu[i%4] ]%10 == hai[ mentsu[(i+1)%4]%10 ]
                    && hai[ mentsu[(i+1)%4] ]%10 == hai[ mentsu[(i+2)%4] ]%10 ){
                if( hai[ mentsu[i%4] ]/10 != hai[ mentsu[(i+1)%4]/10 ]
                        && hai[ mentsu[(i+1)%4] ]/10 != hai[ mentsu[(i+2)%4] ]/10
                        && hai[ mentsu[(i+2)%4] ]/10 != hai[ mentsu[i%4] ]/10 )
                    return true ;
            }
        }
        return false ;
    }

    boolean ikkitsuukan( int hai[] ){
        int i,j,k,cnt;
        for( i=1; i<4; i++ ){
            cnt = 0 ;
            for( j=1; j<10; j++ ){
                for( k=0; k<14; k++ ){
                    if( hai[k]/10==i && hai[k]%10==j )
                        cnt += 1 ;
                        break;
                }
            }
            if( cnt==9 )
                return true ;
        }
        return false ;
    }

}