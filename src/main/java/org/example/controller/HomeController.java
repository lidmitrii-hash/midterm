package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
                <!DOCTYPE html>
                <html lang="ru">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>University Management System</title>
                    <style>
                        * { margin: 0; padding: 0; box-sizing: border-box; }
                        body {
                            font-family: 'Segoe UI', sans-serif;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            min-height: 100vh;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            padding: 20px;
                        }
                        .container {
                            background: white;
                            border-radius: 20px;
                            padding: 50px;
                            max-width: 800px;
                            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
                        }
                        h1 {
                            color: #667eea;
                            font-size: 2.5em;
                            margin-bottom: 20px;
                            text-align: center;
                        }
                        .status {
                            background: #d1fae5;
                            color: #065f46;
                            padding: 15px;
                            border-radius: 10px;
                            margin-bottom: 30px;
                            text-align: center;
                            font-weight: bold;
                        }
                        .endpoints {
                            margin: 30px 0;
                        }
                        .endpoints h2 {
                            color: #374151;
                            margin-bottom: 15px;
                        }
                        .endpoint {
                            background: #f9fafb;
                            padding: 12px;
                            margin: 8px 0;
                            border-radius: 5px;
                            font-family: monospace;
                            border-left: 4px solid #667eea;
                        }
                        .method {
                            display: inline-block;
                            padding: 4px 8px;
                            border-radius: 3px;
                            font-weight: bold;
                            margin-right: 10px;
                        }
                        .post { background: #10b981; color: white; }
                        .get { background: #3b82f6; color: white; }
                        .links {
                            margin-top: 30px;
                            text-align: center;
                        }
                        .btn {
                            display: inline-block;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            color: white;
                            padding: 15px 30px;
                            border-radius: 10px;
                            text-decoration: none;
                            margin: 10px;
                            font-weight: bold;
                            transition: transform 0.2s;
                        }
                        .btn:hover {
                            transform: translateY(-2px);
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>🎓 University Management System</h1>
                        
                        <div class="status">
                            ✓ Сервер работает успешно!
                        </div>
                        
                        <div class="endpoints">
                            <h2>📋 Student API</h2>
                            <div class="endpoint">
                                <span class="method post">POST</span>
                                <span>/students</span> - Создать студента
                            </div>
                            <div class="endpoint">
                                <span class="method post">POST</span>
                                <span>/students/{studentId}/courses/{courseId}</span> - Назначить на курс
                            </div>
                            <div class="endpoint">
                                <span class="method get">GET</span>
                                <span>/students/{id}</span> - Получить студента
                            </div>
                        </div>
                        
                        <div class="endpoints">
                            <h2>📚 Course API</h2>
                            <div class="endpoint">
                                <span class="method post">POST</span>
                                <span>/courses</span> - Создать курс
                            </div>
                            <div class="endpoint">
                                <span class="method post">POST</span>
                                <span>/courses/{courseId}/lessons</span> - Добавить уроки
                            </div>
                            <div class="endpoint">
                                <span class="method get">GET</span>
                                <span>/courses/{id}</span> - Получить курс
                            </div>
                        </div>
                        
                        <div class="links">
                            <a href="/h2-console" class="btn">🗄️ База данных H2</a>
                        </div>
                        
                        <div style="margin-top: 30px; text-align: center; color: #6b7280; font-size: 14px;">
                            <p>Для тестирования API используйте:</p>
                            <p style="font-family: monospace; margin-top: 10px;">
                                test-interface.html или api-test.http
                            </p>
                        </div>
                    </div>
                </body>
                </html>
                """;
    }
}

