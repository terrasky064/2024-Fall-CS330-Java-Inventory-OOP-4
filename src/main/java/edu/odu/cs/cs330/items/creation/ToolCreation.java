package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;

@SuppressWarnings({
        "PMD.AtLeastOneConstructor"
})
public class ToolCreation implements ItemCreationStrategy {

    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ToolCreation construct() {
        return new ToolCreation();
    }

    @Override
    public Item fromDefaults() {
        return new Tool();
    }

    @Override
    public int requiredNumberOfValues() {
        return 6; // As Tool has 6 attributes to set
    }

    @SuppressWarnings({
            "PMD.LawOfDemeter",
            "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens) {
        if (tokens.length != requiredNumberOfValues()) {
            throw new IllegalArgumentException("Expected " + requiredNumberOfValues() + " tokens.");
        }

        Tool tool = new Tool();
        tool.setName(tokens[0]);
        tool.setMaterial(tokens[1]);
        tool.setDurability(Integer.parseInt(tokens[2]));
        tool.setSpeed(Integer.parseInt(tokens[3]));
        tool.setModifier(tokens[4]);
        tool.setModifierLevel(Integer.parseInt(tokens[5]));

        return tool;
    }

    @Override
    public Item fromExisting(final Item original) {
        if (!(original instanceof Tool)) {
            throw new IllegalArgumentException("Original item is not a Tool instance.");
        }
        return (Tool) original.clone();
    }
}
