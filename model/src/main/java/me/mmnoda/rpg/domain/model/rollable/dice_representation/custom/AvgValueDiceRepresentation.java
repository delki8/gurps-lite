package me.mmnoda.rpg.domain.model.rollable.dice_representation.custom;

import me.mmnoda.rpg.domain.model.dice.NumberOfDices;
import me.mmnoda.rpg.domain.model.dice.NumberOfFaces;
import me.mmnoda.rpg.domain.model.dice.result.SingleRollResult;
import me.mmnoda.rpg.domain.model.rollable.dice_representation.DiceRepresentation;
import me.mmnoda.rpg.domain.model.rollable.dice_representation.result.RollResultSum;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 *
 */
public class AvgValueDiceRepresentation extends AbstractDiceRepresentationOverrideRollResult {

    private AvgValueDiceRepresentation(DiceRepresentation decorated) {
        super(decorated);
    }

    public static AvgValueDiceRepresentation of(DiceRepresentation decorated) {
        return new AvgValueDiceRepresentation(decorated);
    }

    @Override
    protected void customizeRoll(RollResultSum.Builder builder, NumberOfDices numberOfDices, NumberOfFaces numberOfFaces) {
        for (NumberOfDices numberOfDice : numberOfDices) {
            builder.add(SingleRollResult.of(numberOfDices.avgDiceSum(numberOfFaces).toBigInteger())
                    .normalize(numberOfDice));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(decorated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o instanceof AvgValueDiceRepresentation) {
            final AvgValueDiceRepresentation other = (AvgValueDiceRepresentation) o;
            return Objects.equals(this.decorated, other.decorated);
        }

        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("decorated", decorated)
                .toString();
    }

}