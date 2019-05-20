import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Mathew", 9, "bonus", "fit");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void Hero_instantiatesWithName_String() {
        Hero myHero = new Hero("Mow", 9, "fit", "poor");
        assertEquals("Mow the lawn", myHero.getName());

    }

    @Test
    public void Hero_instantiatesWithAge_Integer() {
        Hero myHero = new Hero("Mow", 9, "fit", "poor");
        assertEquals("9", myHero.getAge());
    }
        @Test
        public void Hero_instantiatesWithPower_String() {
            Hero myHero = new Hero("Mow", 9, "fit", "poor");
            assertEquals("fit", myHero.getPower());
        }

        @Test
        public void Hero_instantiatesWithWeakness_String() {
            Hero myHero = new Hero("Mow", 9, "fit", "poor");
            assertEquals("lawn", myHero.getWeakness());

        }
    }
