import java.io.*;

public class FileParser {
    private File fichier;
    BufferedReader bufferedReader;

    public FileParser(BufferedReader bufferedReader){
        this.bufferedReader=bufferedReader;
    }
    public FileParser(File fichier) throws FileNotFoundException {
        if (fichier==null){
            throw new IllegalArgumentException();
        }
        if (fichier.isFile() && fichier.getName().endsWith(".txt")){
            BufferedReader buffer= new BufferedReader(new FileReader(fichier));
            bufferedReader=buffer;
        }else {
            throw new FileNotFoundException("Le format du fichier est Invalide");
        }
    }


    public Dictionary getDico() throws IOException {
        Dictionary dictionary = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fichier));
            //Lire la premiere ligne du fichier pour recuperer le nom du dictionnaire
            String id_dictionnaire=bufferedReader.readLine();
           dictionary = new Dictionary(id_dictionnaire);

        } catch (FileNotFoundException e) {
            System.out.println("Fichier Introuvable");
        } catch (NullPointerException e) {
            throw new NullPointerException("Null");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            String ligne ;
            while ((ligne= bufferedReader.readLine() )!=null)
            {
                // on separe les lignes en utilisant le separateur ";"
                String[] split = ligne.split(";");

                if (split.length == 2) {
                    //on recupere le mot
                    String mot = split[0].toLowerCase();

                    //on recupere la traductions du mot
                    String traduction = split[1].toLowerCase();

                    //On ajoute a notre dictionnaire
                    dictionary.addTranslation(mot, traduction);
                }else {
                    throw new IOException("Le format mot;word n'est pas respecter dans le fichier");
                }

            }
        bufferedReader.close();
        return dictionary;

        }

    }






