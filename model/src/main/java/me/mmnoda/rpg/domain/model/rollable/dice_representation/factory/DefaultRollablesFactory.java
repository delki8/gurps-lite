package me.mmnoda.rpg.domain.model.rollable.dice_representation.factory;

/*
 * #%L
 * model
 * %%
 * Copyright (C) 2015 - 2016 Márcio Noda
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import me.mmnoda.rpg.domain.model.dice.factory.Dices;
import me.mmnoda.rpg.domain.model.rollable.dice_representation.DefaultDiceRepresentation;
import me.mmnoda.rpg.domain.model.rollable.dice_representation.DiceRepresentation;

import static me.mmnoda.rpg.domain.model.dice.NumberOfDices.THREE;

/**
 *
 */
public enum DefaultRollablesFactory implements RollablesFactory {
    INSTANCE;

    @Override
    public final DiceRepresentation build3D6() {
        return DefaultDiceRepresentation
                .of(Dices.D6.getInstance(), THREE);
    }
}
