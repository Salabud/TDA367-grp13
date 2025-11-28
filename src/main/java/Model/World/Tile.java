package Model.World;

public class Tile {
    private final int x;
    private final int y;
    private final MaterialType materialType;

    public Tile(int x, int y, MaterialType materialType) {
        this.x = x;
        this.y = y;
        this.materialType = materialType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }
}