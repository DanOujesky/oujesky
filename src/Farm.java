import java.util.ArrayList;

public class Farm {

    private ArrayList<Flower> seznamKvetin = new ArrayList<>();
    private ArrayList<Flower> seznamSklizenychKvetin = new ArrayList<>();
    private ArrayList<Animal> seznamZvirat = new ArrayList<>();
    private static int pocetDruhuRoztlin = 0;
    private int velikostPozemku = 100;

    public void pridejZvire(Animal animal) throws Exception {
        if (seznamZvirat.size() < 21 && velikostZvirat(Size.BIG) < 11 && velikostZvirat(Size.SMALL) < 11) {
            seznamZvirat.add(animal);
        } else {
            throw new Exception("Zvire nelze pridat");
        }
    }
    public int velikostZvirat(Size velikost){
        int pocet = 0;
        for (int i = 0; i < seznamZvirat.size(); i++) {
            if (seznamZvirat.get(i).size == velikost) {
                pocet++;
            }
        }
        return pocet;
    }

    public void zasaditRoztlinu(Flower flower) throws Exception {

        if (!seznamKvetin.contains(flower.getClass())) {
            pocetDruhuRoztlin++;
        }
        if (flower.neededArea < velikostPozemku - getFullSize() && pocetDruhuRoztlin < 6) {
            seznamKvetin.add(flower);
        } else {
            throw new Exception("Kvetinu nelze zasadit ");
        }
    }
    public int getFullSize(){
        int size = 0;
        for (int i = 0; i < seznamKvetin.size(); i++) {
            size += seznamKvetin.get(i).neededArea;
        }
        return size;
    }
    public void zavlazitRoztlinu(Flower flower){
        flower.chanceOfGrowth += 10;
    }
    public void skliditRoztlinu(Flower flower){
        seznamSklizenychKvetin.add(flower);
        seznamKvetin.remove(flower);
    }
    public void koupitZvire (Animal animal) {
        seznamZvirat.add(animal);
    }
    public void prodatZvire (Animal animal) {
        seznamZvirat.remove(animal);
    }
    public String pohladitZvire(Animal animal){
        return "pohladil jste zvire";
    }





}
