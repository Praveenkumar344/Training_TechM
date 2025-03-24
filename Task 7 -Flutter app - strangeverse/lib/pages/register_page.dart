import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import './login_page.dart';
import '../database/database_services.dart';

class RegisterPage extends StatefulWidget {
  @override
  _RegisterPageState createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  final _username = TextEditingController();
  final _password = TextEditingController();
  final _confirmPassword = TextEditingController();
  String? _errorMessage; // To display validation errors

  // Function to save user data in Firestore
  Future<void> _registerUser(BuildContext context) async {
    if (_username.text.isEmpty ||
        _password.text.isEmpty ||
        _confirmPassword.text.isEmpty) {
      setState(() {
        _errorMessage = "All fields are required!";
      });
      return;
    }

    if (_password.text != _confirmPassword.text) {
      setState(() {
        _errorMessage = "Passwords do not match!";
      });
      return;
    }

    try {
      await FirebaseFirestore.instance.collection('users').add({
        'username': _username.text,
        'password': _password.text,
      });
      // Navigate to Chat Page after successful registration
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => LoginPage()),
      );
    } catch (e) {
      setState(() {
        _errorMessage = "Failed to register. Try again.";
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
        child: SingleChildScrollView(
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

              // Username
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

              // Password
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
              SizedBox(height: 20),

              // Confirm Password
              SizedBox(
                width: 350,
                child: TextFormField(
                  controller: _confirmPassword,
                  obscureText: true,
                  decoration: InputDecoration(
                    labelText: 'Confirm Password',
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

              // Show error message if any
              if (_errorMessage != null)
                Text(
                  _errorMessage!,
                  style: TextStyle(color: Colors.red, fontSize: 14),
                ),

              SizedBox(height: 20),

              // Register Button
              ElevatedButton(
                onPressed: () => _registerUser(context),
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
      ),
    );
  }
}
