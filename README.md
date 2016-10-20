1. Настройка
Для проекта можно выставить уровень логирования, директорию логирования, параметры hibernate и web-приложения.
Конфигурационный файл для логирования \groovy-hibernate-sample\src\main\resources\log4j2.xml

2. Компиляция
Сборка проекта осуществляется с помощью Gradle. Используется JDK 1.8.
Для сборки необходимо из директории с проектом набрать в консоли команду gradle build

3. Запуск
Скомпилированный JAR будет помещён в диреторию \groovy-hibernate-sample\build\libs
Запускать нужно с командной строки из директории с архивом командой java -jar groovy-hibernate-sample-1.0.jar
Можно также запустить приложение с параметром - номером порта, на котором оно будет развёрнуто
Пример java -jar groovy-hibernate-sample-1.0.jar 81

4. REST API
GET http://localhost:8080/document-base-web/document/find - найти документ
параметры: documentId (Long) documentName (String)

GET http://localhost:8080/document-base-web/document/findAll - найти все документы

GET http://localhost:8080/document-base-web/document/findByType - найти все документы данного типа
параметры: documentTypeCode (String) documentTypeName (String)

PUT http://localhost:8080/document-base-web/document/ - обновить документ
тело запроса: {"id":1,"name":"паспорт1","documentType":{"id":1}}

POST http://localhost:8080/document-base-web/document/ - создать документ
тело запроса: {"name":"паспорт1","documentType":{"id":1}}

DELETE http://localhost:8080/document-base-web/document/delete - удалить документ по id
параметры: documentId (Long)