fun main() {

    var chats = mutableListOf<Chat>()
    var messages = mutableListOf<Message>()

    val message1 = Message(
        555,
        1,
        111,
        222,
        120322,
        "сообщение1",
        false,
        false
    )

    val message2 = Message(
        444,
        2,
        333,
        111,
        120322,
        "сообщение2",
        false,
        false
    )


    val chat1 = Chat(
        111,
        222,
        1,
        1,
        false,
        false,
        false
    )

    val chat2 = Chat(
        333,
        222,
        2,
        1,
        false,
        false,
        false
    )

  Service.addChat(chat1)
    Service.addChat(chat2)
   // Service.printChats()

    Service.addMessage(message1)
    Service.addMessage(message2)

   // Service.editMessage(message1)
    //Service.printMessages()

   // Service.deleteChat(chat1)
  // Service.printMessages()
   Service.printChats()
}