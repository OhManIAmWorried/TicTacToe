# TicTacToe
course-work for OOP

UPD log|1|:        Первой итерацией станут базовое GUI с работоспособным, на сколько это возможно, оффлайн режимом.
                   Главной задачей на данном этапе является связывание GUI и мозгов. Трудности с системой контроля 
                   версий, лень разработчиков, тотальная неграмотность и отсутствие опыта делают процесс разработки 
                   мучительно долгим. Надежды на успех и безудержное сокращение времени до дедлайна- вот главная сила,
                   движущая проект по пути к завершению. 
     
            /Oleg/ Откатил мастер на этап с работоспособным GUI, наработки БабкиСапожницы[testname] перешли в сапог и 
                   будут неспешно заносится мною в отдельную ветку. В случае успеха будет merge с master . 
                 
                                                         *  *  *
                                                   
                                           Мрачные тучи застыли у пика Фудзиямы
                                      Пронзающим холодом веет ветер с горных склонов
                                       Покой и умиротворение найдёт самурай во сне
                                           Пустив Push на Remote с кодом рабочим
                                    
                                                         *  *  *
                                                 
UPD log|2|:        .class файлы- скомпилированная версия, инфа сотка. Idea при открытии пишет о декомпилировании файлов,
                   что как-бы намекает. Попробую перенести все классы в текстовые файлы и посоздавать .java в стабильной 
                   версии по новой. 

            /Oleg/ Как оказалось, проектирование проекта перед его осуществлением- не самая плохая из идей. Тонны и тонны
                   кода приходится переосмысливать. Там подковырнул, сям подковырнул, и вот уже нет злых красных полос, и
                   кажется, что не всё так плохо, что можно заставить эти монускрипты работать во благо обществу. 

UPD log|3|:        По состоянию на вечер пятницы корректно отрабатывает pvp, pvc ждёт хода челоека, делает задержку, в
                   унисон ставит иконку компьютера и иконку человека, что не есть хорошо и подлежит правкам, cvc творит
                   бред, работая на необновлённом поле, и выводя результат по завершению, что печально и никуда не годится.
            
            /TODO/ Читать про revalidate(), repaint(), validate() а также принцип обновления изображения в окне в целом.  
     
UPD log|4|:        Между нажатием на кнопку и появлением поля сооздана еще одна фаза. Она позволяет выбирать имя, а также
                   тип игрока, что делает ее универсальной. Это значит, что мы перейдем к одной кнопке "Offline mode" на 
                   стартовом экране. 

    /RobertsIshi/  БабкаСапожница? Ну погоди, Заяц[тестовое имя] 
                   Реанимировала погибающий гит. Сделала коммит без твоей помощи. С дизайном неоч, надо смотреть, как 
                   менять цвет текста и margin. Ybxtuj yt ckjvfkf/ Ghbrbym! Черт, раскладка. Я ничего не сломала 
                   (скорее всего), все ок работает (у меня).  Завтра добью это (если не будет лень). Почитаю-посмотрю
                   о передаче данных и попробую реализовать онлайн-режим.  Нужно сделать кномку "настройки" реально 
                   работающей + две кнопки на стартовом экране (онлайн и офлайн), чтоб я этим занялась. Иначе я не 
                   смогу, трогать твое боюсь. 

            /Заяц/ Одна вещь всё-же была испорчена- табуляция в дневнике, а всему виной длинный непонятный набор букв в 
                   качестве ника, что стал на место четырёх букв, на которые расчитывал некто Oleg (исправил)
                   
UPD log|5|:        Добавил изменения сделанные RobertsIshi, теперь есть возможность выбора имени. Правки по интерфейсу в 
                   ближайших апдейтах. 
                   
            /Oleg/ Занесены настройки идеи и скомпилированные файлы, теперь можно качать и, наверное, запускать проект без
                   лишних трудностей, но в гайде говорилось о неправильности такого подхода (но по другому неудобно). 
                   Подпортил свой репозиторий, [Ерундень] wasn't planned. Последний коммит должен работать, а внесение всех
                   файлов в репу может упростить а может и усложнить процесс создания коммитов. Хотя кому какое дело :(
                        
UPD log|6|:        Заложены основы для настройки цветовых схем, работы с множеством панелек в одном месте (нуждается в 
                   правке). 
            
            /Oleg/ Пока не будут раз и навсегда решены проблемы с отображением, эта программа не имеет будущего. Бесит эта 
                   хрень, жутко бесит. Тот самый момент, когда всё кажется близким к идеалу, выполненно по примеру и не 
                   работает Т.Т

UPD log|7|:        Заработало! GUI нуждается в правке, но это уже большой скачёк для человечества.