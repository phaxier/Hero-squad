import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squad_instantiatesCorrectly_true() {
        Squad testSquad = new Squad("Home");
        assertEquals(true, testSquad instanceof Squad);
    }

    @Test
    public void getName_SquadInstantiatesWithName_home(){
        Squad testSquad = new Squad("Home");
        assertEquals(true, testSquad.getName());
    }

    @Test
    public void all_returnsAllInstancesOfSquad_true(){
        Squad firstSquad = new Squad("Home");
        Squad secondSquad = new Squad("Team");
        assertEquals(true, Squad.all().contains(FirstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
    }
}