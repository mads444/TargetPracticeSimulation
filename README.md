# 🎯 CSC110 Target Practice Simulation

**Developer:** Madison Crewse  
**Language:** Java  
**Date:** Spring 2025  

---

## 🧭 Overview
A console-based Java simulation where users aim at targets on a coordinate plane.  
The program calculates **distance**, **angle**, and **score** for each shot, providing interactive practice and analytics for target accuracy.

---

## 🧠 Features
- Simulates **target hits** on a 2D coordinate grid  
- Calculates **Euclidean distance** and **angle** from shot to target  
- Generates **score** based on proximity  
- Randomized target placement for variety  
- Menu-driven interface for clear user interaction  

---

## 🧰 Technologies Used
- Java SE  
- Math library (`Math.sqrt`, `Math.pow`, `Math.atan2`)  
- Random number generation  
- Modular programming with reusable functions  
- Console-based user interface  

---

## 💡 Skills Demonstrated
- Applied **coordinate geometry** and **trigonometry**  
- Implemented **randomized gameplay** and scoring system  
- Modular programming and clean code structure  
- Logical problem-solving and algorithmic thinking  

---

## 🧪 Distance & Scoring
- Distance between shot `(x1, y1)` and target `(x2, y2)`:
distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)

- Score decreases as distance from target increases.  
- Units: **grid units** (arbitrary, e.g., meters or units).  

---

## 🖼️ ASCII Visualization (Example)
y
10 | T
9 |
8 |
7 | *
6 |
5 |
4 |
3 |
2 |
1 |
+---------------- x
1 2 3 4 5 6 7 8 9 10

- `T` = Target position  
- `*` = User’s shot  
- Distance and score calculated based on this grid  

---

## 🧪 Example Output
Target at (5,7)
Enter your shot coordinates (x y): 4 6
Distance from target: 1.41 units
Score: 9 points

---

## 🚀 How to Run
1. Open a Java IDE (Eclipse, IntelliJ, VS Code).  
2. Copy `TargetPracticeSimulation.java` into your project folder.  
3. Compile and run:

```bash
javac TargetPracticeSimulation.java
java TargetPracticeSimulation

