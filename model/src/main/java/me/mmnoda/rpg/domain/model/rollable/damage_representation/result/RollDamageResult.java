package me.mmnoda.rpg.domain.model.rollable.damage_representation.result;

/*
 * #%L
 * model
 * %%
 * Copyright (C) 2016 Márcio Noda
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

import me.mmnoda.rpg.domain.model.damage.Damage;
import me.mmnoda.rpg.domain.model.damage.DamageType;
import me.mmnoda.rpg.domain.model.rollable.dice_representation.result.RollResultSum;

import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

/**
 *
 */
public class RollDamageResult implements Formattable {

    private final RollResultSum rollResultSum;

    private final DamageType damageType;

    private RollDamageResult(RollResultSum rollResultSum, DamageType damageType) {
        this.rollResultSum = rollResultSum;
        this.damageType = damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollResultSum, damageType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof RollDamageResult) {
            final RollDamageResult other = (RollDamageResult) obj;
            return Objects.equals(this.rollResultSum, other.rollResultSum)
                    && Objects.equals(this.damageType, other.damageType);
        }

        return false;
    }

    public static RollDamageResult of(RollResultSum rollResultSum, DamageType damageType) {
        return new RollDamageResult(rollResultSum, damageType);
    }

    public Damage toDamage() {
        return rollResultSum.toDamage(damageType);
    }

    public RollDamageResult doubleValue() {
        return RollDamageResult.of(rollResultSum.doubleValue(), damageType);
    }

    public RollDamageResult tripleValue() {
        return RollDamageResult.of(rollResultSum.tripleValue(), damageType);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%s %s", rollResultSum, damageType);
    }
}
