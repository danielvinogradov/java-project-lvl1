# [JAVA] Проект Brain Games
[![Actions Status](https://github.com/danielvinogradov/java-project-lvl1/workflows/build/badge.svg)](https://github.com/danielvinogradov/java-project-lvl1/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/a99a88d28ad37a79dbf6/maintainability)](https://codeclimate.com/github/codeclimate/codeclimate/maintainability)

## Описание
Это вольная реализация проекта Хекслета "Игры разума". Это консольное приложение, которое может запускать несколько простейших математических игр. Например, "Проверка на четность" или "Является ли число простым".

Реализация отличается от ТЗ Хеклета порой довольно сильно. Например, в оригинальном ТЗ запрещено использовать интерфейсы или абстрактные классы (в проекте используются обильно), а также предлагается завершать приложение после завершения одной игры. 

Но т.к. это учебный проект, мне хотелось попробовать различные техники и приемы. По этой же причине некоторые решения очевидно слишком сложные для такого небольшого приложения.

## Демонстрация
                     
Сначала демонстрируется пример успешного завершения игры (правильные ответы во всех раундах), а потом поведения приложения в случае некорректного ответа. Самая последняя команда `exit` завершает запись `asciinema` и не имеет отношения к программе.

[![asciicast](https://asciinema.org/a/K9iKvdeoWTefua4nxC04mIL61.svg)](https://asciinema.org/a/K9iKvdeoWTefua4nxC04mIL61)

## Запуск

Для запуска используется `Make`. 

Собрать `dist` и запустить его:

```bash
make run
```

## Немного про реализацию
        
Несколько слов о реализации игр (остальное, думается, и так понятно). Все игры (расположенны в директории `hexlet.code.games/`) запускаются с помощью игрового движка (интерфейс `Engine` и его единственная реализация `DefaultEngine`). 

Чтобы движок мог запустить игру, она должна имплементировать интерфейс `Playable`, по сути должна иметь функцию, генерирующую данные для проведения одного раунда игры (интерфейс `GameRoundData` и его единственная реализация `DefaultGameRoundData`).

Любая реализация `GameRoundData` по сути содержит в себе вопрос, строковое представление правильного ответа (ожидаемый пользовательский ввод, который бы считался правильным ответом) и предикат для проверки ответа (правильный или нет).
