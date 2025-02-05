package com.bovemij.kentekenplaat.check.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LicenseValidationResponseTest {

	@Test
	public void testGettersSetters() {
		final LicenseValidationResult result = LicenseValidationResult.DIPLOMATIC;

		final LicenseValidationResponse response = new LicenseValidationResponse();
		response.setValid(true);
		response.setLicenseValidationResult(result);

		assertTrue(response.isValid());
		assertEquals(result, response.getLicenseValidationResult());
	}

}