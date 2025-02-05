package com.bovemij.kentekenplaat.check.demo.controllers;

import com.bovemij.kentekenplaat.check.demo.services.LicenseValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LicenseValidationControllerTest {

	@Mock
	private LicenseValidationService licenseValidationService;

	@InjectMocks
	private LicenseValidationController licenseValidationController;

	@Test
	public void testValidateLicensePlate() {
		final String licensePlate = "123456789";

		licenseValidationController.validateLicensePlate(licensePlate);

		verify(licenseValidationService, times(1)).validateLicense(licensePlate);
	}

}