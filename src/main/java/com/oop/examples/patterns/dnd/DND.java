package com.oop.examples.patterns.dnd;
import java.util.Arrays;
import java.util.List;



/**
 * Programa inicial para refactorización con patrones de diseño.
 *
 * <p>Ejecutar usando el comando:
 *
 * <p>mvn exec:java -Dexec.mainClass="com.oop.examples.patterns.dnd.DND"
 */
public class DND {

  public static void main(String[] args) {
    // Configuración del héroe

    Weapon sword = new Weapon("Lance", 15);
    Armour leather = new Armour("Silver_armour", 8);
    Hero hero = new Hero("Dartañan", "Caballero", 20, 8, 180);
    hero.setWeapon(sword);
    hero.setArmour(leather);

    // Enemigos variados
    List<Enemy> enemies =
        Arrays.asList(
            new Enemy("Magician", "goblin", 10, 4, 45),
            new Enemy("Prince", "orc", 16, 6, 60),
            new Enemy("Dragon", "dragon", 22, 10, 80));

    // Pelea
    Fight fight = new Fight(hero, enemies);
    fight.run();
  }

  // ----------------- Clases del dominio (versión inicial a refactorizar) -----------------

  





 
}
