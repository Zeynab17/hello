import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private String name;

    private HashMap<String, ArrayList<String>> traductionFr_Ang;
    //private HashMap<String, ArrayList<String>> traductionAng_Fr;

    public HashMap<String, ArrayList<String>> getTraductionFr_Ang() {
        return traductionFr_Ang;
    }

    Dictionary(){
    }
    Dictionary(String name){
        this.name=name;
       // this.traductionFr_Ang=new HashMap<String,String>();
        this.traductionFr_Ang=new HashMap<String, ArrayList<String>>();

    }

    public String getName() {
        return this.name;
    }

    public boolean isEmpty() {
        return traductionFr_Ang.isEmpty();
    }

    void addTranslation(String fr, String en) {
        if (!traductionFr_Ang.containsKey(fr))
        {
            ArrayList<String> liste_traduction_Fr_An = new ArrayList<>();
            liste_traduction_Fr_An.add(en);
            traductionFr_Ang.put(fr, liste_traduction_Fr_An);
        }
        else
        {
            traductionFr_Ang.get(fr).add(en);

        }

        if(!traductionFr_Ang.containsKey(en) ){
            ArrayList<String> liste_traduction_Ang_Fr = new ArrayList<>();
            liste_traduction_Ang_Fr.add(fr);
            traductionFr_Ang.put(en, liste_traduction_Ang_Fr);
        }
        else
        {

            traductionFr_Ang.get(en).add(fr);
        }





        /*
        if(traductionFr_Ang.containsKey(fr) && !traductionFr_Ang.containsValue(en)) {
            traductionFr_Ang.get(fr).add(en);
        }
        if (traductionFr_Ang.containsKey(en) && !traductionFr_Ang.containsValue(fr)) {
            traductionFr_Ang.get(en).add(fr);
        }

         */
    }
    String getTranslation(String word){
        if (traductionFr_Ang.containsKey(word)){
            return traductionFr_Ang.get(word).get(0);
        }
        return null;
    }

    ArrayList<String> getMultipleTranslations(String word){
        if (traductionFr_Ang.containsKey(word)){
            return traductionFr_Ang.get(word);
        }
        return null;
    }

}

