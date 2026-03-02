# 🎓 University Management System

REST API для управления университетской системой на Spring Boot с JPA и H2 Database.

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

## 🌐 Live Demo

**📖 Документация:** https://lidimitrii.github.io/midterm/

> ⚠️ **Важно:** GitHub Pages показывает только статическую документацию. Для запуска полнофункционального REST API следуйте [инструкциям по установке](#установка-и-запуск).

## 📋 О проекте

Полнофункциональная система управления университетом с поддержкой:
- **Студентов** с персональными профилями (связь One-to-One)
- **Курсов** с множественными уроками (связь One-to-Many)  
- **Назначения студентов на курсы** (связь Many-to-Many)
- Автоматического каскадного сохранения и удаления связанных данных

## 🗄️ Модель базы данных

```
Student (1) ←→ (1) StudentProfile
Student (M) ←→ (M) Course
Course (1) ←→ (M) Lesson
```

### Entities

| Entity | Поля | Связи |
|--------|------|-------|
| **Student** | id, firstName, lastName, email (unique) | @OneToOne с StudentProfile<br>@ManyToMany с Course |
| **StudentProfile** | id, address, phone, birthDate | @OneToOne с Student |
| **Course** | id, title, credits | @ManyToMany с Student<br>@OneToMany с Lesson |
| **Lesson** | id, topic, duration | @ManyToOne с Course |

## 🚀 Технологии

- **Java 17**
- **Spring Boot 3.2.0**
  - Spring Web
  - Spring Data JPA
- **H2 Database** (in-memory)
- **Lombok** (для уменьшения boilerplate кода)
- **Maven**

## ⚙️ Установка и запуск

### Предварительные требования
- Java 17 или выше
- Maven 3.6+ (или используйте встроенный в IDE)
- IntelliJ IDEA (рекомендуется)

### Быстрый старт

1. **Клонируйте репозиторий**
   ```bash
   git clone https://github.com/lidimitrii/midterm.git
   cd midterm
   ```

2. **Соберите проект**
   ```bash
   mvn clean install
   ```
   
   Или в IntelliJ IDEA:
   - View → Tool Windows → Maven
   - Нажмите 🔄 "Reload All Maven Projects"

3. **Установите Lombok Plugin** (для IntelliJ IDEA)
   - File → Settings → Plugins → Marketplace
   - Найдите "Lombok" → Install → Restart IDE

4. **Включите Annotation Processing**
   - File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors
   - ✓ Enable annotation processing → OK

5. **Запустите приложение**
   ```bash
   mvn spring-boot:run
   ```
   
   Или в IntelliJ IDEA:
   - Откройте `UniversityApplication.java`
   - ПКМ → Run 'UniversityApplication.main()'

6. **Откройте браузер**
   ```
   http://localhost:8080
   ```

## 🔌 REST API Endpoints

### Student API

#### Создать студента с профилем
```http
POST /students
Content-Type: application/json

{
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivan@example.com",
  "profile": {
    "address": "Москва, ул. Примерная, 1",
    "phone": "+7 999 123-45-67",
    "birthDate": "2000-01-15"
  }
}
```

#### Назначить студента на курс
```http
POST /students/{studentId}/courses/{courseId}
```

#### Получить студента
```http
GET /students/{id}
```

### Course API

#### Создать курс с уроками
```http
POST /courses
Content-Type: application/json

{
  "title": "Java Programming",
  "credits": 5,
  "lessons": [
    {
      "topic": "Introduction to Java",
      "duration": 90
    },
    {
      "topic": "OOP Principles",
      "duration": 120
    }
  ]
}
```

#### Добавить уроки к существующему курсу
```http
POST /courses/{courseId}/lessons
Content-Type: application/json

[
  {
    "topic": "Streams API",
    "duration": 90
  }
]
```

#### Получить курс
```http
GET /courses/{id}
```

## 🧪 Тестирование

Проект включает несколько способов тестирования API:

### 1. 🌐 HTML Web Interface
Откройте `test-interface.html` в браузере для визуального интерфейса тестирования.

### 2. 📝 HTTP Client (IntelliJ IDEA)
Используйте файл `api-test.http` для выполнения запросов прямо из IDE.

### 3. 💻 PowerShell Script
```powershell
.\quick-test.ps1
```

### 4. 🗄️ H2 Database Console
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:universitydb
Username: sa
Password: (оставьте пустым)
```

## 📁 Структура проекта

```
university-management-system/
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── UniversityApplication.java     # Main class
│   │   │   ├── entity/                         # JPA Entities
│   │   │   │   ├── Student.java
│   │   │   │   ├── StudentProfile.java
│   │   │   │   ├── Course.java
│   │   │   │   └── Lesson.java
│   │   │   ├── repository/                     # Spring Data JPA Repositories
│   │   │   │   ├── StudentRepository.java
│   │   │   │   ├── CourseRepository.java
│   │   │   │   └── LessonRepository.java
│   │   │   ├── service/                        # Business Logic
│   │   │   │   ├── StudentService.java
│   │   │   │   └── CourseService.java
│   │   │   ├── controller/                     # REST Controllers
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── StudentController.java
│   │   │   │   └── CourseController.java
│   │   │   └── dto/                            # Data Transfer Objects
│   │   │       ├── StudentRequest.java
│   │   │       └── CourseRequest.java
│   │   └── resources/
│   │       └── application.properties          # Configuration
│   └── test/
│       └── java/                               # Unit tests
├── index.html                                  # GitHub Pages documentation
├── test-interface.html                         # Web UI для тестирования
├── api-test.http                               # HTTP requests для IntelliJ
├── quick-test.ps1                              # PowerShell test script
├── pom.xml                                     # Maven configuration
└── README.md
```

## ✅ Реализованные требования

### Task 1: Entity Mapping ✓
- ✅ Все entity классы с правильными JPA аннотациями
- ✅ `@OneToOne` между Student и StudentProfile
- ✅ `@ManyToMany` между Student и Course
- ✅ `@OneToMany` / `@ManyToOne` между Course и Lesson
- ✅ Правильная настройка `mappedBy`, `@JoinColumn`, `@JoinTable`
- ✅ Cascade types настроены корректно
- ✅ Предотвращение бесконечной JSON рекурсии с помощью `@JsonManagedReference` и `@JsonBackReference`

### Task 2: Repository Layer ✓
- ✅ `StudentRepository extends JpaRepository<Student, Long>`
- ✅ `CourseRepository extends JpaRepository<Course, Long>`
- ✅ `LessonRepository extends JpaRepository<Lesson, Long>`
- ✅ Дополнительный метод `findByEmail()` в StudentRepository

### Task 3: Data Persistence Logic ✓
- ✅ Сохранение Student автоматически сохраняет StudentProfile (cascade)
- ✅ Назначение Student на Course с поддержкой bidirectional связи
- ✅ Добавление Lessons к Course с автоматическим сохранением
- ✅ Удаление Student автоматически удаляет Profile (orphanRemoval = true)
- ✅ При удалении Student данные Course остаются нетронутыми

### Task 4: REST API ✓
#### Student Controller
- ✅ `POST /students` - создание студента с профилем
- ✅ `POST /students/{studentId}/courses/{courseId}` - назначение студента на курс
- ✅ `GET /students/{id}` - получение студента со всеми связями

#### Course Controller
- ✅ `POST /courses` - создание курса с уроками
- ✅ `POST /courses/{courseId}/lessons` - добавление уроков к курсу
- ✅ `GET /courses/{id}` - получение курса со всеми уроками

## 📊 Примеры SQL запросов

```sql
-- Все студенты с профилями
SELECT s.*, sp.* 
FROM STUDENTS s 
LEFT JOIN STUDENT_PROFILES sp ON s.ID = sp.STUDENT_ID;

-- Студенты записанные на курсы
SELECT s.FIRST_NAME, s.LAST_NAME, c.TITLE
FROM STUDENTS s
JOIN STUDENT_COURSES sc ON s.ID = sc.STUDENT_ID
JOIN COURSES c ON c.ID = sc.COURSE_ID;

-- Курсы с количеством студентов
SELECT c.TITLE, COUNT(sc.STUDENT_ID) as STUDENT_COUNT
FROM COURSES c
LEFT JOIN STUDENT_COURSES sc ON c.ID = sc.COURSE_ID
GROUP BY c.ID, c.TITLE;

-- Все уроки для каждого курса
SELECT c.TITLE, l.TOPIC, l.DURATION
FROM COURSES c
LEFT JOIN LESSONS l ON c.ID = l.COURSE_ID
ORDER BY c.TITLE, l.ID;
```

## 🔧 Конфигурация

### application.properties
```properties
# H2 Database (In-Memory)
spring.datasource.url=jdbc:h2:mem:universitydb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Server
server.port=8080
```

## 🔍 Особенности реализации

### Cascade Operations
- **Student → StudentProfile**: `CascadeType.ALL` + `orphanRemoval = true`
- **Course → Lesson**: `CascadeType.ALL` + `orphanRemoval = true`
- **Student ↔ Course**: Без cascade (Many-to-Many)

### Bidirectional Relationships
Все двунаправленные связи реализованы с helper методами:
```java
// В Student.java
public void addCourse(Course course) {
    courses.add(course);
    course.getStudents().add(this);
}

// В Course.java
public void addLesson(Lesson lesson) {
    lessons.add(lesson);
    lesson.setCourse(this);
}
```

### JSON Serialization
Использование Jackson аннотаций для предотвращения бесконечной рекурсии:
- `@JsonManagedReference` - на стороне владельца связи
- `@JsonBackReference` - на обратной стороне связи

## 🐛 Решение проблем

| Проблема | Решение |
|----------|---------|
| `Cannot resolve symbol 'lombok'` | Установите Lombok Plugin в IntelliJ IDEA |
| `Cannot resolve symbol 'springframework'` | Reload Maven Project (View → Maven → 🔄) |
| `Port 8080 already in use` | Измените порт в `application.properties`: `server.port=8081` |
| Maven не загружает зависимости | Проверьте интернет, настройки proxy в Maven settings |
| Lombok не работает | Включите Annotation Processing в Settings → Compiler |

## 📝 Лицензия

Учебный проект. Свободно использовать в образовательных целях.

## 👤 Автор

**Dmitrii Li**
- GitHub: [@lidimitrii](https://github.com/lidimitrii)

---

⭐ **Если проект оказался полезным, поставьте звезду!**

🐛 **Нашли баг?** Создайте issue в GitHub.

💡 **Есть идеи по улучшению?** Pull requests приветствуются!

