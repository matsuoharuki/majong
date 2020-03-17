package majong.calculate;
import java.util.LinkedList;
import java.util.Arrays;

/*入力：配列[33]*/
/*出力：雀頭
	   刻子の位置
	   順子の先頭の位置S
	   ７対子フラグ
	   国士無双フラグ
	   */

public class Structure{
	//牌のリスト（0-8 マンズ，9-17 ピンズ，18-26 ソウズ，27-30　東南西北，31-33　白発中）
	//刻子
	public LinkedList<Integer> kotsu = new LinkedList<>();
	//順子の先頭
	public LinkedList<Integer> shuntsu = new LinkedList<>();
	//頭
	public int janto; 
	public LinkedList<Integer> bin = new LinkedList<>();
	public LinkedList<Integer> bin_used = new LinkedList<>();
	public boolean flag7 = false;
	public boolean flag13 = false;
	//構造認識メソッド
	public Paiinfo structure_method(int array[]){
		boolean end_flag = false;

		//国士無双判定
		if(((array[0] == 1)|(array[0] == 2)) && ((array[8] == 1)|(array[8] == 2)) && ((array[9] == 1)|(array[9] == 2)) && ((array[17] == 1)|(array[17] == 2)) && ((array[18] == 1)|(array[18] == 2)) && ((array[26] == 1)|(array[26] == 2)) &&
				((array[27] == 1)|(array[27] == 2)) && ((array[28] == 1)|(array[28] == 2)) && ((array[29] == 1)|(array[29] == 2)) && ((array[30] == 1)|(array[30] == 2)) && ((array[31] == 1)|(array[31] == 2)) && ((array[32] == 1)|(array[32] == 2)) && ((array[33] == 1)|(array[33] == 2))){
					flag13 = true;
				}
		//刻子を全て抜き出す
		for(int i = 0; i <= 33; i++){
			if(array[i] >= 3){
				kotsu.add(i);
				array[i] = array[i] - 3; //元のリストから刻子分を消去
			}
		}
		//kotsu[]に3以上の要素が全て格納

		for(int i =0; i< kotsu.size(); i++){
			bin_used.add(0);
		}

		//どの刻子を使うかのループ
		Kotsu_Loop: for(int val = 0; val < Math.pow(2, kotsu.size()); val++){
			int devide = 1;
			//刻子の数に従った2進数を生成(0:使う, 1:使わない)
			for(int i = 0; i < kotsu.size(); i++){
				bin.add((val / devide) % 2);
				devide = devide * 2;
			}
			for(int i = 0; i < kotsu.size(); i++){
				//binが1の時刻子を戻す
				if((bin_used.get(i) == 0) && (bin.get(i) == 1)){
					array[kotsu.get(i)] = array[kotsu.get(i)] + 3;
				}
			}
			for(int i = 0; i < kotsu.size(); i++){
				//binが1の時刻子を戻す
				if((bin_used.get(i) == 1) && (bin.get(i) == 0)){
					array[kotsu.get(i)] = array[kotsu.get(i)] - 3;
				}
			}
			System.out.println("bin = " + bin);

			//頭を1つ仮定
			for(int i = 0; i <= 33; i++){
				//仮定した頭に対して
				if(array[i] >= 2){
					janto = i;
					array[i] = array[i] - 2; //元のリストから頭分を消去
					//マンズが全て順子かどうか
					Manzu_Loop: for(int j = 0; j <= 6; j++){
						//0ではない要素に対して
						if(array[j] != 0){
							//次の数とその次の数がk要素以上かどうか
							//k要素が0となるまで
							while(array[j] != 0){
								if((array[j] <= array[j + 1]) && (array[j] <= array[j + 2])){
									array[j] = array[j] - 1;
									array[j + 1] = array[j + 1] - 1;
									array[j + 2] = array[j + 2] - 1;
									shuntsu.add(j);
								}
								else{
									//残りを全て順子で表せない場合
									//消した牌を元に戻す
									for(int k = 0; k < shuntsu.size() ; k++){
										int remove = shuntsu.pop();
										array[remove] = array[remove] + 1;
										array[remove + 1] = array[remove + 1] + 1;
										array[remove + 2] = array[remove + 2] + 1;
									}
									break Manzu_Loop;
								}
							}
						}
					}
					//マンズの終了判定

					//ピンズが全て順子かどうか
					Pinzu_Loop: for(int j = 9; j <= 15; j++){
						//0ではない要素に対して
						if(array[j] != 0){
							//次の数とその次の数がk要素以上かどうか
							//k要素が0となるまで
							while(array[j] != 0){
								if((array[j] <= array[j + 1]) && (array[j] <= array[j + 2])){
									array[j] = array[j] - 1;
									array[j + 1] = array[j + 1] - 1;
									array[j + 2] = array[j + 2] - 1;
									shuntsu.add(j);
								}
								else{
									//残りを全て順子で表せない場合
									//消した牌を元に戻す
									for(int k = 0; k < shuntsu.size() ; k++){
										int remove = shuntsu.pop();
										array[remove] = array[remove] + 1;
										array[remove + 1] = array[remove + 1] + 1;
										array[remove + 2] = array[remove + 2] + 1;
									}
									break Pinzu_Loop;
								}
							}
						}
					}
					//ピンズの終了判定
					
					//ソウズが全て順子かどうか
					Souzu_Loop: for(int j = 18; j <= 24; j++){
						//0ではない要素に対して
						if(array[j] != 0){
							//次の数とその次の数がk要素以上かどうか
							//k要素が0となるまで
							while(array[j] != 0){
								if((array[j] <= array[j + 1]) && (array[j] <= array[j + 2])){
									array[j] = array[j] - 1;
									array[j + 1] = array[j + 1] - 1;
									array[j + 2] = array[j + 2] - 1;
									shuntsu.add(j);
								}
								else{
									//残りを全て順子で表せない場合
									//消した牌を元に戻す
									for(int k = 0; k < shuntsu.size() ; k++){
										int remove = shuntsu.pop();
										array[remove] = array[remove] + 1;
										array[remove + 1] = array[remove + 1] + 1;
										array[remove + 2] = array[remove + 2] + 1;
									}
									break Souzu_Loop;
								}
							}
						}
					}
					//ソウズの終了判定
					System.out.println(Arrays.toString(array));
					//終了条件
				for(int j = 0; j <= 33; j ++){
					if(array[j] != 0){
						break;
					}
					if(j == 33){
						end_flag = true;
					}
				}

				if(end_flag == true){
					for(int j = 0; j < kotsu.size(); j++){
						//刻子をbinの0だけにする
						if(bin.get(j) == 1){
							 kotsu.remove(j);
						}
					}
					break Kotsu_Loop;
				}

				//終了しない時
				array[i] = array[i] + 2;
			}
		
		}
		//七対子判定
		if(end_flag == false){
			for(int j = 0; j <= 33; j ++){
				if((array[j] != 0) && (array[j] != 2)){
					break;
				}
				if(j == 33){
					flag7 = true;
				}
			}
		}
		System.out.println("bin_used = " + bin_used);
		bin_used.clear();
		bin_used.addAll(bin);
		bin.clear();
	}
	Paiinfo structure = new Paiinfo();
	structure.janto = janto;
	structure.kotsu = kotsu;
	structure.shuntsu = shuntsu;
	structure.flag7 = flag7;
	structure.flag13 = flag13;

	
	return structure;
}
};