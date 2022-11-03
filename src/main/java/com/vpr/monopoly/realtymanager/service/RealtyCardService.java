package com.vpr.monopoly.realtymanager.service;

import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RealtyCardService {
    public List<RealtyCardDto> list_all_cards;

    public void set_all_RealtyCardService(){
        List<RealtyCardDto> list_cards =  new ArrayList<RealtyCardDto>();
        list_cards.add(RealtyCardDto.builder()
                .position(1)
                .CardName("Старая Дорога")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 2);//Рента без строений
                    put((long) 1,(long) 10);//1 дом
                    put((long) 2,(long) 30);//2 дома
                    put((long) 3,(long) 90);//3 дома
                    put((long) 4,(long) 160);//4 дома
                    put((long) 5,(long) 250);//рента с отелем
                }})
                .deposit((long)30)
                .costCard((long)60)
                .costHouse((long)50)
                .countHouse(null)
                .color("yellow")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(3)
                .CardName("Главное шоссе")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 4);//Рента без строений
                    put((long) 1,(long) 20);//1 дом
                    put((long) 2,(long) 60);//2 дома
                    put((long) 3,(long) 180);//3 дома
                    put((long) 4,(long) 320);//4 дома
                    put((long) 5,(long) 450);//рента с отелем
                }})
                .deposit((long)30)
                .costCard((long)60)
                .costHouse((long)50)
                .countHouse(null)
                .color("yellow")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(6)
                .CardName("Аквапарк")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 6);//Рента без строений
                    put((long) 1,(long) 30);//1 дом
                    put((long) 2,(long) 90);//2 дома
                    put((long) 3,(long) 270);//3 дома
                    put((long) 4,(long) 400);//4 дома
                    put((long) 5,(long) 550);//рента с отелем
                }})
                .deposit((long)50)
                .costCard((long)100)
                .costHouse((long)50)
                .countHouse(null)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(8)
                .CardName("Городской парк")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 6);//Рента без строений
                    put((long) 1,(long) 30);//1 дом
                    put((long) 2,(long) 90);//2 дома
                    put((long) 3,(long) 270);//3 дома
                    put((long) 4,(long) 400);//4 дома
                    put((long) 5,(long) 550);//рента с отелем
                }})
                .deposit((long)50)
                .costCard((long)100)
                .costHouse((long)50)
                .countHouse(null)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(9)
                .CardName("Горнолыжный курорт")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 8);//Рента без строений
                    put((long) 1,(long) 40);//1 дом
                    put((long) 2,(long) 100);//2 дома
                    put((long) 3,(long) 300);//3 дома
                    put((long) 4,(long) 450);//4 дома
                    put((long) 5,(long) 600);//рента с отелем
                }})
                .deposit((long)60)
                .costCard((long)120)
                .costHouse((long)50)
                .countHouse(null)
                .color("orange")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(11)
                .CardName("Спальный район")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 10);//Рента без строений
                    put((long) 1,(long) 50);//1 дом
                    put((long) 2,(long) 150);//2 дома
                    put((long) 3,(long) 450);//3 дома
                    put((long) 4,(long) 625);//4 дома
                    put((long) 5,(long) 750);//рента с отелем
                }})
                .deposit((long)70)
                .costCard((long)140)
                .costHouse((long)100)
                .countHouse(null)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(13)
                .CardName("Деловой квартал")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 10);//Рента без строений
                    put((long) 1,(long) 50);//1 дом
                    put((long) 2,(long) 150);//2 дома
                    put((long) 3,(long) 450);//3 дома
                    put((long) 4,(long) 625);//4 дома
                    put((long) 5,(long) 750);//рента с отелем
                }})
                .deposit((long)70)
                .costCard((long)140)
                .costHouse((long)100)
                .countHouse(null)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(14)
                .CardName("Торговая площадь")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 12);//Рента без строений
                    put((long) 1,(long) 60);//1 дом
                    put((long) 2,(long) 180);//2 дома
                    put((long) 3,(long) 500);//3 дома
                    put((long) 4,(long) 700);//4 дома
                    put((long) 5,(long) 900);//рента с отелем
                }})
                .deposit((long)80)
                .costCard((long)160)
                .costHouse((long)100)
                .countHouse(null)
                .color("green")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(16)
                .CardName("Улица Пушкина")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 14);//Рента без строений
                    put((long) 1,(long) 70);//1 дом
                    put((long) 2,(long) 200);//2 дома
                    put((long) 3,(long) 550);//3 дома
                    put((long) 4,(long) 750);//4 дома
                    put((long) 5,(long) 950);//рента с отелем
                }})
                .deposit((long)90)
                .costCard((long)180)
                .costHouse((long)100)
                .countHouse(null)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(18)
                .CardName("Проспект Мира")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 14);//Рента без строений
                    put((long) 1,(long) 70);//1 дом
                    put((long) 2,(long) 200);//2 дома
                    put((long) 3,(long) 550);//3 дома
                    put((long) 4,(long) 750);//4 дома
                    put((long) 5,(long) 950);//рента с отелем
                }})
                .deposit((long)90)
                .costCard((long)180)
                .costHouse((long)100)
                .countHouse(null)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(19)
                .CardName("Проспект Победы")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 16);//Рента без строений
                    put((long) 1,(long) 80);//1 дом
                    put((long) 2,(long) 220);//2 дома
                    put((long) 3,(long) 600);//3 дома
                    put((long) 4,(long) 800);//4 дома
                    put((long) 5,(long) 1000);//рента с отелем
                }})
                .deposit((long)100)
                .costCard((long)200)
                .costHouse((long)100)
                .countHouse(null)
                .color("lightgreen")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(21)
                .CardName("Бар")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 18);//Рента без строений
                    put((long) 1,(long) 90);//1 дом
                    put((long) 2,(long) 250);//2 дома
                    put((long) 3,(long) 700);//3 дома
                    put((long) 4,(long) 875);//4 дома
                    put((long) 5,(long) 1050);//рента с отелем
                }})
                .deposit((long)110)
                .costCard((long)220)
                .costHouse((long)150)
                .countHouse(null)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(23)
                .CardName("Ночной клуб")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 18);//Рента без строений
                    put((long) 1,(long) 90);//1 дом
                    put((long) 2,(long) 250);//2 дома
                    put((long) 3,(long) 700);//3 дома
                    put((long) 4,(long) 875);//4 дома
                    put((long) 5,(long) 1050);//рента с отелем
                }})
                .deposit((long)110)
                .costCard((long)220)
                .costHouse((long)150)
                .countHouse(null)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(24)
                .CardName("Ресторан")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 20);//Рента без строений
                    put((long) 1,(long) 100);//1 дом
                    put((long) 2,(long) 300);//2 дома
                    put((long) 3,(long) 750);//3 дома
                    put((long) 4,(long) 925);//4 дома
                    put((long) 5,(long) 1100);//рента с отелем
                }})
                .deposit((long)120)
                .costCard((long)240)
                .costHouse((long)150)
                .countHouse(null)
                .color("red")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(26)
                .CardName("Компьютеры")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 22);//Рента без строений
                    put((long) 1,(long) 110);//1 дом
                    put((long) 2,(long) 330);//2 дома
                    put((long) 3,(long) 800);//3 дома
                    put((long) 4,(long) 975);//4 дома
                    put((long) 5,(long) 1150);//рента с отелем
                }})
                .deposit((long)130)
                .costCard((long)260)
                .costHouse((long)150)
                .countHouse(null)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(27)
                .CardName("Интернет")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 22);//Рента без строений
                    put((long) 1,(long) 110);//1 дом
                    put((long) 2,(long) 330);//2 дома
                    put((long) 3,(long) 800);//3 дома
                    put((long) 4,(long) 975);//4 дома
                    put((long) 5,(long) 1150);//рента с отелем
                }})
                .deposit((long)130)
                .costCard((long)260)
                .costHouse((long)150)
                .countHouse(null)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(29)
                .CardName("Сотовая связь")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 24);//Рента без строений
                    put((long) 1,(long) 120);//1 дом
                    put((long) 2,(long) 360);//2 дома
                    put((long) 3,(long) 850);//3 дома
                    put((long) 4,(long) 1025);//4 дома
                    put((long) 5,(long) 1200);//рента с отелем
                }})
                .deposit((long)140)
                .costCard((long)280)
                .costHouse((long)150)
                .countHouse(null)
                .color("pink")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(31)
                .CardName("Морские перевозки")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 26);//Рента без строений
                    put((long) 1,(long) 130);//1 дом
                    put((long) 2,(long) 390);//2 дома
                    put((long) 3,(long) 900);//3 дома
                    put((long) 4,(long) 1100);//4 дома
                    put((long) 5,(long) 1275);//рента с отелем
                }})
                .deposit((long)150)
                .costCard((long)300)
                .costHouse((long)200)
                .countHouse(null)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(32)
                .CardName("Железная дорога")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 26);//Рента без строений
                    put((long) 1,(long) 130);//1 дом
                    put((long) 2,(long) 390);//2 дома
                    put((long) 3,(long) 900);//3 дома
                    put((long) 4,(long) 1100);//4 дома
                    put((long) 5,(long) 1275);//рента с отелем
                }})
                .deposit((long)150)
                .costCard((long)300)
                .costHouse((long)200)
                .countHouse(null)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(34)
                .CardName("Авиакомпания")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 28);//Рента без строений
                    put((long) 1,(long) 150);//1 дом
                    put((long) 2,(long) 450);//2 дома
                    put((long) 3,(long) 1000);//3 дома
                    put((long) 4,(long) 1200);//4 дома
                    put((long) 5,(long) 1400);//рента с отелем
                }})
                .deposit((long)160)
                .costCard((long)320)
                .costHouse((long)200)
                .countHouse(null)
                .color("blue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(37)
                .CardName("Курортная зона")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 35);//Рента без строений
                    put((long) 1,(long) 175);//1 дом
                    put((long) 2,(long) 500);//2 дома
                    put((long) 3,(long) 1100);//3 дома
                    put((long) 4,(long) 1300);//4 дома
                    put((long) 5,(long) 1500);//рента с отелем
                }})
                .deposit((long)175)
                .costCard((long)350)
                .costHouse((long)200)
                .countHouse(null)
                .color("lightblue")
                .build()
        );
        list_cards.add(RealtyCardDto.builder()
                .position(39)
                .CardName("Гостиничный комплекс")
                .owner(null)
                .priceMap(new HashMap<Long, Long>(){{
                    put((long) -1,(long) 0);//Собственность заложена
                    put((long) 0,(long) 50);//Рента без строений
                    put((long) 1,(long) 200);//1 дом
                    put((long) 2,(long) 600);//2 дома
                    put((long) 3,(long) 1400);//3 дома
                    put((long) 4,(long) 1700);//4 дома
                    put((long) 5,(long) 2000);//рента с отелем
                }})
                .deposit((long)200)
                .costCard((long)400)
                .costHouse((long)200)
                .countHouse(null)
                .color("lightblue")
                .build()
        );
        list_all_cards=list_cards;
    }
}
