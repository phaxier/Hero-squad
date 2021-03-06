import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class HeroTest {

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Mathew", 9, "bonus", "fit");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void Hero_instantiatesWithName_String() {
        Hero myHero = new Hero("Mow", 9, "fit", "poor");
        assertEquals("Mow", myHero.getName());

    }

    @Test
    public void Hero_instantiatesWithAge_Integer() {
        Hero myHero = new Hero("Mow", 9, "fit", "poor");
        assertEquals(9,(int) myHero.getAge());
    }
        @Test
        public void Hero_instantiatesWithPower_String() {
            Hero myHero = new Hero("Mow", 9, "fit", "poor");
            assertEquals("fit", myHero.getPower());
        }

        @Test
        public void Hero_instantiatesWithWeakness_String() {
            Hero myHero = new Hero("lawn", 9, "fit", "poor");
            assertEquals("poor", myHero.getWeakness());

        }
    @Test
    public void isCompleted_isFalseAfterInstantiation_false() {
        Hero myHero = new Hero("Mathew",9,"fit","poor");
        assertEquals(false, myHero.isCompleted());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Hero myHero = new Hero("Mathew",9,"fit","poor");
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Mathew",9,"fit","poor");
        Hero secondHero = new Hero("Jonathan",12,"bully","weak");
        assertEquals(true, Hero.all().contains(firstHero));
        assertEquals(true, Hero.all().contains(secondHero));
    }

    @Test
    public void clear_emptiesAllHeroFromArrayList_0() {
        Hero myHero = new Hero("Mathew",9,"fit","poor");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
    }

    @Test
    public void getId_heroInstantiateWithAnID_1() {
        Hero.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
        Hero myHero = new Hero("Mathew",9,"fit","poor");
        assertEquals(1, myHero.getId());
    }
    @Test
    public void find_returnsHeroWithSameId_secondHero() {
        Hero firstHero = new Hero("Mathew",9,"fit","poor");
        Hero secondHero = new Hero("Jonathan",12,"bully","weak");
        assertEquals(Hero.find(secondHero.getId()), secondHero);
    }

    }
