import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'chat_detail_page.dart';
import '../database/database_services.dart';
import 'option_page.dart';

import 'package:easy_localization/easy_localization.dart';

class ChatPage extends StatefulWidget {
  @override
  _ChatPageState createState() => _ChatPageState();
}

class _ChatPageState extends State<ChatPage> {
  int _selectedIndex = 0;
  TextEditingController _searchController = TextEditingController();
  String _searchText = "";

  void _onItemTapped(int index) {
    if (index == 1) {
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => OptionPage()),
      );
    } else {
      setState(() {
        _selectedIndex = index;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('STRANGEVERSE'),
        backgroundColor: Color.fromARGB(255, 24, 119, 242),
        foregroundColor: Colors.white,
      ),
      body: _selectedIndex == 0 ? _buildChatList() : _buildOptions(),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.chat), label: 'Chats'.tr()),
          BottomNavigationBarItem(
            icon: Icon(Icons.settings),
            label: "options".tr(),
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.blue,
        unselectedItemColor: Colors.grey,
        onTap: _onItemTapped,
      ),
    );
  }

  // ✅ Chat List UI with Search Box
  Widget _buildChatList() {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(10.0),
          child: TextField(
            controller: _searchController,
            onChanged: (value) {
              setState(() {
                _searchText = value.trim().toLowerCase();
              });
            },
            decoration: InputDecoration(
              labelText: "Search User",
              prefixIcon: Icon(Icons.search),
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(10),
              ),
            ),
          ),
        ),
        Expanded(
          child: FutureBuilder<List<Map<String, dynamic>>>(
            future: DatabaseHelper().getProducts(),
            builder: (context, snapshot) {
              if (!snapshot.hasData || snapshot.data!.isEmpty) {
                return Center(child: Text("No Users Available"));
              }

              String currentUser = snapshot.data![0]['username'];

              return StreamBuilder(
                stream:
                    FirebaseFirestore.instance.collection('users').snapshots(),
                builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    return Center(child: CircularProgressIndicator());
                  }
                  if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
                    return Center(child: Text("No Users Found"));
                  }

                  // ✅ Filter users based on search input
                  var userDocs =
                      snapshot.data!.docs
                          .where(
                            (user) =>
                                user['username'] != currentUser &&
                                user['username'].toLowerCase().contains(
                                  _searchText,
                                ),
                          )
                          .toList();

                  return ListView.builder(
                    itemCount: userDocs.length,
                    itemBuilder: (context, index) {
                      var user = userDocs[index];
                      return Card(
                        margin: EdgeInsets.symmetric(
                          vertical: 5,
                          horizontal: 10,
                        ),
                        child: ListTile(
                          title: Text(
                            user['username'],
                            style: TextStyle(fontWeight: FontWeight.bold),
                          ),
                          subtitle: Text("Tap To Chat".tr()),
                          trailing: Icon(Icons.chat, color: Colors.blue),
                          onTap: () async {
                            String chatId = await _getOrCreateChat(
                              currentUser,
                              user['username'],
                            );
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder:
                                    (context) => ChatDetailPage(
                                      chatId: chatId,
                                      receiver: user['username'],
                                    ),
                              ),
                            );
                          },
                        ),
                      );
                    },
                  );
                },
              );
            },
          ),
        ),
      ],
    );
  }

  // ✅ Options UI
  Widget _buildOptions() {
    return Center(child: Text("Options Page (Settings, Profile, etc.)"));
  }

  // ✅ Get or Create Private Chat
  Future<String> _getOrCreateChat(String user1, String user2) async {
    QuerySnapshot querySnapshot =
        await FirebaseFirestore.instance
            .collection('chats')
            .where('participants', arrayContains: user1)
            .get();

    for (var doc in querySnapshot.docs) {
      var participants = List<String>.from(doc['participants']);
      if (participants.contains(user2)) {
        return doc.id;
      }
    }

    // ✅ Create new chat if it doesn't exist
    DocumentReference newChat = await FirebaseFirestore.instance
        .collection('chats')
        .add({
          'participants': [user1, user2],
          'lastMessage': '',
          'timestamp': FieldValue.serverTimestamp(),
        });

    return newChat.id;
  }
}
