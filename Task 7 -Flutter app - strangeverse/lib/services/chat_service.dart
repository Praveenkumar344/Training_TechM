import 'package:cloud_firestore/cloud_firestore.dart';

class ChatService {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  // ✅ Get or Create Private Chat
  Future<String> getOrCreateChat(String user1, String user2) async {
    QuerySnapshot querySnapshot =
        await _firestore
            .collection('chats')
            .where('participants', arrayContains: user1)
            .get();

    for (var doc in querySnapshot.docs) {
      var participants = List<String>.from(doc['participants']);
      if (participants.contains(user2)) {
        return doc.id;
      }
    }

    // ✅ Create new chat
    DocumentReference newChat = await _firestore.collection('chats').add({
      'participants': [user1, user2],
      'lastMessage': '',
      'timestamp': FieldValue.serverTimestamp(),
    });

    return newChat.id;
  }

  // ✅ Send a Private Message
  Future<void> sendMessage(
    String chatId,
    String sender,
    String receiver,
    String message,
  ) async {
    await _firestore
        .collection('chats')
        .doc(chatId)
        .collection('messages')
        .add({
          'sender': sender,
          'receiver': receiver,
          'text': message,
          'timestamp': FieldValue.serverTimestamp(),
        });

    // Update last message
    await _firestore.collection('chats').doc(chatId).update({
      'lastMessage': message,
      'timestamp': FieldValue.serverTimestamp(),
    });
  }

  // ✅ Get Messages for a Private Chat
  Stream<QuerySnapshot> getMessages(String chatId) {
    return _firestore
        .collection('chats')
        .doc(chatId)
        .collection('messages')
        .orderBy('timestamp', descending: true)
        .snapshots();
  }
}
