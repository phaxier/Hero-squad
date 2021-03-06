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
    public void clear_emptiesAllSquadsFromList_0(){
        Squad testSquad = new Squad("Team","find", "16");
        Squad.clear();
        assertEquals(Squad.all().size(),0);

    }

    @Test
    public void getId_squadInstantiatesWithAnId_1() {
        Squad testSquad = new Squad("Team","find", "16");
        assertEquals(2, testSquad.getId());
    }

    @Test

    public void find_returnsSquadWithSameId_secondSquad (){
        Squad.clear();
        Squad firstSquad = new Squad ("Team","find", "16");
        Squad secondSquad = new Squad ("Mathew","charity", "10");
        assertEquals(Squad.find(secondSquad.getId()), secondSquad);

    }

    @Test
    public void getHeroes_initiallyReturnsEmptyList_ArrayList(){
        Squad.clear();
        Squad testSquad = new Squad("Team","find", "16");
        assertEquals(0, testSquad.getHeroes().size());
    }

    @Test
    public void addHero_addsHeroToList_true () {
        Squad testSquad = new Squad ("Team","find", "16");
        Hero testHero = new Hero ("lawn", 9, "fit", "poor");
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
    }
}