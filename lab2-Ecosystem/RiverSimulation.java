import java.util.Random;

abstract class Animal {
    public abstract char getSymbol();
}

class Bear extends Animal {
    @Override
    public char getSymbol() {
        return 'B';
    }
}

class Fish extends Animal {
    @Override
    public char getSymbol() {
        return 'F';
    }
}

class River {
    private Animal[] riverArray;
    private Random rand = new Random();

    public River(int size, int numBears, int numFish) {
        riverArray = new Animal[size];
        for (int i = 0; i < numBears; i++) {
            addRandom(new Bear());
        }
        for (int i = 0; i < numFish; i++) {
            addRandom(new Fish());
        }
    }

    private void addRandom(Animal a) {
        int attempts = 0;
        while (attempts < 100) {
            int idxvar = rand.nextInt(riverArray.length);
            if (riverArray[idxvar] == null) {
                riverArray[idxvar] = a;
                break;
            }
            attempts++;
        }
    }

    public void step() {
        Animal[] nextRiverArray = new Animal[riverArray.length];
        boolean[] moved = new boolean[riverArray.length];

        for (int i = 0; i < riverArray.length; i++) {
            if (riverArray[i] != null && !moved[i]) {
                int move = rand.nextInt(3) - 1;       // -1, 0, or +1
                int newIndex = i + move;
                if (newIndex < 0 || newIndex >= riverArray.length) {
                    newIndex = i;
                }
                Animal current = riverArray[i];
                if (nextRiverArray[newIndex] == null) {
                    nextRiverArray[newIndex] = current;
                    moved[i] = true;
                } else {
                    Animal target = nextRiverArray[newIndex];
                    if ((current instanceof Bear && target instanceof Bear) ||
                            (current instanceof Fish && target instanceof Fish)) {
                        nextRiverArray[newIndex] = target;
                        addRandom(current instanceof Bear ? new Bear() : new Fish());
                    } else if (current instanceof Bear && target instanceof Fish) {
                        nextRiverArray[newIndex] = current;
                    } else if (current instanceof Fish && target instanceof Bear) {
                        // fish disappears
                    }
                    moved[i] = true;
                }
            }
        }
        riverArray = nextRiverArray;
    }

    public void printRiver() {
        for (int i = 0; i < riverArray.length; i++) {
            if (riverArray[i] == null) {
                System.out.print("-");
            } else {
                System.out.print(riverArray[i].getSymbol());
            }
        }
        System.out.println();
    }
}

public class RiverSimulation {
    public static void main(String[] args) {
        River river = new River(20, 5, 5);

        for (int step = 0; step < 10; step++) {
            System.out.print("Step " + step + ": ");
            river.printRiver();
            river.step();
        }

        System.out.print("Final: ");
        river.printRiver();
    }
}
