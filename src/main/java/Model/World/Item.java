package Model.World;

import Model.EntityType;

public class Item {
    private final MaterialType materialType;
    private EntityType itemType; //Kanske borde ta denna diskussionen igen...

    public Item(EntityType itemType, MaterialType materialType) {
        this.materialType = materialType;
        this.itemType = itemType;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public EntityType getItemType() {
        return itemType;
    }
}
