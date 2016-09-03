package me.mmnoda.rpg.domain.model.dice.factory;

import me.mmnoda.rpg.domain.model.rollable.SingleRollable;

import static me.mmnoda.rpg.domain.model.dice.Dice.of;
import static me.mmnoda.rpg.domain.model.dice.NumberOfFaces._100;
import static me.mmnoda.rpg.domain.model.dice.NumberOfFaces._6;

/**
 *
 */
public enum Dices implements DiceFactory {
    INSTANCE;

    private final SingleRollable D6 = of(_6);

    private final SingleRollable D100 = of(_100);

    @Override
    public SingleRollable getD6() {
        return D6;
    }

    @Override
    public SingleRollable getD100() {
        return D100;
    }
}
