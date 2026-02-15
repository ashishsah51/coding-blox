# 🚀 CODING BLOX

Coding Blox is an Online Coding Platform that allows a user to Sign Up, Create Contests, and participate in Contests hosted by others.

Each contest has a difficulty level (LOW, MEDIUM, HIGH) and contains a set of questions.

Each question has:
- Difficulty Level (LOW, MEDIUM, HIGH)
- Score

Based on the contest level, the question set is decided:
- LOW contest → only LOW questions
- MEDIUM contest → only MEDIUM questions
- HIGH contest → only HIGH questions

Users solve problems and earn points. After a contest ends, user scores are updated based on contest difficulty.

---

# 📌 CORE FUNCTIONALITIES

---

## 👤 Create User

Command:
```
CreateUser <user_name>
```

- Registers a new user
- Default score = 1500

Example:
```
CreateUser Ross
CreateUser Monica
CreateUser Joey
CreateUser Chandler
```

---

## 📝 Create Question

Command:
```
CreateQuestion <difficulty_level> <score>
```

- QuestionId auto-increments starting from 1

Example:
```
CreateQuestion LOW 10
CreateQuestion MEDIUM 20
CreateQuestion HIGH 50
```

---

## 📋 List Question

Command:
```
ListQuestion <difficulty_level>
```

- If difficulty_level is provided → show only that level
- If not provided → show all questions

Example:
```
ListQuestion
ListQuestion LOW
```

---

## 🏆 Create Contest

Command:
```
CreateContest <contest_name> <contest_level> <contest_creator_user_name>
```

Example:
```
CreateContest diwali_contest LOW Ross
```

Rules:
- ContestId auto-increments starting from 1
- Contest creator automatically participates
- Question list is independent of contest
- Questions selected based on contest difficulty level

---

## 📜 List Contest

Command:
```
ListContest <difficulty_level>
```

- If difficulty_level provided → filter by level
- Otherwise → show all contests

Example:
```
ListContest
ListContest LOW
```

---

## 🎯 Attend Contest

Command:
```
AttendContest <contest_id> <user_name>
```

Example:
```
AttendContest 1 Monica
AttendContest 1 Joey
```

Note:
- Contest creator automatically attends

---

## ▶️ Run Contest

Command:
```
RunContest <contest_id> <contest_creator_user_name>
```

Example:
```
RunContest 1 Ross
```

Rules:
- Only contest creator can start the contest
- Random questions solved are generated per user
- Score updated based on contest difficulty

Example solved output:
```
Ross   : 1,3,5
Monica : 1,6,3
Joey   : 2,4,6
```

---

# 🧮 SCORING LOGIC

Let:

```
currentContestPoints = Sum of scores of solved questions
```

Final Score Calculation:

- LOW:
```
newScore = currentScore + (currentContestPoints - 50)
```

- MEDIUM:
```
newScore = currentScore + (currentContestPoints - 30)
```

- HIGH:
```
newScore = currentScore + currentContestPoints
```

---

## 🏅 LeaderBoard

Command:
```
LeaderBoard <sorting_order>
```

Example:
```
LeaderBoard score desc
```

Example Output:
```
Joey   : 1515
Ross   : 1485
Monica : 1475
```

---

## 📊 Contest History (Bonus)

Command:
```
ContestHistory <contest_id>
```

Example:
```
ContestHistory 1
```

Example Output:
```
Joey   : 65 [2,4,6]
Ross   : 35 [1,3,5]
Monica : 25 [1,3,6]
```

Shows:
- User Name
- Points Secured
- Questions Solved

---

## ❌ Withdraw Contest (Bonus)

Command:
```
WithdrawContest <contest_id> <username>
```

Example:
```
WithdrawContest 1 Joey
```

Rules:
- Allowed only before RunContest executes
- Contest creator cannot withdraw

---

# 🏗️ DESIGN EXPECTATIONS

- Sample data should be created manually (file, test case, or main driver program)
- Code must be demoable
- Code should be modular
- Follow proper Object-Oriented Design
- Separate responsibilities across classes
- Code must be extensible
- Use interfaces where applicable
- Follow DRY principle
- Handle edge cases gracefully
- Code must be readable and clean

---

# 📐 GUIDELINES

- Do not access the internet except for syntax
- Use any programming language of your choice
- All work must be original
- Code should be easy to extend without rewriting the system

---

# 🎯 GOAL

Design and implement Coding Blox as a modular, extensible, and well-structured platform supporting:

- User management
- Contest lifecycle
- Question management
- Score calculation
- Leaderboard generation
- Contest history tracking
- Withdrawal functionality
