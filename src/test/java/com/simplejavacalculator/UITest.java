package com.simplejavacalculator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    void ui_test() throws IOException {
        UI ui = new UI();

        ui.init();

        ui.writer(3.0);
        assertEquals(ui.reader(),3.);
    }

    @Test
    void ui_test2() throws IOException {
        UI ui = new UI();

        ui.init();

        ui.writer(Double.NaN);
        NumberFormatException thrown;
        thrown = (NumberFormatException) assertThrows(
                IllegalArgumentException.class,
                ui::reader);
    }
}