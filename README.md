Разработка REST API на Spring MVC + Boot
========================================
18 ак. ч., 6 дней.


Современный гибкий и тестопригодный дизайн
------------------------------------------
- [ ] Внутренняя модель качества
- [ ] OOAD как ответ на запрос бизнеса
- [ ] Пример процедурного legacy-кода и вопросы сопровождаемости
- [ ] Инкапсуляция
- [ ] Полиморфизм и абстракции
- [ ] Повторное использование и наследование/делегирование 
- [ ] Spring-ready архитектура
- [ ] Зависимости компонентов: порождающие шаблоны
- [ ] Слои

Live coding demo
----------------
- [ ] Рефакторинг процедурного legacy-кода
- [ ] DI
- [ ] Layered Design

Введение в Spring Core container и чем он помогает разработчику
---------------------------------------------------------------
- [ ] [Понятие фреймворка](https://www.programcreek.com/2011/09/what-is-the-difference-between-a-java-library-and-a-framework/) и [контейнеров](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-basics)
- [ ] Управление жизненным циклом компонентов
- [ ] Spring Core как [DI](https://en.wikipedia.org/wiki/Dependency_injection) Framework
- [ ] Разрешение зависимостей через DI и их контекстная подмена
- [ ] Понятие [конфигурации](https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm) и [контекста](https://spring.io/understanding/application-context)
- [ ] Концепция AOP и реализация ключевых задач фреймворка с помощью proxies
- [ ] Обзор [модулей Spring](https://docs.spring.io/spring-framework/docs/5.0.0.RC3/spring-framework-reference/overview.html#overview-modules)
- [ ] Поддержка в IDEA Ultimate
- [ ] Что дает Spring Boot

Live coding demo
----------------
- Обзор [зависимостей](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/overview.html#dependency-management) и структуры типового Spring Application
- [Компоненты/бины](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-basics), неявный аспект их именования
- Сборка и запуск приложения

Practice Iteration
------------------
- [ ] Анализ Spring CRUD REST API application
- [ ] Сборка и запуск
- [ ] Анализ API с помощью Swagger UI

Конфигурация приложения
-----------------------
- Способы конфигурирования: [java](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-annotation-config), [xml, groovy](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-basics)
- [Структура конфигурации](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-basics)
- [Декларация компонентов](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-definition)
- [Инициализация компонентов](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-class)
- [Внедрение зависимостей](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-dependencies)
- [Жизненный цикл компонентов и Scopes](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-factory-scopes)
- [SpEL](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#expressions)
- [Валидация данных модели](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#validation-beanvalidation-overview)
- [Профили](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-definition-profiles)

Жизненный цикл компонентов Spring и их вызовы
---------------------------------------------
- [ ] Управляемые компоненты и proxies
- [ ] Lazy-инициализация компонентов
- [ ] События жизненного цикла компонента и их обработчики @PostConstruct и @PreDestroy
- [ ] [Обзор AOP](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop)
- [ ] Управление безопасностью
- [ ] Управление транзакциями
- [ ] Управление повторами операций
- [ ] Управление асинхронностью
- [ ] Управление кешированием
- [ ] Ресурсы как частный случай компонентов

<details>
<summary>Corner Cases for Bean declaration and initialization</summary>

Type Switching anti-pattern
---------------------------
- [ ] @Primary
- [ ] @Qualifier("id")

Declaration
-----------
- [ ] Два бина с одинаковым id в одной секции beans – ошибка инициалиазации контекста
- [ ] Два бина с одинаковым id в разных секциях beans (два xml или профили в одном xml): последний заданный overrides первый
- [ ] Бин, заданный в xml без id, ищется только по типу
- [ ] Бин, заданный в xml без id, не инъектируется @Autowired. Надо ref в xml
- [ ] Бин, заданный как @Component, автоматом получает id. @Component("newId") _переопределяет_ дефолтный id
- [ ] Бин с дублирующимся id, определенный в xml, overrides бин, заданный как @Component
- [ ] Бин с дублирующимся id, определенный в @Configuration, overrides бин, заданный как @Component
- [ ] Бин с дублирующимся id, определенный в @Configuration и xml – берется из xml, skipping определение из @Configuration
- [ ] Бин с дублирующимся id, определенный в @Configuration, xml и как @Component – берется из xml, skipping определение из @Configuration

Initialization
--------------
- [ ] Eager service1 depending on eager service2
```
23:25:10.331 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service1'
23:25:10.346 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
......context loaded and prepared......
Getting service1
Got service1
Result of service1's operation call: 84
```

- [ ] Lazy service1 depending on eager service2
```
23:26:00.941 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
......context loaded and prepared......
Getting service1
23:26:00.966 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service1'
Got service1
Result of service1's operation call: 84
```

- [ ] Eager service1 depending on lazy service2
```
23:26:51.508 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service1'
23:26:51.524 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
......context loaded and prepared......
Getting service1
Got service1
Result of service1's operation call: 84
```

- [ ] Lazy service1 depending on lazy service2
```
......context loaded and prepared......
Getting service1
23:27:41.133 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service1'
23:27:41.146 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
Got service1
Result of service1's operation call: 84
```

Scopes
------
- [ ] Singleton service1 depending on singleton service2
```
23:45:54.740 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service1'
S1 object constructor
23:45:54.773 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
S2 object constructor
......context loaded and prepared......
Getting service1
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
Getting service1
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
```

- [ ] Singleton service1 depending on prototype service2
```
S1 object constructor
S2 object constructor
......context loaded and prepared......
Getting service1
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
Getting service1
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
```

- [ ] Prototype service1 depending on singleton service2
```
23:47:43.826 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'service2'
S2 object constructor
......context loaded and prepared......
Getting service1
S1 object constructor
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
Getting service1
S1 object constructor
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
```

- [ ] Prototype service1 depending on Prototype service2
```
......context loaded and prepared......
Getting service1
S1 object constructor
S2 object constructor
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
Getting service1
S1 object constructor
S2 object constructor
Got service1
Result of service1's operation call: 84
Result of service1's operation call: 84
```
</details>

Введение в протокол HTTP
------------------------
- [ ] Задачи и ограничения протокола HTTP
- [ ] Методы запросов
- [ ] Заголовки
- [ ] Статусы ответов
- [ ] Параметры и аргументы запросов
- [ ] Cookies
- [ ] Реализация веб-сессии

Live coding demo
----------------
- [ ] Демо протокола HTTP
- [ ] Отладка HTTP-запросов и ответов в браузере

JavaEE web-приложения
---------------------
- [ ] Web-контейнеры
- [ ] Структура Java EE web-приложений
- [ ] Компоненты веб-приложения
- [ ] Управляемые объекты

Live coding demo
----------------
- [ ] Отладка REST-запросов и ответов в REST-клиенте (IDEA plugin)
- [ ] Демо контейнера Tomcat
- [ ] Сборка и развертывание демо-приложения на web-контейнере

Концепция REST API и Spring RESTful Services
--------------------------------------------
- [ ] Сравнение RPC и REST
- [ ] Гайдлайны REST API
- [ ] REST-клиенты
- [ ] Архитектура MVC и ее редукция для REST API
- [ ] Spring MVC для реализации REST API
- [ ] Контроллеры
- [ ] JSON-сериализация данных
- [ ] Два способа сборки и запуска веб-приложения REST API: Spring MVC и Spring Boot

Live coding demo
----------------
- [ ] Разработка простого REST-контроллера
- [ ] Сборка и развертывание приложения
- [ ] Вызовы из REST-клиента

Practice Iteration
------------------
- [ ] Афиширование Spring CRUD через REST API
- [ ] Сборка и запуск
- [ ] Анализ запросов и ответов в REST-клиенте

Spring Boot
-----------
- [ ] Задачи Boot
- [ ] Модули
- [ ] Подключение модулей

Доступ к данным
---------------
- [ ] Тестовые и production конфигурации РСУБД источников данных
- [ ] Понятие Connection Pool
- [ ] Spring Data JPA
- [ ] Обзор JPA Entities и Persistence Contexts
- [ ] Провиженинг схемы БД при изменениях структур данных

Live coding demo
----------------
- [ ] CRUD App with JPA Repositories

Production-ready REST API
-------------------------
- [ ] Версионирование REST API
- [ ] Аутентификация
- [ ] Авторизация
- [ ] Cериализация ошибок
- [ ] Документация на Swagger
- [ ] Усложненная JSON-сериализация java-объектов

Practice Iteration
------------------
- [ ] Рефакторинг приложения до уровня production-ready
- [ ] Документирование API на Swagger

Микро-сервисная архитектура
---------------------------
- [ ] Микро-сервисная архитектура
- [ ] Архитектурные шаблоны

Practice Iteration
------------------
- [ ] Разработка своего микро-сервисного приложения "с нуля" каждой командой
- [ ] Интеграция микро-сервисов команд в единое приложение
