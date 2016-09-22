/**
 * Copyright 2016 Shane Isbell
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.stackwire.fca.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;
import org.stackwire.fca.operators.AttributesCommonToObjectsFunction;

public class AttributesCommonToObjectsFunctionTest {

	private static final int[][] relations = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 },
			{ 0, 1, 0, 0 } };
	@Test
	public void all() throws Exception {
		AttributesCommonToObjectsFunction function = new AttributesCommonToObjectsFunction(relations);
		Set<Integer> result = function.apply(Arrays.asList(1, 3));		
		assertThat(result, hasItems(0, 1, 2, 3));
	}
	
	@Test
	public void intersection() throws Exception {
		AttributesCommonToObjectsFunction function = new AttributesCommonToObjectsFunction(relations);
		Set<Integer> result = function.apply(Arrays.asList(1, 2));		
		assertThat(result, hasItems(1, 2));
	}
	
	@Test
	public void empty() throws Exception {
		AttributesCommonToObjectsFunction function = new AttributesCommonToObjectsFunction(relations);
		Set<Integer> result = function.apply(Arrays.asList(0));		
		assertEquals(0, result.size());
	}
}