import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void Hero_instantiatesCorrectly_true(){
        Hero myHero = new Hero ("Mathew", 9, "bonus","fit");
        assertEquals(true, myHero instanceof Hero);

    }

}
