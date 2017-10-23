package com.yh.mower.models.receiver;

/**
 * Mower, the receiver class in command pattern, includes its position
 * 
 * @author huyue
 *
 */
public class Mower {
    private MowerPosition position;

    /**
     * Constructor {@link Mower}
     * 
     * @param x
     *            initial mower position in x axis
     * @param y
     *            initial mower position in y axis
     * @param orientation
     *            initial mower orientation
     * @param xMax
     *            max width of lawn in x axis
     * @param yMax
     *            max width of lawn in y axis
     */
    public Mower(int x, int y, String orientation, int xMax, int yMax) {
        super();
        this.position = new MowerPosition(x, y, orientation, xMax, yMax);
    }

    /**
     * Constructor {@link Mower}
     * 
     * @param position
     *            mower initial position
     */
    public Mower(MowerPosition position) {
        super();
        this.position = position;
    }

    /**
     * @return the position
     */
    public MowerPosition getPosition() {
        return position;
    }

    /**
     * Move one step towards its orientation
     */
    public void move() {
        position.moveInOrientation();
    }

    /**
     * Turn left
     */
    public void turnLeft() {
        position.rotate90deg(false);
    }

    /**
     * Turn right
     */
    public void turnRight() {
        position.rotate90deg(true);
    }
}
