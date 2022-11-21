package com.vpr.monopoly.realtymanager.service.impl;

import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RealtyCardService {

    public List<RealtyCardDto> setАllRealtyCardService(){
        List<RealtyCardDto> list_cards =  new ArrayList<RealtyCardDto>();
        list_cards.add(RealtyCardDto.builder()
                .position(1)
                .cardName("Старая Дорога")
                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put(0L, 2L);//Рента без строений
                    put( 1L, 10L);//1 дом
                    put( 2L, 30L);//2 дома
                    put( 3L, 90L);//3 дома
                    put( 4L, 160L);//4 дома
                    put( 5L, 250L);//рента с отелем
                }})
                .costCard(60L)
                .costHouse(50L)
                .countHouse(0L)
                .color("yellow")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(3)
                .cardName("Главное шоссе")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 4L);//Рента без строений
                    put( 1L, 20L);//1 дом
                    put( 2L, 60L);//2 дома
                    put( 3L, 180L);//3 дома
                    put( 4L, 320L);//4 дома
                    put( 5L, 450L);//рента с отелем
                }})

                .costCard(60L)
                .costHouse(50L)
                .countHouse(0L)
                .color("yellow")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(5)
                .cardName("Восточный морской порт")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 25L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 100L);//2 дома
                    put( 3L, 200L);//3 дома
                }})
                .costCard(200L)
                .costHouse(0L)
                .countHouse(0L)
                .color("port")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(6)
                .cardName("Аквапарк")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 6L);//Рента без строений
                    put( 1L, 30L);//1 дом
                    put( 2L, 90L);//2 дома
                    put( 3L, 270L);//3 дома
                    put( 4L, 400L);//4 дома
                    put( 5L, 550L);//рента с отелем
                }})

                .costCard(100L)
                .costHouse(50L)
                .countHouse(0L)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(8)
                .cardName("Городской парк")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 6L);//Рента без строений
                    put( 1L, 30L);//1 дом
                    put( 2L, 90L);//2 дома
                    put( 3L, 270L);//3 дома
                    put( 4L, 400L);//4 дома
                    put( 5L, 550L);//рента с отелем
                }})

                .costCard(100L)
                .costHouse(50L)
                .countHouse(0L)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(9)
                .cardName("Горнолыжный курорт")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 8L);//Рента без строений
                    put( 1L, 40L);//1 дом
                    put( 2L, 100L);//2 дома
                    put( 3L, 300L);//3 дома
                    put( 4L, 450L);//4 дома
                    put( 5L, 600L);//рента с отелем
                }})

                .costCard(120L)
                .costHouse(50L)
                .countHouse(0L)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(11)
                .cardName("Спальный район")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 10L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 150L);//2 дома
                    put( 3L, 450L);//3 дома
                    put( 4L, 625L);//4 дома
                    put( 5L, 750L);//рента с отелем
                }})

                .costCard(140L)
                .costHouse(100L)
                .countHouse(0L)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(12)
                .cardName("Электрическая компания")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 4L);//Рента без строений
                    put( 1L, 10L);//1 дом
                }})
                .costCard(150L)
                .costHouse(0L)
                .color("utilities")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(13)
                .cardName("Деловой квартал")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 10L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 150L);//2 дома
                    put( 3L, 450L);//3 дома
                    put( 4L, 625L);//4 дома
                    put( 5L, 750L);//рента с отелем
                }})

                .costCard(140L)
                .costHouse(100L)
                .countHouse(0L)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(14)
                .cardName("Торговая площадь")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 12L);//Рента без строений
                    put( 1L, 60L);//1 дом
                    put( 2L, 180L);//2 дома
                    put( 3L, 500L);//3 дома
                    put( 4L, 700L);//4 дома
                    put( 5L, 900L);//рента с отелем
                }})

                .costCard(160L)
                .costHouse(100L)
                .countHouse(0L)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(15)
                .cardName("Южный морской порт")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 25L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 100L);//2 дома
                    put( 3L, 200L);//3 дома
                }})
                .costCard(200L)
                .costHouse(0L)
                .countHouse(0L)
                .color("port")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(16)
                .cardName("Улица Пушкина")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 14L);//Рента без строений
                    put( 1L, 70L);//1 дом
                    put( 2L, 200L);//2 дома
                    put( 3L, 550L);//3 дома
                    put( 4L, 750L);//4 дома
                    put( 5L, 950L);//рента с отелем
                }})

                .costCard(180L)
                .costHouse(100L)
                .countHouse(0L)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(18)
                .cardName("Проспект Мира")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 14L);//Рента без строений
                    put( 1L, 70L);//1 дом
                    put( 2L, 200L);//2 дома
                    put( 3L, 550L);//3 дома
                    put( 4L, 750L);//4 дома
                    put( 5L, 950L);//рента с отелем
                }})

                .costCard(180L)
                .costHouse(100L)
                .countHouse(0L)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(19)
                .cardName("Проспект Победы")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 16L);//Рента без строений
                    put( 1L, 80L);//1 дом
                    put( 2L, 220L);//2 дома
                    put( 3L, 600L);//3 дома
                    put( 4L, 800L);//4 дома
                    put( 5L, 1000L);//рента с отелем
                }})

                .costCard(200L)
                .costHouse(100L)
                .countHouse(0L)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(21)
                .cardName("Бар")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 18L);//Рента без строений
                    put( 1L, 90L);//1 дом
                    put( 2L, 250L);//2 дома
                    put( 3L, 700L);//3 дома
                    put( 4L, 875L);//4 дома
                    put( 5L, 1050L);//рента с отелем
                }})

                .costCard(220L)
                .costHouse(150L)
                .countHouse(0L)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(23)
                .cardName("Ночной клуб")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 18L);//Рента без строений
                    put( 1L, 90L);//1 дом
                    put( 2L, 250L);//2 дома
                    put( 3L, 700L);//3 дома
                    put( 4L, 875L);//4 дома
                    put( 5L, 1050L);//рента с отелем
                }})

                .costCard(220L)
                .costHouse(150L)
                .countHouse(0L)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(24)
                .cardName("Ресторан")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 20L);//Рента без строений
                    put( 1L, 100L);//1 дом
                    put( 2L, 300L);//2 дома
                    put( 3L, 750L);//3 дома
                    put( 4L, 925L);//4 дома
                    put( 5L, 1100L);//рента с отелем
                }})

                .costCard(240L)
                .costHouse(150L)
                .countHouse(0L)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(25)
                .cardName("Северный морской порт")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 25L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 100L);//2 дома
                    put( 3L, 200L);//3 дома
                }})
                .costCard(200L)
                .costHouse(0L)
                .countHouse(0L)
                .color("port")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(26)
                .cardName("Компьютеры")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 22L);//Рента без строений
                    put( 1L, 110L);//1 дом
                    put( 2L, 330L);//2 дома
                    put( 3L, 800L);//3 дома
                    put( 4L, 975L);//4 дома
                    put( 5L, 1150L);//рента с отелем
                }})

                .costCard(260L)
                .costHouse(150L)
                .countHouse(0L)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(27)
                .cardName("Интернет")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 22L);//Рента без строений
                    put( 1L, 110L);//1 дом
                    put( 2L, 330L);//2 дома
                    put( 3L, 800L);//3 дома
                    put( 4L, 975L);//4 дома
                    put( 5L, 1150L);//рента с отелем
                }})

                .costCard(260L)
                .costHouse(150L)
                .countHouse(0L)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(28)
                .cardName("Водопроводная компания")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 4L);//Рента без строений
                    put( 1L, 10L);//1 дом
                }})
                .costCard(150L)
                .costHouse(0L)
                .countHouse(0L)
                .color("utilities")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(29)
                .cardName("Сотовая связь")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 24L);//Рента без строений
                    put( 1L, 120L);//1 дом
                    put( 2L, 360L);//2 дома
                    put( 3L, 850L);//3 дома
                    put( 4L, 1025L);//4 дома
                    put( 5L, 1200L);//рента с отелем
                }})

                .costCard(280L)
                .costHouse(150L)
                .countHouse(0L)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(31)
                .cardName("Морские перевозки")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 26L);//Рента без строений
                    put( 1L, 130L);//1 дом
                    put( 2L, 390L);//2 дома
                    put( 3L, 900L);//3 дома
                    put( 4L, 1100L);//4 дома
                    put( 5L, 1275L);//рента с отелем
                }})

                .costCard(300L)
                .costHouse(200L)
                .countHouse(0L)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(32)
                .cardName("Железная дорога")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 26L);//Рента без строений
                    put( 1L, 130L);//1 дом
                    put( 2L, 390L);//2 дома
                    put( 3L, 900L);//3 дома
                    put( 4L, 1100L);//4 дома
                    put( 5L, 1275L);//рента с отелем
                }})

                .costCard(300L)
                .costHouse(200L)
                .countHouse(0L)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(34)
                .cardName("Авиакомпания")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 28L);//Рента без строений
                    put( 1L, 150L);//1 дом
                    put( 2L, 450L);//2 дома
                    put( 3L, 1000L);//3 дома
                    put( 4L, 1200L);//4 дома
                    put( 5L, 1400L);//рента с отелем
                }})

                .costCard(320L)
                .costHouse(200L)
                .countHouse(0L)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(35)
                .cardName("Западный морской порт")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 25L);//Рента без строений
                    put( 1L, 50L);//1 дом
                    put( 2L, 100L);//2 дома
                    put( 3L, 200L);//3 дома
                }})
                .costCard(200L)
                .costHouse(0L)
                .countHouse(0L)
                .color("port")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(37)
                .cardName("Курортная зона")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 35L);//Рента без строений
                    put( 1L, 175L);//1 дом
                    put( 2L, 500L);//2 дома
                    put( 3L, 1100L);//3 дома
                    put( 4L, 1300L);//4 дома
                    put( 5L, 1500L);//рента с отелем
                }})

                .costCard(350L)
                .costHouse(200L)
                .countHouse(0L)
                .color("lightblue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(39)
                .cardName("Гостиничный комплекс")

                .priceMap(new HashMap<Long, Long>(){{
                    put( -1L, 0L);//Собственность заложена
                    put( 0L, 50L);//Рента без строений
                    put( 1L, 200L);//1 дом
                    put( 2L, 600L);//2 дома
                    put( 3L, 1400L);//3 дома
                    put( 4L, 1700L);//4 дома
                    put( 5L, 2000L);//рента с отелем
                }})

                .costCard(400L)
                .costHouse(200L)
                .countHouse(0L)
                .color("lightblue")
                .build()
        );
        return list_cards;
    }
}
