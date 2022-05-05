# 開発してて詰まったメモ（徒然）

[こちらのPR](https://github.com/kannna5296/book-manager/pull/26) にて
## 何をやろうとしたか
ORMapperをJPAに移行しようとしてみた（DDDにおけるORMapperの使い心地検証目的）
が、そもそも移行できず挫折した

## 現状（ダメ）
2022/05/05現在、
```
***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in net.bookmanager.usecase.detail.BookDetailUseCase required a bean of type 'net.bookmanager.domain.book.IBookRepository' that could not be found.


Action:

Consider defining a bean of type 'net.bookmanager.domain.book.IBookRepository' in your configuration.
```

## ツラいところ
・（マルチモジュールかつ、JPAの情報はinfra層に閉じる前提で）Repositoryの実装方法がわからん
実装しているのは下記
-(Domain層) Repositoryインタフェース
-(JPA) JpaRepositoryインタフェース
-(Infra層) 上記2点を実装したRepositoryインタフェース
多分どこかで実装を作らんといかんのだが、**JpaRepositoryの数あるメソッドを作るのはダルい**

・回避策として、Domain層にJpaRepositoryを実装したRepositoryインタフェースを作れば行けそうな気もする(?)けど、インフラの知識がDomain層に入るのでやりたくない

※[コレ](https://github.com/little-hands/ddd-q-and-a/issues/97)にも関連するやつ

# いろいろ悩んだ結果

[コレ](https://github.com/kannna5296/book-manager/pull/27) が諸悪の根源
メインクラスのパッケージがおかしかったせい（多分）