package me.mmnoda.rpg.domain.model.action.factory;

import me.mmnoda.rpg.domain.model.action.ActionRoller;
import me.mmnoda.rpg.domain.model.action.critical.CriticalDetermination;
import me.mmnoda.rpg.domain.model.action.critical.CriticalDeterminationFactory;
import org.junit.Test;

import static me.mmnoda.rpg.domain.model.action.factory.SimpleActionRoller3DFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class SimpleActionRoller3DFactoryTest {

    private SimpleActionRoller3DFactory factory;

    private ActionRoller actionRoller;
    private final CriticalDeterminationFactory determinationFactory = CriticalDeterminationFactory.INSTANCE;

    @Test
    public void should_build_default_action_roller() {
        factory = DEFAULT;
        build(determinationFactory.buildOnlyNatural());
        assertActionRollerIsNotNull();
    }

    @Test
    public void should_build_max_value_action_roller() {
        factory = MAX_VALUE_ROLL;
        build(determinationFactory.buildDefault());
        assertActionRollerIsNotNull();
    }

    @Test
    public void should_build_min_value_action_roller() {
        factory = MIN_VALUE_ROLL;
        build(determinationFactory.buildOnlyNatural());
        assertActionRollerIsNotNull();
    }

    @Test
    public void should_build_avg_value_action_roller() {
        factory = AVG_VALUE_ROLL;
        build(determinationFactory.buildOnlyNatural());
        assertActionRollerIsNotNull();
    }

    @Test
    public void should_build_best_of_3_rolls_action_roller() {
        factory = BEST_OF_3_ROLLS;
        build(determinationFactory.buildDefault());
        assertActionRollerIsNotNull();
    }

    @Test
    public void should_build_worst_of_3_rolls_action_roller() {
        factory = WORST_OF_3_ROLLS;
        build(determinationFactory.buildOnlyNatural());
        assertActionRollerIsNotNull();
    }

    private void assertActionRollerIsNotNull() {
        assertThat(actionRoller)
                .isNotNull();
    }

    private void build(CriticalDetermination criticalDetermination) {
        actionRoller = factory.build(criticalDetermination);
    }
}