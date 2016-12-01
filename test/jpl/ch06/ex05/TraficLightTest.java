package jpl.ch06.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class TraficLightTest {

	@Test
	public void testGetColor() {
		assertThat(TraficLight.RED.getColor(), is(Color.RED));
		assertThat(TraficLight.BLUE.getColor(), is(Color.BLUE));
		assertThat(TraficLight.YELLOW.getColor(), is(Color.YELLOW));
	}

}
