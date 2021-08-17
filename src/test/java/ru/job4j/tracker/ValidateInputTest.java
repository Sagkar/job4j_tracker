package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultiValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"1", "2", "3", "4"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
        selected = validateInput.askInt("Enter menu 2: ");
        assertThat(selected, is(2));
        selected = validateInput.askInt("Enter menu 3: ");
        assertThat(selected, is(3));
        selected = validateInput.askInt("Enter menu 4: ");
        assertThat(selected, is(4));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"-4"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(-4));
    }
}