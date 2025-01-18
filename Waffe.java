public class Waffe extends Gegenstand
{
    public Waffe()
    {
        super("Waffe", "Eine Waffe");
        setzeBildname("sword.png");
    }

    public char gibKuerzel() {
        return 'w';
    }

}
