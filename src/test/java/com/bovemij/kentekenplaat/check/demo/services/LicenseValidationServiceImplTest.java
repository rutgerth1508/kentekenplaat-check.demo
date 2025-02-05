package com.bovemij.kentekenplaat.check.demo.services;

import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResponse;
import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LicenseValidationServiceImplTest {

	@Autowired
	private LicenseValidationServiceImpl licenseValidationService;

	@Test
	public void testValidateLicense_validLicenses() {
		final String validLicense = "DE-12-34";
		final String validLicense2 = "43-LS-20";
		final String validLicense3 = "85-IE-52";
		final String validLicense4 = "58-HD-21";

		final LicenseValidationResponse licenseValidationResponse = licenseValidationService.validateLicense(validLicense);
		final LicenseValidationResponse licenseValidationResponse2 = licenseValidationService.validateLicense(validLicense2);
		final LicenseValidationResponse licenseValidationResponse3 = licenseValidationService.validateLicense(validLicense3);
		final LicenseValidationResponse licenseValidationResponse4 = licenseValidationService.validateLicense(validLicense4);

		assertNotNull(licenseValidationResponse);
		assertNotNull(licenseValidationResponse2);
		assertNotNull(licenseValidationResponse3);
		assertNotNull(licenseValidationResponse4);

		assertEquals(LicenseValidationResult.REGULAR, licenseValidationResponse.getLicenseValidationResult());
		assertEquals(LicenseValidationResult.REGULAR, licenseValidationResponse2.getLicenseValidationResult());
		assertEquals(LicenseValidationResult.REGULAR, licenseValidationResponse3.getLicenseValidationResult());
		assertEquals(LicenseValidationResult.REGULAR, licenseValidationResponse4.getLicenseValidationResult());

		assertTrue(licenseValidationResponse.isValid());
		assertTrue(licenseValidationResponse2.isValid());
		assertTrue(licenseValidationResponse3.isValid());
		assertTrue(licenseValidationResponse4.isValid());
	}

	@Test
	public void testValidateLicense_invalidLicense() {
		final String invalidLicense = "DE-DE-DE";
		final String invalidLicense2 = "43-12-20";
		final String invalidLicense3 = "1341IE90";
		final LicenseValidationResponse licenseValidationResponse = licenseValidationService.validateLicense(invalidLicense);
		final LicenseValidationResponse licenseValidationResponse2 = licenseValidationService.validateLicense(invalidLicense2);
		final LicenseValidationResponse licenseValidationResponse3 = licenseValidationService.validateLicense(invalidLicense3);

		assertNotNull(licenseValidationResponse);
		assertNotNull(licenseValidationResponse2);
		assertNotNull(licenseValidationResponse3);

		assertNull(licenseValidationResponse.getLicenseValidationResult());
		assertNull(licenseValidationResponse2.getLicenseValidationResult());
		assertNull(licenseValidationResponse3.getLicenseValidationResult());

		assertFalse(licenseValidationResponse.isValid());
		assertFalse(licenseValidationResponse2.isValid());
		assertFalse(licenseValidationResponse3.isValid());
	}

	@Test
	public void testValidateLicense_typeCheck() {
		final String royalLicense = "AA-12-34";
		final String diplomaticLicense = "CD-29-20";

		final LicenseValidationResponse royalResponse = licenseValidationService.validateLicense(royalLicense);
		final LicenseValidationResponse diplomaticResponse = licenseValidationService.validateLicense(diplomaticLicense);

		assertNotNull(royalResponse);
		assertNotNull(diplomaticResponse);

		assertEquals(LicenseValidationResult.ROYAL, royalResponse.getLicenseValidationResult());
		assertEquals(LicenseValidationResult.DIPLOMATIC, diplomaticResponse.getLicenseValidationResult());
	}

	@Test
	public void testValidateLicense_nullCheck() {
		final LicenseValidationResponse licenseValidationResponse = licenseValidationService.validateLicense(null);

		assertNotNull(licenseValidationResponse);
		assertNull(licenseValidationResponse.getLicenseValidationResult());
		assertFalse(licenseValidationResponse.isValid());
	}

}