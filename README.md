# Инструкция по запуску
Во вложении: 
1. архив (код самого проекта)
2. готовый сбилденный jar файл проекта  prs-json-countries-assembly-0.1.jar
3. в ./data/countries.json - файл данных для парсинка
4. README.md файл описание


При запуске jar файла (prs-json-countries-assembly-0.1.jar) в качестве аргумента можно задать пусть к папке, 
в которой будет результат работы скрипта в виде json файла под именем result.json 
Если аргумент (путь) не задан, то результат будет в текущему пути, откуда был запущен jar файл, то есть ./result.json 

Примеры запуска:
java -jar prs-json-countries-assembly-0.1.jar ./data
  результат ./data/result.json

java -jar prs-json-countries-assembly-0.1.jar
результат ./result.json


