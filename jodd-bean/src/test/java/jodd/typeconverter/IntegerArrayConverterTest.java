// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.typeconverter;

import jodd.typeconverter.impl.IntegerArrayConverter;
import org.junit.Test;

import static jodd.typeconverter.TypeConverterTestHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntegerArrayConverterTest {

	@Test
	public void testConversion() {
		IntegerArrayConverter integerArrayConverter = (IntegerArrayConverter) TypeConverterManager.lookup(int[].class);

		assertNull(integerArrayConverter.convert(null));

		assertEq(arri(173, 234), integerArrayConverter.convert("173, 234"));
		assertEq(arri(173), integerArrayConverter.convert(Double.valueOf(173)));
		assertEq(arri(1, 7, 3), integerArrayConverter.convert(arri(1, 7, 3)));
		assertEq(arri(1, 7, 3), integerArrayConverter.convert(arrl(1, 7, 3)));
		assertEq(arri(1, 7, 3), integerArrayConverter.convert(arrf(1, 7, 3)));
		assertEq(arri(1, 7, 3), integerArrayConverter.convert(arrd(1.1, 7.99, 3)));
		assertEq(arri(173, 1022), integerArrayConverter.convert(arrs("173", "1022")));
		assertEq(arri(173, 10), integerArrayConverter.convert(arro("173", Integer.valueOf(10))));

		assertEq(arri(111, 777, 333), integerArrayConverter.convert(arrs("111", "   777     ", "333")));
		assertEq(arri(111, 777, 333), integerArrayConverter.convert("111,  777,  333"));

	}

	private void assertEq(int[] arr1, int[] arr2) {
		assertEquals(arr1.length, arr2.length);
		for (int i = 0; i < arr1.length; i++) {
			assertEquals(arr1[i], arr2[i]);
		}
	}

}

