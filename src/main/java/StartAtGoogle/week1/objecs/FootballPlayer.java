package StartAtGoogle.week1.objecs;


public class FootballPlayer {
    private String name;
    private int jersey;
    private int grade;
    private String position;

    private FootballPlayer(){}; // empty constructor

    private FootballPlayer(String name, int jersey, int grade, String position) {
        this.name = name;
        this.jersey = jersey;
        this.grade = grade;
        setPosition(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position.equals("GK") ||
                position.equals("Defense") ||
                position.equals("Middlefiled") ||
                position.equals("Attack") ) {
            this.position = position;
        }else{
            throw new IllegalArgumentException("Wrong input, no such pos");
        }

    }

    /**
     * This method construct new FootballPlayer based on the  static factory methods technique.
     * but i get to decide on the player characteristic attributes based on the position he have
     * @param name name of player
     * @param jersey unique jersey for each player
     * @param grade eandom grade to a player, grade is between 0-100
     * @param pos position of the player.
     * @return object of kind FootballPlayer
     */
    public static FootballPlayer newPlayer(String name, int jersey, int grade, String pos) {
        FootballPlayer fp;
        if(pos.equals("GK")){
            fp = newPlayerWithDiffPos(name,jersey,grade,"GK");
        }
        else if(pos.equals("Defense")){
            fp = newPlayerWithDiffPos(name,jersey,grade,"Defense");
        }
        else if(pos.equals("Middlefiled")){
            fp = newPlayerWithDiffPos(name,jersey,grade,"Middlefiled");
        }
        else{
            fp = newPlayerWithDiffPos("Dvir",jersey,grade,"Attack");
        }
        return fp;
    }

    /**
     * This method construct new FootballPlayer based on the  static factory methods technique.
     * @param name name of player
     * @param jersey unique jersey for each player
     * @param grade eandom grade to a player, grade is between 0-100
     * @param pos position of the player.
     * @return object of kind FootballPlaye
     */
    public static FootballPlayer newPlayerWithDiffPos(String name, int jersey, int grade, String pos) {
        return new FootballPlayer(name,jersey,grade,pos);
    }
}
