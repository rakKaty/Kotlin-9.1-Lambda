object Service {

    private var chats = mutableListOf<Chat>()
    private var messages = mutableListOf<Message>()


    fun addChat(newChat: Chat): Chat {
        chats.add(newChat)
        return chats.last()
    }

    fun addMessage(newMessage: Message): Message {
        messages.add(newMessage)
        return messages.last()
    }


    fun deleteChat(chatToDelete: Chat) : Boolean {
        for (message in messages) {
            if (message.chatId == chatToDelete.id) {
                messages.remove(message)
            }
        }
        for (chat in chats) {
            if (chat.id == chatToDelete.id) {
                chats.remove(chat)
                return true
            }
        }
        return false
    }


    fun deleteMessage(messageToDelete: Message) : Boolean {
        for (message in messages) {
            if (message.id == messageToDelete.id) {
                messages.remove(message)
                return true
            }
        }
        return false
    }


    fun updateMessage(messageToUpdate: Message) : Boolean {
        for ((index, message) in messages.withIndex()) {
            if (message.id == messageToUpdate.id) {
                messages[index] = messageToUpdate
                return true
            }
        }
        return false
    }

    fun getUnreadChatsCount() {

    }
    

    fun printAllChats() {
        for (chat in chats) {
            println("Все чаты:\n chat.id = ${chat.id} " +
                    ", chat.ownerId = ${chat.ownerId}" +
                    ", chat.receptorId = ${chat.receptorId}" +
                    //", chat.message = ${chat.messages}" +
                    ", countMessages = ${chat.countMessages}" +
                    ", isDeleted = ${chat.isDeleted}"
                //val isEmpty: Boolean,
                //val isUnread: Boolean,

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
                        //", chat.message = ${chat.messages}" +
                        ", countMessages = ${chat.countMessages}" +
                        ", isDeleted = ${chat.isDeleted}" +
                        ", isEmpty = ${chat.isEmpty}" +
                        ", isUnread = ${chat.isUnread}"
                )
            }
            println("Сообщения этого чата:")
            for (message in messages) {
                if (message.chatId == chatToPrintId) {
                    println(printCurrentMessage(message))
                }
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
                ", isDeleted = ${message.isDeleted}" +
                ", isUnread = ${message.isUnread}\n"
        )
    }
}



/*
fun <T> List<T>.filter(
    predicate : (item : T) -> Boolean
) : List<T> {
    val filtered = mutableListOf<T>()
    for (item in this) {
        if(predicate (item)) {
            filtered.add(item)
        }
    }
    return filtered
}

 */

