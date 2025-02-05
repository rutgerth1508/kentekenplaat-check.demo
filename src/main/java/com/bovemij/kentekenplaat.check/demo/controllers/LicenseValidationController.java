package com.bovemij.kentekenplaat.check.demo.controllers;

import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResponse;
import com.bovemij.kentekenplaat.check.demo.services.LicenseValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for validating Dutch license plates
 */

@RestController
public class LicenseValidationController {

	@Autowired
	private LicenseValidationService licenseValidationService;

	/**
	 * GET request for validating the license plate
	 *
	 * @param licensePlate
	 * 		The string license plate
	 * @return The license validation response object
	 */
	@GetMapping("/api/license-plates/{licensePlate}/validate")
	public LicenseValidationResponse validateLicensePlate(@PathVariable final String licensePlate) {
		return licenseValidationService.validateLicense(licensePlate);
	}
}
