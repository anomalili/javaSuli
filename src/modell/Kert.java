package modell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Kert implements Serializable {

    public Kert(List<Növény> novenyekLista) {
        this.novenyekLista = novenyekLista;
    }

    public void setNovenyek(List<Növény> novenyekLista) {
        this.novenyekLista = novenyekLista;
    }

    private List<Növény> novenyekLista;

    public Kert(ArrayList<Növény> növények) {
        this.novenyekLista = növények;
        novenyekLista = new ArrayList<>();
        novenyekLista.add(new Növény("aa00", "Napraforgó", 500, 1));
        novenyekLista.add(new Növény("aa01", "Legénypálma", 1500, 2));
        novenyekLista.add(new Növény("aa02", "Rózsa", 3000, 3));
    }

    public Kert() {
        novenyekLista = new ArrayList<>();
        novenyekLista.add(new Növény("aa00", "Napraforgó", 500, 1));
        novenyekLista.add(new Növény("aa01", "Legénypálma", 1500, 2));
        novenyekLista.add(new Növény("aa02", "Rózsa", 3000, 3));
    }


    public void novenyUj(Növény novenyPeldany) {
        novenyekLista.add(novenyPeldany);
    }

    public void novenyEladas(Növény novenyPeldany) {
        novenyekLista.remove(novenyPeldany);
    }

    public void novenyModosit(Növény novenyPeldany, int price, int age) {
        novenyPeldany.setPrice(price);
        novenyPeldany.setAge(age);
    }

    public void novenyOsszes() {
        for (int i = 0; i < novenyekLista.size(); i++) {
            System.out.println(novenyekLista.get(i));
        }
    }

    public void novenyekFajlbaMentese() {
        String folder = "mentett_adatok";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdirs(); // Létrehozza a mappát és a szükséges alkönyvtárakat
        }

        String file = folder + "/kert.bin";
        try ( ObjectOutputStream mentes = new ObjectOutputStream(new FileOutputStream(file))) {
            mentes.writeObject(novenyekLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void novenyeketBeolvasFajlbol() {
        String folder = "mentett_adatok";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdirs(); // Létrehozza a mappát és a szükséges alkönyvtárakat
        }

        String file = folder + "/kert.bin";
        try ( ObjectInputStream beolvas = new ObjectInputStream(new FileInputStream(file))) {
            novenyekLista = (List<Növény>) beolvas.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Növény> novenyekGet() {
        return novenyekLista;
    }

    public void szovegesFajlbaIras() {
        String folder = "szoveges";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdirs(); // Létrehozza a mappát és a szükséges alkönyvtárakat
        }

        String file = folder + "/kert.txt";
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Növény növény : novenyekLista) {
                writer.write(növény.getId() + "," + növény.getName() + "," + növény.getPrice() + "," + növény.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void szovegesBeolvasas() {
        String folder = "szoveges";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdirs(); // Létrehozza a mappát és a szükséges alkönyvtárakat
        }

        String file = folder + "/kert.txt";
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int price = Integer.parseInt(parts[2]);
                    int age = Integer.parseInt(parts[3]);
                    Növény növény = new Növény(id, name, price, age);
                    novenyekLista.add(növény);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Növény getNovenyByNevOrAzonosito(String nevVagyAzonosito) {
        for (Növény noveny : novenyekLista) {
            if (noveny.getName().equals(nevVagyAzonosito) || noveny.getId().equals(nevVagyAzonosito)) {
                return noveny;
            }
        }
        return null;
    }
    
    public Növény getNovenyByID(String azonosito) {
    for (Növény noveny : novenyekLista) {
        if (noveny.getId().equals(azonosito)) {
            return noveny;
        }
    }
    return null;
}

public Növény getNovenyByName(String nev) {
    for (Növény noveny : novenyekLista) {
        if (noveny.getName().equals(nev)) {
            return noveny;
        }
    }
    return null;
}


    
    public void novenyTorles(Növény novenyPeldany) {
    novenyekLista.remove(novenyPeldany);
}

    public Object getAzonositoLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
