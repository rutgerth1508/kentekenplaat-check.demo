package com.bovemij.kentekenplaat.check.demo.services;

import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResponse;

/**
 * Service for validating Dutch license plates
 */
public interface LicenseValidationService {

	/**
	 * Checks if a car license is valid
	 *
	 * @param license
	 * 		The string license
	 * @return The license validation response object
	 */
	LicenseValidationResponse validateLicense(final String license);
}
