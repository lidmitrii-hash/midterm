# 📤 КАК ЗАГРУЗИТЬ ПРОЕКТ НА GITHUB

## ❗ ВАЖНО: Git не установлен на вашем компьютере

Сначала нужно установить Git, затем загрузить проект на GitHub.

---

## ВАРИАНТ 1: Через GitHub Desktop (РЕКОМЕНДУЕТСЯ - САМЫЙ ПРОСТОЙ)

### Шаг 1: Установите GitHub Desktop

1. Перейдите на: https://desktop.github.com/
2. Скачайте и установите GitHub Desktop для Windows
3. Запустите программу
4. Войдите в свой GitHub аккаунт (или создайте новый на github.com)

### Шаг 2: Добавьте проект

1. В GitHub Desktop нажмите: **File** → **Add Local Repository**
2. Выберите папку: `C:\Users\dmitrii.li\OneDrive\Desktop\midterm`
3. Если появится "This directory does not appear to be a Git repository":
   - Нажмите **"Create a repository"**
   - Name: `university-management-system`
   - Description: `REST API для управления университетской системой на Spring Boot`
   - ✓ Initialize this repository with a README (снимите галочку, у нас уже есть README)
   - Нажмите **Create Repository**

### Шаг 3: Сделайте первый коммит

1. В GitHub Desktop увидите список файлов
2. Внизу слева в поле "Summary" введите: `Initial commit - University Management System`
3. Нажмите **Commit to main**

### Шаг 4: Опубликуйте на GitHub

1. Нажмите кнопку **Publish repository** вверху
2. Выберите настройки:
   - Name: `university-management-system`
   - Description: `REST API для управления университетской системой`
   - ☐ Keep this code private (снимите галочку для публичного репозитория)
3. Нажмите **Publish Repository**

### ✅ ГОТОВО!

Ваш проект теперь на GitHub!
URL будет: `https://github.com/ВАШ_USERNAME/university-management-system`

---

## ВАРИАНТ 2: Через командную строку (для продвинутых)

### Шаг 1: Установите Git

1. Скачайте Git: https://git-scm.com/download/win
2. Запустите установщик
3. Используйте настройки по умолчанию
4. После установки перезапустите PowerShell

### Шаг 2: Настройте Git

```powershell
# Укажите ваше имя и email
git config --global user.name "Ваше Имя"
git config --global user.email "your.email@example.com"
```

### Шаг 3: Инициализируйте репозиторий

```powershell
cd C:\Users\dmitrii.li\OneDrive\Desktop\midterm

# Инициализация Git репозитория
git init

# Добавьте все файлы
git add .

# Первый коммит
git commit -m "Initial commit - University Management System"
```

### Шаг 4: Создайте репозиторий на GitHub

1. Перейдите на https://github.com
2. Нажмите **New repository** (зелёная кнопка)
3. Заполните:
   - Repository name: `university-management-system`
   - Description: `REST API для управления университетской системой на Spring Boot`
   - ☐ Public (для публичного доступа)
   - ☐ НЕ добавляйте README, .gitignore, license (у нас уже есть)
4. Нажмите **Create repository**

### Шаг 5: Загрузите код на GitHub

```powershell
# Добавьте удалённый репозиторий (замените YOUR_USERNAME на ваш GitHub username)
git remote add origin https://github.com/YOUR_USERNAME/university-management-system.git

# Переименуйте ветку в main (если нужно)
git branch -M main

# Загрузите код
git push -u origin main
```

### ✅ ГОТОВО!

Обновите страницу GitHub - ваш проект загружен!

---

## ВАРИАНТ 3: Через IntelliJ IDEA (если есть Git)

### Шаг 1: Включите Git в проекте

1. VCS → Enable Version Control Integration
2. Выберите **Git** → OK

### Шаг 2: Добавьте файлы

1. VCS → Git → Add
2. Выберите все файлы

### Шаг 3: Сделайте коммит

1. VCS → Commit (или Ctrl+K)
2. Выберите все файлы
3. Commit message: `Initial commit - University Management System`
4. Нажмите **Commit**

### Шаг 4: Добавьте GitHub репозиторий

1. VCS → Git → Push (или Ctrl+Shift+K)
2. Нажмите **Define remote**
3. Введите URL: `https://github.com/YOUR_USERNAME/university-management-system.git`
4. Нажмите **Push**

---

## 📝 КАКИЕ ФАЙЛЫ БУДУТ ЗАГРУЖЕНЫ

### Основные файлы проекта:
✅ `src/` - весь исходный код
✅ `pom.xml` - Maven конфигурация
✅ `test-interface.html` - веб-интерфейс для тестирования
✅ `api-test.http` - HTTP запросы
✅ `quick-test.ps1` - PowerShell тест скрипт
✅ `README.md` - документация
✅ `.gitignore` - список игнорируемых файлов

### Что НЕ будет загружено (указано в .gitignore):
❌ `target/` - скомпилированные файлы
❌ `.idea/` - настройки IntelliJ IDEA
❌ `*.iml` - модули IDEA
❌ Локальные файлы документации

---

## 🎯 РЕКОМЕНДАЦИИ ДЛЯ GITHUB

### 1. Добавьте бейдж с технологиями

Уже добавлено в README_GITHUB.md:
```markdown
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
```

### 2. Добавьте скриншоты

Сделайте скриншот веб-интерфейса (test-interface.html) и добавьте в README:
```markdown
## 📸 Скриншоты

![Main Interface](screenshots/main-interface.png)
```

### 3. Создайте releases

После загрузки на GitHub:
1. Перейдите в **Releases** → **Create a new release**
2. Tag: `v1.0.0`
3. Title: `University Management System v1.0`
4. Опубликуйте

---

## 🔄 КАК ОБНОВИТЬ ПРОЕКТ НА GITHUB

После внесения изменений в код:

### Через GitHub Desktop:
1. Откройте GitHub Desktop
2. Увидите изменённые файлы
3. Введите описание изменений
4. Нажмите **Commit to main**
5. Нажмите **Push origin**

### Через командную строку:
```powershell
git add .
git commit -m "Описание изменений"
git push
```

---

## ❓ ЧАСТЫЕ ВОПРОСЫ

### Q: Нужно ли загружать файл .idea/?
**A:** Нет, он уже в .gitignore. Это личные настройки IDE.

### Q: Можно ли сделать репозиторий приватным?
**A:** Да, при создании репозитория выберите "Private".

### Q: Как добавить соавторов?
**A:** Settings → Collaborators → Add people

### Q: Что делать, если появляется ошибка "remote origin already exists"?
**A:** Используйте `git remote set-url origin https://github.com/YOUR_USERNAME/university-management-system.git`

---

## 🎉 ПОСЛЕ ЗАГРУЗКИ

1. **Поделитесь ссылкой** на репозиторий с преподавателем
2. **Добавьте описание** в профиле GitHub
3. **Включите GitHub Pages** (если хотите хостить документацию)
4. **Добавьте topics**: java, spring-boot, rest-api, jpa, hibernate

---

**📌 ВАЖНО: Я РЕКОМЕНДУЮ ВАРИАНТ 1 (GitHub Desktop) - это самый простой и визуальный способ!**

Ссылка для скачивания: https://desktop.github.com/

