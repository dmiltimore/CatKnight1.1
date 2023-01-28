package Entity;
public class Entity {
    private int myX;
    private int myY;
    private int myHP;
    private int myAtk;
    private int myDef;
    private int mySpd;
    private int myMoveSpd;
    //getters
    public int getX() {
        return myX;
    }
    public int getY() {
        return myY;
    }
    public int getHP() {
        return myHP;
    }
    public int getAtk() {
        return myAtk;
    }
    public int getDef() {
        return myDef;
    }
    public int getSpd() {
        return mySpd;
    }
    public int getMoveSpd() {
        return myMoveSpd;
    }
    //setters
    public void setX(int theX) {
        myX = theX;
    }
    public void setY(int theY) {
        myY = theY;
    }
    public void setHP(int theHP) {
        myHP = theHP;
    }
    public void setAtk(int theAtk) {
        myAtk = theAtk;
    }
    public void setDef(int theDef) {
        myDef = theDef;
    }
    public void setSpd(int theSpd) {
        mySpd = theSpd;
    }
    public void setSpd(int theMoveSpd) {
        myMoveSpd = theMoveSpd;
    }
}
