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

。