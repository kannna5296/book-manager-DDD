# book-manager
Kotlin練習リポジトリ

手を動かすためのもの。[こちらの本](https://www.amazon.co.jp/Kotlin-%E3%82%B5%E3%83%BC%E3%83%90%E3%83%BC%E3%82%B5%E3%82%A4%E3%83%89%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0%E5%AE%9F%E8%B7%B5%E9%96%8B%E7%99%BA-%E7%AB%B9%E7%AB%AF-%E5%B0%9A%E4%BA%BA/dp/4297118599)を完全コピーしたものになる予定

元リポジトリはこちら
https://github.com/n-takehata/kotlin-server-side-programming-practice

## わかってないこと・感想

### DDD話
 * MapperとRepositoryの住み分け、ちゃんと理解したい

 * そもそもORmapperどうしよう（JPA？MyBatis？JOOQ？）
 
 * ドメイン層にRepositoryのIFがあって、インフラ層にRepositoryのImplがある。コレなんで？そういうもん？

 * 「重複を許さない」みたいなチェックがアプリケーションサービスにあるのはなんで？（ドメインモデルが持ってるもののイメージだった）

### Kotlin話
```
  val bookList = bookService.getList().map {
    //itって何やねんと思ったらiteratorでした（ループ回すと同義）
    BookInfo(it)
  }
```

* 〜letって何？
* openついてないクラスとSealdクラス、両方継承できないが、何が違うんや？明示的に示すだけか？

## 直接関係ないけどメモ

* コードレビュー観点 メソッドがインスタンス変数を使っているか？（つかってないならそのクラスに置く意味がない）

* 業務データと業務ロジックをまとめたもの > ドメインオブジェクト
* ちゃんとまとまっている状態 > "凝集度が高い"
* 最初によく思いつくドメインオブジェクトはでかくなりがち（注文クラスとか） >商品・数量・金額・納期とか小さいドメインオブジェクトに分けていく

### Kotlinめも

* 継承
* コンストラクタ

* List,Mapの生成がJavaとちょっと違う（イミュータブル、ミュータブル指定できたり）
* 変数定義、valはイミュータブル変数、varはミュータブル変数
* if,Whenを式として使える（JavaのVerナントカからあった気もする）
* gettersetterはプロパティ定義すると勝手にできるので明示的に実装不要（デフォルトでLombok入ってるみたいな感じ）
    * val変数にはgetterのみできる（Kotlin側で自動的にやってくれる、イミュータブルなので当然）
    * カスタムで実装すること自体は可能（NULLの時デフォルト設定する、とか）￥
* lateinit（プロパティ初期化）いつ要るんやこれ

* データクラス（toString,hashCode,equals,componentN,copyが自動実装される
    * hachCodeて何に使うんやっけ？（JavaGoldの知見だった気もする） 

* デフォルト引数と名前付き引数（引数への代入を事前にやっといてインスタンス生成時に省略できる）

#### 関数型、高階関数、タイプエイリアス
Javaでいう関数型インターフェースてきなやつ
* 関数型　関数を変数として定義する
```
val calc: (Int, Int) -> Int = {num1: Int, num2: Int -> num1 * num2 }
```

* 高階関数 関数型のオブジェクトを引数として受け取る
```
  fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1,num2)
    println(result)
  }
```

```
  //どんな計算するかは呼び出す時に決定
  printCalcResult(1,10, { num1, num2 -> num1 + num2 }
  printCalcResult(1,10, { num1, num2 -> num1 * num2 }
```

* タイプエイリアス 関数型を複数の場所で使い回すための型を定義（変数定義ではない）
```
  typealias Calc = (Int, Int) -> Int
```

```
  fun printCalcResult(num1: Int, num2: Int, calc: Calc) {
    val result = calc(num1,num2)
    println(result)
  }
```

#### 拡張関数
* Kotlin標準のクラスに対して独自関数を突っ込むことができる

```
  fun Int:square(): Int = this * this
  fun main() {
    println(2.square)
  }
```

#### スコープ関数

* with 複数の処理をまとめて行う
* run Nullableなオブジェクトに複数の処理をまとめて行う
* let Nullableなオブジェクトに名前をつけて処理を行う
* apply　オブジェクトに変更を加えて返す
* also オブジェクトに名前をつけて変更を加えて返す

## KotlinとJavaギャップ

* デフォルトで変数がNull代入不可（nullが代入されるとコンパイルエラー）
    * `var check: String? = "Kotlin"` null代入できる
    * ↑の場合、check変数からはセーフコール演算子(?)か非NULL宣言演算子(!!)でしかメソッドを呼べない
    * セーフコール演算子...値がNULLでない時のみメソッドが呼ばれる。　`check?.length`
    * 非NULL表明演算子...NULLだろうが何だろうがメソッドを呼ぶ NULLの場合は当然NullPointerException 基本的には非推奨？？ `check!!.length`
* 変数定義でval(再代入不可能)var(可能)を指定
* 変数定義時にstatic指定できない。インスタンス生成せずにメソッドを呼ぶには、companionObjectなるものを使う。
* クラス定義時、元々final(継承不可)。 継承させるにはアクセス修飾子としてOpenをつける　Sealdっていうアクセス修飾子もあるけど何で居るのかようわからん
* getter/setterの定義不要（コレに伴いLombokも実質不要）
* コンストラクタの作り方がちょっと特殊（プライマリコンストラクタ、セカンダリコンストラクタ）
    * プライマリコンストラクタ...クラス定義時の引数みたいなやつ　デフォルト値登録可能
    * セカンダリコンストラクタ...いわゆるJavaで書いてたコンストラクタ
```
Java に比べて、Kotlin では複数のコンストラクタを持つクラスは一般的ではありません。
なぜならば、Javaでオーバーロードによって複数のコンストラクタを必要とする状況は、Kotlin では引数のデフォルト値と名前付き引数によってカバーされるからです。 
```
ほんまか？？引用元は[こちら](https://blog.y-yuki.net/entry/2019/05/25/093000)

* List,Mapの生成がJavaとちょっと違う（イミュータブル、ミュータブル指定できたりする、ListOfなど）
* Streamなしでもコレクションにいろいろアクセスできる
  https://kotlinlang.org/docs/java-to-kotlin-collections-guide.html#operations-on-any-collection-type

## Kotlin慣れに良いサイト（たぶん）

https://kotlinlang.org/docs/java-to-kotlin-idioms-strings.html　<br>
https://kotlinlang.org/docs/java-to-kotlin-collections-guide.html#operations-on-any-collection-type　<br>
公式。Javaでこう書いてたものがKotlinだとこう、みたいな感じ

公式。H2DV