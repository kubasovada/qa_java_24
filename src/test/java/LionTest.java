import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsCorrectResult() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnsCorrectResult() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void catchException() {
        Exception exception = null;
        try {
            Lion lion = new Lion(feline, "Самецrf");
        } catch (Exception ex) {
            exception = ex;
        }
        String expectedTextException  = "Используйте допустимые значения пола животного - самей или самка";
        String actual = exception.getMessage();
        assertNotNull(exception);
        assertEquals(expectedTextException, actual);
    }
}
