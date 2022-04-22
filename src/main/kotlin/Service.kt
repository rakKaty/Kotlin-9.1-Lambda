object Service {

    private var chats = mutableListOf<Chat>()


    fun addMessage(newMessage: Message): Message? {

        val chatToAddMessage = chats.find { it.receptorId == newMessage.receptorId }
            ?: createChat(newMessage)

        chatToAddMessage.messages.add(newMessage)

        return chats.find { it.receptorId == newMessage.receptorId }?.messages?.last()
    }


    private fun createChat(messageToCreateChat: Message): Chat {
        val newChat = Chat(
            ownerId = messageToCreateChat.ownerId,
            receptorId = messageToCreateChat.receptorId,
            id = messageToCreateChat.chatId,
            messages = emptyList<Message>() as MutableList<Message>
        )
        chats.add(newChat)
        return chats.last()
    }


    fun deleteChat(chatToDelete: Chat) {
        val value = chats.find { it.id == chatToDelete.id }
        chats.remove(value)
    }


    fun deleteMessage(messageToDelete: Message) {
        chats.find { it.id == messageToDelete.chatId }?.messages?.remove(messageToDelete)
        chats.remove(chats.find { it.id == messageToDelete.chatId && it.messages.size == 0 })
    }


    fun updateMessage(messageToUpdate: Message) {
        chats.find { it.id == messageToUpdate.chatId }?.messages
            ?.find { it.id == messageToUpdate.id }
            ?.let { it.text == "Сообщение отредактировано" }
    }

    fun getUnreadChatsCount(): Int {
        val amountOfUnreadChats: Int = chats.filter { it.messages.last().isUnread }.size
        println("Колличество непрочитаных чатов - $amountOfUnreadChats")
        return amountOfUnreadChats
    }


    fun getMessagesByChatId(chatIdToGetMessages: Int): MutableList<Message>? {
        return chats.find { it.id == chatIdToGetMessages }?.messages
    }


    fun getLatestMessagesByChatIdMessageId(
        chatId: Int,
        messageIdToStartWith: Int,
        amount: Int,
    ): List<Message>? {
        return chats.find { it.id == chatId }?.messages
            ?.takeLastWhile { it.id == messageIdToStartWith }?.take(amount)
    }


    fun printAllChats() {
        for (chat in chats) {
            println("Все чаты:\n chat.id = ${chat.id} " +
                    ", chat.ownerId = ${chat.ownerId}" +
                    ", chat.receptorId = ${chat.receptorId}" +
                    ", chat.message = ${chat.messages}"

            )
        }
    }

    fun printCurrentChat(chatToPrint: Chat) {
        val chatToPrintId = chatToPrint.id
        for (chat in chats) {
            if (chat.id == chatToPrintId) {
                println("ИНформация о данном чате:\n chat.id = ${chat.id} " +
                        ", chat.ownerId = ${chat.ownerId}" +
                        ", chat.receptorId = ${chat.receptorId}" +
                        ", chat.message = ${chat.messages}"
                )
            }
        }


    }

    private fun printCurrentMessage(message: Message) {
        println("message.id = ${message.id} " +
                ", message.chatId = ${message.chatId}" +
                ", message.ownerId = ${message.ownerId}" +
                ", message.receptorId = ${message.receptorId}" +
                ", message.data = ${message.data}" +
                ", text = ${message.text}" +
                ", isUnread = ${message.isUnread}\n"
        )
    }
}


