public class Duck {
    private int volume;
    private String name;

    public void quack() {
        System.out.println(this.name + " says Quack! at volume " + this.volume);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }
}
