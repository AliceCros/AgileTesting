package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.hasItems;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class HeroTest {

	Hero hero;
	Enemy enemy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		enemy = new Enemy("Pouf pouf", 1);
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
  public void testHeroLevelUp() throws Exception {
      Integer newLvl = hero.getLevel();
      hero.levelUp();
      assertTrue(hero.getLevel() > newLvl);
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
        assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
        assertThat(hero, hasProperty("level"));
        assertThat(hero, hasProperty("level", is(1)));
        assertThat(hero, hasProperty("hp"));
        assertThat(hero, hasProperty("hp", is(20)));
        assertThat(hero, hasProperty("atk"));
        assertThat(hero, hasProperty("atk", is(2)));
        System.out.println("Test constructeur & getters");
	}

	@Test
	public void testSetLevel() throws Exception {
		Integer currentLevel = hero.getLevel();
		hero.setLevel(4);
		assertTrue(currentLevel < hero.getLevel());
	  System.out.println("Test set Level");
	}

	@Test
  public void testtakeDamage() throws Exception {
    Integer hp = hero.getHp();
    hero.takeDamage(8);
    assertTrue(hero.getHp() < hp);
    System.out.println("take damage");
  }

	@Test
  public void testAttack() throws Exception {
      Integer hpEnemy = enemy.getHp();
      hero.attack(enemy);
      assertTrue(enemy.getHp() < hpEnemy);
      System.out.println("Attack enemy");
 }

}
