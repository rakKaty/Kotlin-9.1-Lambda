data class Chat(
    val ownerId: Int,
    val receptorId: Int,
    val id: Int,
    //var messages: MutableList<Message>,
    var countMessages: Int,
    var isEmpty: Boolean,
    var isUnread: Boolean,
    var isDeleted : Boolean
    )

data class Message(
    val id: Int,
    val chatId : Int,
    val ownerId: Int,
    val receptorId: Int,
    val data: Int,
    var text: String,
    var isUnread: Boolean,
    var isDeleted : Boolean
    )
