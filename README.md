# majong

麻雀得点自動計算システム

## 実行方法
- 学習（予め撮影しておいた牌の画像を学習し，モデルを`src/main/resources/model/model.bin` に出力）

`./gradlew run --args="-l"`
- 牌の判定および点数計算（判定したい画像のパスimage_pathを渡し，学習で出力されたmodel.binを用いて牌の並び推測し，点数を計算する）

`./gradlew run --args="-r image_path"`
