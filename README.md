Multi-tool Calculator
A versatile and user-friendly desktop calculator application built with Java Swing. This project provides a standard calculator for everyday arithmetic operations, along with a suite of powerful unit converters accessible through a convenient menu.
!
🚀 Features
-Standard Calculator: Perform basic arithmetic operations like addition, subtraction, multiplication, and division.
-Intuitive Interface: A clean, straightforward layout for ease of use.
-Built-in Unit Converters: A collection of tools for various conversions, each in its own dedicated window.
📏 Length Converter: Convert between meters, kilometers, miles, feet, and inches.
✈️ Speed Converter: Switch between m/s, km/h, mph, and knots.
🌡️ Temperature Converter: Convert between Celsius, Fahrenheit, and Kelvin.
💾 Data Storage Converter: Convert between Bytes, KB, MB, GB, and TB.
⚖️ Weight Converter: Convert between kilograms, grams, pounds, and ounces.
⏳ Time Converter: Convert between seconds, minutes, hours, and days.
-Modular Codebase: The project is organized into separate classes for each tool, making it easy to manage, debug, and extend.
🛠️ Technologies Used
Core: Java
UI: Java Swing for the graphical user interface.
📋 Prerequisites
Before you begin, ensure you have the Java Development Kit (JDK) installed on your system. You can verify your installation by opening a terminal or command prompt and running:
java -version
javac -version


⚙️ Getting Started
Follow these steps to compile and run the application on your local machine.
1. File Structure
Ensure all the project's .java files are located within a multitoolcalculator package folder. Your directory structure should look like this:
<your_project_folder>/
└── multitoolcalculator/
    ├── DataConverter.java
    ├── LengthConverter.java
    ├── MultiToolCalculator.java
    ├── SpeedConverter.java
    ├── TemperatureConverter.java
    ├── TimeConverter.java
    └── WeightConverter.java


2. Compilation
Open a terminal or command prompt.
Navigate to the root directory of the project (the folder containing the multitoolcalculator folder).
cd path/to/your_project_folder


Compile all the Java source files. This command will create the necessary .class files, maintaining the package structure.
javac multitoolcalculator/*.java -d .


3. Execution
From the same root directory, run the main application class using its fully qualified name:
java multitoolcalculator.MultiToolCalculator


The main calculator window will launch.
📖 How to Use
Use the number and operator buttons on the main window for standard calculations.
Click on the "Calculation Tools" menu at the top of the window.
Select any converter from the dropdown list (e.g., "Length Converter").
A new window for that specific tool will open. You can use it independently and close it without affecting the main calculator.
🤝 Contributing
Contributions are welcome! If you have suggestions for improvements or want to add new features (like more converters), feel free to fork the repository and submit a pull request.
Fork the Project
Create your Feature Branch (git checkout -b feature/NewConverter)
Commit your Changes (git commit -m 'Add some NewConverter')
Push to the Branch (git push origin feature/NewConverter)
Open a Pull Request
📄 License
This project is licensed under the MIT License - see the LICENSE.md file for details (you can create this file if you wish).
