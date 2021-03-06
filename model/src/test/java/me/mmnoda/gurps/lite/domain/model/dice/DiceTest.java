package me.mmnoda.gurps.lite.domain.model.dice;

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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class DiceTest {

    private Dice dice;

    private String valueFormatted;

    @Test
    public void should_format_D6() {
        with(NumberOfFaces._6);
        format();
        assertValueFormattedIsEqual("6");
    }

    @Test
    public void should_format_D100() {
        with(NumberOfFaces._100);
        format();
        assertValueFormattedIsEqual("100");
    }

    private void with(NumberOfFaces numberOfFaces) {
        dice = Dice.of(numberOfFaces);
    }

    private void format() {
        valueFormatted = String.format("%s", dice);
    }

    private void assertValueFormattedIsEqual(String expected) {
        assertThat(valueFormatted)
                .isNotNull()
                .isEqualTo(expected);
    }
}