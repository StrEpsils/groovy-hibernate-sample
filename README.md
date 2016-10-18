1. Настройка
Для проекта можно выставить уровень логирования и директорию логирования.
Конфигурационный файл для логирования \groovy-hibernate-sample\src\main\resources\log4j2.xml

2. Компиляция
Сборка проекта осуществляется с помощью Gradle. Используется JDK 1.8.
Для сборки необходимо из директории с проектом набрать в консоли команду gradle build

3. Запуск
Скомпилированный JAR будет помещён в диреторию \groovy-hibernate-sample\build\libs
Запускать нужно с командной строки из директории с архивом командой java -jar groovy-hibernate-sample-1.0.jar
Можно также запустить приложение с параметром - номером порта, на котором оно будет развёрнуто
Пример java -jar groovy-hibernate-sample-1.0.jar 81