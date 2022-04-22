data class Chat(
    val ownerId: Int,
    val receptorId: Int,
    val id: Int,
    var messages: MutableList<Message>,
)

data class Message(
    val id: Int,
    val chatId: Int,
    val ownerId: Int,
    val receptorId: Int,
    val data: Int,
    var text: String,
    var isUnread: Boolean,
)
