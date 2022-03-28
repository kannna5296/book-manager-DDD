# 調べたこと

## ありえるもの
* 頑張ってロジックを書く(if文書いて例外投げる)
* javax.validation.constraints.NotNull;とか（BeanValidation）
* kotlin.check,require
* kotlin.assert(実行時オプション -ea　必須)
* Konform(サードパーティライブラリ)
* Valiktor(サードパーティライブラリ)
* Kvalidation(サードパーティライブラリ)
    * https://medium.com/nerd-for-tech/object-validation-in-kotlin-c7e02b5dabc
    * ぶっちゃけどれも変わらん気がする
    
## 違反した時に出る例外

| 使うもの | 例外クラス | 補足 |
| ---- | ---- | ---- |
| check | java.lang.IllegalStateException |  |
| require | java.lang.IllegalArgumentException |  |
| valicktor.validate | org.valiktor.ConstraintViolationException |  |

★initで外部ライブラリ使ってバリデーションしたものはテストでも外部ライブラリ使わんとダメそう

## KotlinでBeanValidation

### Java EEのやつ(フィールドにつける)
javax.validation.constraints.NotNull;とか

```
data class Test(
  @QueryParam("hoge")
  @field:NotNull
  val hoge: String?
)
```
@fieldが必要

バリデーションのためにNullableにしないといけない（Kotlinの旨味なし）

参考：https://takeda-san.hatenablog.com/entry/2019/07/25/231739

## カスタムバリデータ作る

面倒
https://fukuchiharuki.me/static/pukiwikidump/page/Spring%20Boot/Kotlin%E3%81%A7Custom%20Validator%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B.html

`Kotlin 相関チェック`でググると↑みたいなのがいっぱい出てくる

# そもそも論

## そもそもいわゆる「チェック」の分類考えてみた

### フィールド単体を確認するだけで済むもの

「バリデーション」と呼ばれる？

* 必須チェック(Kotlinなら?つけるか否かで制御可能)
* 項目長チェック
* 属性チェック（静的型付けならあんまり気にせんで良い？）
* 外字チェック

アノテーションとかで実装されがちなイメージ

### フィールド単体の確認だけで済まないもの

「論理チェック」とも呼ばれる？

* 相関チェック
    * フィールド VS 他のフィールド
* 存在チェック
    * フィールド VS 永続化媒体（DBとかキャッシュとか） 
* 権限チェック
    * フィールド VS 権限（DBとかで表現される）

ロジックを頑張って書いて実装されがちなイメージ

3/29　話題
★「kotlin標準を使っていく」が良いと思う<br>
★「バリデーション」って何を指す？<br>
★アノテーションとか使う？ @field(おまじない)が必要そうなので個人的にはあんまり推しでない<br>
★上記って全部ドメイン層に書くでOK？<br>
