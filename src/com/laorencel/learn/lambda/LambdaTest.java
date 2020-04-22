package com.laorencel.learn.lambda;

import com.laorencel.learn.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaTest {

    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Hero hero = new Hero("英雄" + i, random.nextInt(100), random.nextInt(1000));
            heroes.add(hero);
            System.out.println(i + " = " + hero);
        }
        heroes.stream()
                .map(hero -> hero.hp > 300 && hero.damage > 50 ? hero : null)
                .forEach(hero -> System.out.println("hero = " + hero));

        System.out.println("filter");
        filter(heroes, hero -> hero.damage > 50 && hero.hp < 500);
    }

    private static void filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero hero :
                heroes) {
            if (checker.test(hero)) {
                System.out.println(hero);
            }
        }
    }
}
