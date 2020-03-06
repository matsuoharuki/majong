package majong.calculate;

public class Judge{
    StatForCul sfc;
    void init(){
        
    }

    boolean yakuhai( int hai[] ){
        //daisangen==Tまたはshousangen==TならFalseを返す処理
        int i;
        for( i=2; i<12; i+=3 ){
            int jihai[] = { 5, 6, 7 };
            //↑に自風と場風も追加すること
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
        if( hai[0]==5 || hai[0]==6 || hai[0]==7 )
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
        return !sfc.furo ;
    }
}