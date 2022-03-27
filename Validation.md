#調べたこと

##違反した時に出る例外

| a | c | v |
| ---- | ---- | ---- |
| check | java.lang.IllegalStateException | a |
| require | java.lang.IllegalArgumentException | a |
| valicktor.validate | org.valiktor.ConstraintViolationException | a |

★initでValictor使ってバリデーションしたものはテストでもValicktor使わんとダメそう

## BeanValidation

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

Nullableにしないといけない（Kotlinの旨味なし）

https://takeda-san.hatenablog.com/entry/2019/07/25/231739

## カスタムバリデータ作る
https://fukuchiharuki.me/static/pukiwikidump/page/Spring%20Boot/Kotlin%E3%81%A7Custom%20Validator%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B.html

`Kotlin 相関チェック`でググるとこうなる