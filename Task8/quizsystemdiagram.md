---
title: Online Quiz System - UML & ER Diagrams
mermaid:
  theme: default
---

## Class Diagram (Core)

```mermaid
classDiagram
    class User {
        +int userId
        +string username
        +string email
        +enum role (Student, Instructor)
        +Date createdAt
        +login()
        +viewAttempts()
    }
    class Quiz {
        +int quizId
        +string title
        +string description
        +int creatorId
        +int durationMinutes
        +bool isPublished
        +calculateScore()
    }
    class Question {
        +int questionId
        +int quizId
        +string questionText
        +enum type (MCQ, TrueFalse, ShortAnswer)
        +int points
    }
    class Option {
        +int optionId
        +int questionId
        +string optionText
        +bool isCorrect
    }
    class Attempt {
        +int attemptId
        +int userId
        +int quizId
        +Date startTime
        +Date endTime
        +float finalScore
        +getStatus()
    }
    class Response {
        +int responseId
        +int attemptId
        +int questionId
        +int selectedOptionId
        +string textAnswer
    }
