#調べたこと

## ありえるもの
* 頑張ってロジックを書く(if文書いて例外投げる)
* javax.validation.constraints.NotNull;とか（BeanValidation）
* kotlin.check,require
* kotlin.assert(実行時オプション -ea　必須)
* Konform(サードパーティライブラリ)
* Valiktor(サードパーティライブラリ)
* Kvalidation(サードパーティライブラリ)

##違反した時に出る例外

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


## バリデーションの種類
そもそも何をしないといけないのか

* ①単一フィールドに対してバリデーション
    * 値が空じゃないかチェック
    * 値の文字数チェック
    * 値のパターンチェック(電話番号とか)
  
* ②複数フィールド(A,B)に対してバリデーション（相関チェック）
    * A < Bであることをチェック

①と②が混ざらんように書きたい<br>

オブジェクトの開始日 < 実行日時 < 終了日のチェックとかはどう実装するのがオイシイか？（ユースケース層に書く論理チェックだからバリデーションとは別に考える？）

## いわゆる「チェック」の分類考えてみた

### フィールド単体を確認するだけで済むもの

これを「バリデーション」と呼んでる？

* 必須チェック
* 項目長チェック
* 属性チェック（静的型付けならあんまり気にせんで良い？）
* 外字チェック

アノテーションとかで実装されがちなイメージ

### フィールド単体の確認だけで済まないもの

これを「論理チェック」と呼んでる？

* 相関チェック
    * フィールド VS 他のフィールド
* 存在チェック
    * フィールド VS 永続化媒体（DBとかキャッシュとか） 
* 権限チェック
    * フィールド VS 権限（DBとかで表現される）

ロジックを頑張って書いて実装されがちなイメージ