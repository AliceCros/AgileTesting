package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;

public class HeroTest {

	Hero hero;

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
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		Integer testInitialLevel = hero.getLevel();
		Integer testNewLevel = hero.levelUp();
		assertThat(testNewLevel, equalTo(testInitialLevel + 1));
		//assertThat(testNewLevel == testInitialLevel + 1);
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
	public void testHeroSetLevel() throws Exception {
		// Garder en mémoire le level originel
		<Integer> testLevel1 = hero.getLevel();
		// Récupérer le nouveau level
		<Integer> testLevel2 = hero.setLevel(Integer parameter);
		// Vérifier qu'un seul paramètre de type Integer est passé à la méthode setLevel()
		assertThat(testLevel2, hasSize(1));
		// Vérifier que le paramètre est égal à testLevel2
		assertThat(testLevel2, hasItems(testLevel2));
		// Vérifier que la méthode setLevel définit un level plus haut que testLevel1;
		assertThat(testLevel2, hasItems(greaterThan(testLevel1)));
		//assertThat(parameter, hasItems(lessThan(1)));
	}

	@Test
    public void testHeroTakeDamage() throws Exception {
    	Integer testGetHp = hero.getHp();
    	Integer testNewHp = hero.takeDamage(Integer damage);
    	assertThat(testNewHp, equalTo(testGetHp - damage));
        this.hp -= damage;
    }

    @Test
    public void testHeroAttack() throws Exception {
       
    }

}
