package ohtu;

public class Course {

    private String name;
    private String term;
    private int week1;
    private int week2;
    private int week3;
    private int week4;
    private int week5;
    private int week6;

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public int[] getMaximums() {
        int[] r = new int[6];
        r[0] = week1;
        r[1] = week2;
        r[2] = week3;
        r[3] = week4;
        r[4] = week5;
        r[5] = week6;

        return r;
    }

    @Override
    public String toString() {
        return name + ", " + term;
    }
}
