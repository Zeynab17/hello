import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    Dictionary dictoFr_An,dictoAn_Fr,dictoAr_An;
    @BeforeEach
    void setUp() {
        dictoFr_An=new Dictionary("Francais_Anglais");
        dictoAn_Fr=new Dictionary("Anglais_Francais");
        dictoAr_An=new Dictionary("Arabe_Anglais");

    }

    //  Test pour le nom du dictionnaire
    @Test
    void testNomDictionnaire(){
        //assertThat( dictoAn .getName(), is(equals("Anglais")));
        assertEquals("Francais_Anglais",dictoFr_An.getName());
        assertEquals("Anglais_Francais",dictoAn_Fr.getName());
        assertEquals("Arabe_Anglais",dictoAr_An.getName());

    }

    //  Test si le dictionnaire est vide
    @Test
    void testDictionnaireVide(){
        assertTrue(dictoFr_An.isEmpty());
    }

    //  Test ajout d'une traduction et verification

    @Test
    void testAddTranslation1() {
        dictoFr_An.addTranslation("bon","well");
        dictoFr_An.addTranslation("bon","good");
        dictoFr_An.addTranslation("bon", "nice");
        dictoFr_An.addTranslation("pomme", "apple");

        ArrayList<String> liste_traduction1=new ArrayList<>();
        liste_traduction1.add("well");
        liste_traduction1.add("good");
        liste_traduction1.add("nice");

        assertEquals(liste_traduction1,dictoFr_An.getMultipleTranslations("bon"));
        //assertEquals("well",dictoFr_An.getTranslation("bon"));
        //assertEquals(liste_traduction2,dictoFr_An.getMultipleTranslations("pomme"));
       //assertEquals(null,dictoFr_An.getMultipleTranslations("salut"));
        System.out.println(dictoFr_An.getTraductionFr_Ang().get("pomme"));

    }


}