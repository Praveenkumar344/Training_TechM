import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:strangeverse/pages/chat_page.dart';
import './register_page.dart';
import '../database/database_services.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _username = TextEditingController();
  final _password = TextEditingController();
  String? _errorMessage; // To display login errors

  @override
  void initState() {
    super.initState();
    _checkLogIn(); // ✅ Check if user is already logged in
  }

  Future<void> _checkLogIn() async {
    List<Map<String, dynamic>> rows = await DatabaseHelper().getProducts();
    if (rows.isNotEmpty) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => ChatPage()),
      );
    }
  }

  Future<void> _login(BuildContext context) async {
    try {
      QuerySnapshot querySnapshot =
          await FirebaseFirestore.instance
              .collection('users')
              .where('username', isEqualTo: _username.text)
              .where('password', isEqualTo: _password.text)
              .get();

      if (querySnapshot.docs.isNotEmpty) {
        await DatabaseHelper().deleteAllDetails();
        await DatabaseHelper().insertdetails({
          'username': _username.text,
          'password': _password.text,
        });

        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => ChatPage()),
        );
      } else {
        setState(() {
          _errorMessage = "Invalid username or password!";
        });
      }
    } catch (e) {
      setState(() {
        _errorMessage = "Error: ${e.toString()}";
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
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Image.asset('lib/assets/icon_96.png', width: 100, height: 100),

            Text(
              'WELCOME TO STRANGEVERSE',
              style: TextStyle(
                fontSize: 19,
                fontWeight: FontWeight.w600,
                color: Color.fromARGB(255, 39, 120, 213),
              ),
            ),

            SizedBox(height: 40),

            // Username Field
            SizedBox(
              width: 350,
              child: TextFormField(
                controller: _username,
                decoration: InputDecoration(
                  labelText: 'User Name',
                  border: OutlineInputBorder(),
                  focusedBorder: OutlineInputBorder(
                    borderSide: BorderSide(
                      color: Color.fromARGB(255, 39, 120, 213),
                      width: 2,
                    ),
                  ),
                ),
              ),
            ),
            SizedBox(height: 20),

            // Password Field
            SizedBox(
              width: 350,
              child: TextFormField(
                controller: _password,
                obscureText: true,
                decoration: InputDecoration(
                  labelText: 'Password',
                  border: OutlineInputBorder(),
                  focusedBorder: OutlineInputBorder(
                    borderSide: BorderSide(
                      color: Color.fromARGB(255, 39, 120, 213),
                      width: 2,
                    ),
                  ),
                ),
              ),
            ),

            SizedBox(height: 10),

            // Show error message if login fails
            if (_errorMessage != null)
              Text(
                _errorMessage!,
                style: TextStyle(color: Colors.red, fontSize: 14),
              ),

            SizedBox(height: 20),

            // Login Button
            ElevatedButton(
              onPressed: () => _login(context),
              style: ElevatedButton.styleFrom(
                backgroundColor: Color.fromARGB(255, 41, 136, 245),
                foregroundColor: Colors.white,
                padding: EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              child: Text('LOGIN'),
            ),

            SizedBox(height: 15),

            SizedBox(
              height: 1.5,
              width: 200,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: Color.fromARGB(255, 131, 131, 133),
                ),
              ),
            ),

            SizedBox(height: 15),

            // Register Button
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => RegisterPage()),
                );
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Color.fromARGB(255, 41, 136, 245),
                foregroundColor: Colors.white,
                padding: EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              child: Text('REGISTER'),
            ),
          ],
        ),
      ),
    );
  }
}
