import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    FileParser fileParser;
    Dictionary dictionary;
    File fichier,fichier1;
    @Mock
    BufferedReader mockBufferedReader;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        fichier=new File("fichier1.txt");
        fichier1=new File("fichier1.txt");
        MockitoAnnotations.initMocks(this);
        fileParser = new FileParser(mockBufferedReader);

    }

    @AfterEach
    void tearDown() {
    }

        @Test
        void testFillDictionary() throws IOException {
            Mockito.when(mockBufferedReader.readLine())
                    .thenReturn("anglais_francais")
                    .thenReturn("pomme;apple")
                    .thenReturn("noir;black")
                    .thenReturn("quatre;four");
            Mockito.when(mockBufferedReader.readLine()==null)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true);

            fileParser.getDico();
            ArrayList<String> traduction_pomme = new ArrayList<>();
            traduction_pomme.add("apple");

            ArrayList <String> traduction_noir = new ArrayList<>();
            traduction_noir.add("black");

            ArrayList <String> traduction_quatre = new ArrayList<>();
            traduction_quatre.add("four");

            assertEquals("anglais_francais", fileParser.getDico().getName());
            assertFalse(fileParser.getDico().isEmpty());
            assertEquals(traduction_pomme, fileParser.getDico().getMultipleTranslations("pomme"));
            assertEquals(traduction_noir, fileParser.getDico().getMultipleTranslations("noir"));
            assertEquals(traduction_quatre, fileParser.getDico().getMultipleTranslations("quatre"));
    }

    //Apres avoir fini fini de passer par des Mocks, réalisons notre propre fichier d’exemple

    @Test
    public void TestFichierCorrect() throws Exception {
        String Nom_fichier = "fichier1.txt";
        fichier = new File(Nom_fichier);
        fileParser = new FileParser(fichier);
        dictionary= fileParser.getDico();
        HashMap<String, ArrayList<String>> test = new HashMap<>();
        ArrayList<String> list1= new ArrayList<>();
        ArrayList<String> list2= new ArrayList<>();
        list1.add("dog");
        list2.add("cat");
        test.put("chien", list1);
        test.put("chat", list2);
        assertEquals(test, dictionary.getTraductionFr_Ang());

    }
    
    @Test
    public void testFichierIncorrect() throws IOException {
       String Nom_fichier = "fichier2.txt";
        fichier = new File(Nom_fichier);
        assertThrows(IOException.class, () -> {
            dictionary = null;
            fileParser = new FileParser(fichier);
            dictionary = fileParser.getDico();
        });


    }


}





