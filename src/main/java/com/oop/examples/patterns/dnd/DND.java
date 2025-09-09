package com.oop.examples.patterns.dnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DND {

    public static void main(String[] args) {
        Random rng = new Random();

        // Configuración del héroe
        Hero hero = new Hero("Artemis", "elf", 20, 8, 180, rng);
        hero.setWeapon(new Weapon("Sword", 12));
        hero.setArmour(new Armour("Leather", 5));

        // Enemigos variados
        List<Enemy> enemies = Arrays.asList(
            new Enemy("Goblin", "goblin", 10, 4, 45, rng),
            new Enemy("Orc", "orc", 16, 6, 60, rng),
            new Enemy("Dragon", "dragon", 22, 10, 80, rng)
        );

        // Pelea
        Fight fight = new Fight(hero, enemies);
        fight.run();
    }

    // --Clases internas --

    static abstract class Character {
        protected String name;
        protected int baseAttack;
        protected int baseDefense;
        protected int health;
        protected Weapon weapon;
        protected Armour armour;

        public Character(String name, int baseAttack, int baseDefense, int health) {
            this.name = name;
            this.baseAttack = baseAttack;
            this.baseDefense = baseDefense;
            this.health = health;
        }

        public boolean isAlive() { return health > 0; }
        public String getName() { return name; }
        public int getHealth() { return health; }

        public void setWeapon(Weapon weapon) { this.weapon = weapon; }
        public void setArmour(Armour armour) { this.armour = armour; }

        public int getAttack() {
            return baseAttack + (weapon != null ? weapon.getAttack() : 0);
        }

        public int getDefense() {
            return baseDefense + (armour != null ? armour.getDefense() : 0);
        }

        public int takeDamage(int damage) {
            int mitigated = Math.max(1, damage - (getDefense() / 2));
            health = Math.max(0, health - mitigated);
            return mitigated;
        }

        public abstract int attack(Character target);
    }

    static class Hero extends Character {
        private String race;
        private Random rng;

        public Hero(String name, String race, int atk, int def, int hp, Random rng) {
            super(name, atk, def, hp);
            this.race = race;
            this.rng = rng;
        }

        public String getRace() { return race; }

        @Override
        public int attack(Character target) {
            int atk = getAttack();

            if (rng.nextInt(100) < 10) atk += 8; // crítico

            if (target instanceof Enemy e && e.getKind().equals("dragon") && !"elf".equals(race)) {
                atk -= 4;
            }

            atk = Math.max(1, atk);
            return target.takeDamage(atk);
        }
    }

    static class Enemy extends Character {
        private String kind;
        private Random rng;

        public Enemy(String name, String kind, int atk, int def, int hp, Random rng) {
            super(name, atk, def, hp);
            this.kind = kind;
            this.rng = rng;
        }

        public String getKind() { return kind; }

        @Override
        public int getAttack() {
            int atk = super.getAttack();
            switch (kind) {
                case "orc" -> atk += 2;
                case "goblin" -> { if (rng.nextInt(100) < 15) atk += 5; }
                case "dragon" -> atk += 4;
            }
            return atk;
        }
        

        @Override
        public int getDefense() {
            int def = super.getDefense();
            if ("dragon".equals(kind)) def += 3;
            return def;
        }

        @Override
        public int attack(Character target) {
            int atk = getAttack();
            if ("orc".equals(kind) && rng.nextInt(100) < 20) {
                atk += 6;
            }
            atk = Math.max(1, atk);
            return target.takeDamage(atk);
        }
    }

    static class Weapon {
        private final String type;
        private final int attack;

        public Weapon(String type, int attack) {
            this.type = type;
            this.attack = attack;
        }

        public String getType() { return type; }
        public int getAttack() { return attack; }
    }

    static class Armour {
        private final String type;
        private final int defense;

        public Armour(String type, int defense) {
            this.type = type;
            this.defense = defense;
        }

        public String getType() { return type; }
        public int getDefense() { return defense; }
    }

    static class Fight {
        private Hero hero;
        private List<Enemy> enemies;
        private int round = 1;
        private BattlePrinter printer = new BattlePrinter();

        public Fight(Hero hero, List<Enemy> enemies) {
            this.hero = hero;
            this.enemies = new ArrayList<>(enemies);
        }

        public void run() {
            printer.printlnHeader("FIGHT STARTS!");
            printer.printStatus(hero, enemies);

            while (hero.isAlive() && anyEnemyAlive()) {
                System.out.println("\n--- Round " + (round++) + " ---");

                Enemy target = firstAliveEnemy();
                if (target != null) {
                    int dealt = hero.attack(target);
                    printer.printHeroAttack(hero, target, dealt);
                }

                for (Enemy e : enemies) {
                    if (e.isAlive() && hero.isAlive()) {
                        int dealt = e.attack(hero);
                        printer.printEnemyAttack(e, hero, dealt);
                    }
                }

                printer.printStatus(hero, enemies);
            }

            printer.printResult(hero);
        }

        private boolean anyEnemyAlive() {
            return enemies.stream().anyMatch(Enemy::isAlive);
        }

        private Enemy firstAliveEnemy() {
            return enemies.stream().filter(Enemy::isAlive).findFirst().orElse(null);
        }
    }

    static class BattlePrinter {
        public void printlnHeader(String msg) {
            System.out.println("\n==============================");
            System.out.println(msg);
            System.out.println("==============================");
        }

        public void printStatus(Hero hero, List<Enemy> enemies) {
            System.out.printf(
                "Hero %s: HP=%d, ATK=%d, DEF=%d%n",
                hero.getName(), hero.getHealth(), hero.getAttack(), hero.getDefense()
            );
            for (Enemy e : enemies) {
                System.out.printf(
                    "Enemy %-12s (kind=%-7s): HP=%3d, ATK=%2d, DEF=%2d%n",
                    e.getName(), e.getKind(), e.getHealth(), e.getAttack(), e.getDefense()
                );
            }
        }

        public void printHeroAttack(Hero hero, Enemy target, int dmg) {
            System.out.printf(
                "🗡️ %s hits %s for %d dmg. (%s HP=%d)%n",
                hero.getName(), target.getName(), dmg, target.getName(), target.getHealth()
            );
            if (!target.isAlive()) {
                System.out.printf("%s is defeated!%n", target.getName());
            }
        }

        public void printEnemyAttack(Enemy enemy, Hero hero, int dmg) {
            String emoji = enemy.getKind().equals("dragon") ? "🐉" : "🧌";
            System.out.printf(
                "%s %s hits %s for %d dmg. (%s HP=%d)%n",
                emoji, enemy.getName(), hero.getName(), dmg, hero.getName(), hero.getHealth()
            );
        }

        public void printResult(Hero hero) {
            System.out.println("\n=== RESULT ===");
            if (hero.isAlive()) {
                System.out.println("Hero wins! 🎉");
            } else {
                System.out.println("Enemies prevail... 😭");
            }
        }
    }
}

