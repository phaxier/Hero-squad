import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squad_instantiatesCorrectly_true() {
        Squad squad = new Squad("Mathew", "grinds", "10");
        assertTrue(squad instanceof Squad);
    }

    @Test
    public void squad_instantiatesWithName_String(){
        Squad squad = new Squad("Mathew", "grinds", "10");
        assertEquals("Mathew", squad.getName());
    }

    @Test
    public void squad_instantiatesWithCause_String(){
        Squad squad = new Squad("Mathew", "grinds", "10");
        assertEquals("grinds", squad.getCause());
    }

    @Test
    public void squad_instantiatesWithMax_String(){
        Squad squad = new Squad("Mathew", "grinds", "10");
        assertEquals("10", squad.getMax());
    }

    @Test
    public void all_returnsAllInstancesOfSquad_true(){
        Squad firstSquad = new Squad("Mathew", "grinds", "10");
        Squad secondSquad = new Squad("Team","find", "16");
        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
    }

    @Test
    public void clear_emptiesAllSquadsList_0(){
        Squad testSquad = new Squad("Team","find", "16");
        Squad.clear();
        assertEquals(Squad.all().size(),0);

    }
}