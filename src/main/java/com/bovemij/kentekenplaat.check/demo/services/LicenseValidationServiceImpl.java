package com.bovemij.kentekenplaat.check.demo.services;

import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResponse;
import com.bovemij.kentekenplaat.check.demo.model.LicenseValidationResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LicenseValidationServiceImpl implements LicenseValidationService {
	@Override
	public LicenseValidationResponse validateLicense(final String license) {
		final LicenseValidationResponse response = new LicenseValidationResponse();
		final LicenseValidationResult result = validateLicensePlate(license);

		if (result != null) {
			response.setValid(true);
			response.setLicenseValidationResult(result);
		}

		return response;
	}

	private static LicenseValidationResult validateLicensePlate(final String licensePlate) {
		if (StringUtils.isBlank(licensePlate)) {
			return null;
		}

		// Define regex patterns for the valid formats
		final String pattern1 = "^[A-Z]{2}-\\d{2}-\\d{2}$"; // XX-99-99
		final String pattern2 = "^\\d{2}-[A-Z]{2}-\\d{2}$"; // 99-XX-99
		final String pattern3 = "^\\d{2}-\\d{2}-[A-Z]{2}$"; // 99-99-XX
		final String pattern4 = "^\\d{2}-[A-Z]{3}-\\d$";   // 99-XXX-9

		// Check if the license plate matches any of the valid formats
		if (Pattern.matches(pattern1, licensePlate) || Pattern.matches(pattern2, licensePlate) || Pattern.matches(
				pattern3, licensePlate) || Pattern.matches(pattern4, licensePlate)) {

			// Extract the prefix to determine the type
			final String prefix = StringUtils.split(licensePlate, "-")[0];

			if (prefix.equals("AA")) {
				return LicenseValidationResult.ROYAL;
			} else if (prefix.equals("CD")) {
				return LicenseValidationResult.DIPLOMATIC;
			} else {
				return LicenseValidationResult.REGULAR;
			}
		}

		// If no valid format is matched, return null
		return null;
	}
}
