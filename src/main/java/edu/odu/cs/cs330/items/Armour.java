package edu.odu.cs.cs330.items;

import java.util.Objects;

@SuppressWarnings({
        "PMD.CloneMethodReturnTypeMustMatchClassName",
        "PMD.CloneThrowsCloneNotSupportedException",
        "PMD.LawOfDemeter",
        "PMD.OnlyOneReturn",
        "PMD.ProperCloneImplementation",
        "PMD.MethodArgumentCouldBeFinal",
        "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item {
    public static final String FMT_STR = String.join(System.lineSeparator(), "  Nme: %s", "  Dur: %d", "  Def: %d",
            "  Mtl: %s", "  Mdr: %s (Lvl %d)", "  Emt: %s", "");

    protected int defense;
    protected int durability;
    protected String material;
    protected String modifier;
    protected int modifierLevel;
    protected String element;

    public Armour() {
        super();
        this.name = "[Placeholder]";
        this.defense = 0;
        this.durability = 0;
        this.material = "[Material]";
        this.modifier = "[Modifier]";
        this.modifierLevel = 0;
        this.element = "[Element]";
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int def) {
        this.defense = def;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public int getModifierLevel() {
        return this.modifierLevel;
    }

    public void setModifierLevel(int modifierLevel) {
        this.modifierLevel = modifierLevel;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public Item clone() {
        Armour cpy = new Armour();
        cpy.setName(this.name);
        cpy.setDurability(this.durability);
        cpy.setDefense(this.defense);
        cpy.setMaterial(this.material);
        cpy.setModifier(this.modifier);
        cpy.setModifierLevel(this.modifierLevel);
        cpy.setElement(this.element);
        return cpy;
    }

    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Armour)) {
            return false;
        }
        Armour rhsItem = (Armour) rhs;
        return Objects.equals(this.name, rhsItem.name) &&
                Objects.equals(this.material, rhsItem.material) &&
                Objects.equals(this.modifier, rhsItem.modifier) &&
                this.modifierLevel == rhsItem.modifierLevel &&
                Objects.equals(this.element, rhsItem.element) &&
                this.defense == rhsItem.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.material, this.modifier, this.modifierLevel, this.element, this.defense);
    }

    @Override
    public String toString() {
        return String.format(FMT_STR, this.name, this.durability, this.defense, this.material, this.modifier,
                this.modifierLevel, this.element);
    }
}
