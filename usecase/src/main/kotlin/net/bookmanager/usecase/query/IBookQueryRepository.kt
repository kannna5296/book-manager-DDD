package net.bookmanager.usecase.query

//あくまで練習用にCQRS(Command Query Responsibility Segregation)導入
//ホントはもっと複雑な検索とかするシステムでこそ効果を発揮する
interface IBookQueryRepository {
    //TODO 一覧検索用にfindAll等も追加
    fun findById(id: Int): BookRecord
}
