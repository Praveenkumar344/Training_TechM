import 'package:flutter/material.dart';
import 'package:easy_localization/easy_localization.dart';

class Langpage extends StatefulWidget {
  @override
  _LangpageState createState() => _LangpageState();
}

class _LangpageState extends State<Langpage> {
  Locale _selectedLocale = Locale('en', 'US'); // Default to English

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    _selectedLocale = context.locale; // ✅ Move here instead of initState()
  }

  void _changeLanguage(Locale locale) {
    setState(() {
      _selectedLocale = locale;
      context.setLocale(locale);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Language Selection'.tr()),
        backgroundColor: Color.fromARGB(255, 24, 119, 242),
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              "Select Language".tr(),
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),

            _buildLanguageButton("English", Locale('en', 'US')),
            _buildLanguageButton("தமிழ் (Tamil)", Locale('ta', 'IN')),
            _buildLanguageButton("తెలుగు (Telugu)", Locale('te', 'IN')),
            _buildLanguageButton("ಕನ್ನಡ (Kannada)", Locale('kn', 'IN')),
            _buildLanguageButton("हिन्दी (Hindi)", Locale('hi', 'IN')),
          ],
        ),
      ),
    );
  }

  Widget _buildLanguageButton(String language, Locale locale) {
    bool isSelected = _selectedLocale == locale; // ✅ Check if selected

    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 5),
      child: ElevatedButton(
        onPressed: () => _changeLanguage(locale),
        style: ElevatedButton.styleFrom(
          backgroundColor:
              isSelected
                  ? Colors.blue
                  : Colors.grey[300], // ✅ Highlight selection
          foregroundColor: isSelected ? Colors.white : Colors.black,
        ),
        child: Text(language),
      ),
    );
  }
}
