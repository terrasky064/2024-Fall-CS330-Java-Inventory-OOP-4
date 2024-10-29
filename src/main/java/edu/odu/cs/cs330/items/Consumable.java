package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
        "PMD.CloneMethodReturnTypeMustMatchClassName",
        "PMD.CloneThrowsCloneNotSupportedException",
        "PMD.LawOfDemeter",
        "PMD.OnlyOneReturn",
        "PMD.ProperCloneImplementation",
        "PMD.MethodArgumentCouldBeFinal",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.BeanMembersShouldSerialize"
})
public class Consumable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
            System.lineSeparator(),
            "  Nme: %s",
            "  Eft: %s",
            "  Use: %d",
            "");

    /**
     * The name of the consumable item.
     */
    protected String name;

    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect, and zero uses.
     */
    public Consumable() {
        this.name = "[Placeholder]";
        this.effect = "[Placeholder]";
        this.uses = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String nme) {
        this.name = nme;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect() {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     *
     * @param newEff replacement effect
     */
    public void setEffect(String newEff) {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses() {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     *
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed) {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone() {
        Consumable cpy = new Consumable();
        cpy.name = this.name;
        cpy.effect = this.effect;
        cpy.uses = this.uses;
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Consumable)) {
            return false;
        }

        Consumable rhsItem = (Consumable) rhs;

        return Objects.equals(this.name, rhsItem.name) &&
                Objects.equals(this.effect, rhsItem.effect);
    }

    /**
     * Generate a hash code based on name, effect, and uses.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.effect);
    }

    /**
     * Print the Consumable Item.
     */
    @Override
    public String toString() {
        return String.format(FMT_STR, this.name, this.effect, this.uses);
    }
}
