package com.bovemij.kentekenplaat.check.demo.model;

public class LicenseValidationResponse {

	private boolean valid;

	private LicenseValidationResult licenseValidationResult;

	public boolean isValid() {
		return valid;
	}

	public void setValid(final boolean valid) {
		this.valid = valid;
	}

	public LicenseValidationResult getLicenseValidationResult() {
		return licenseValidationResult;
	}

	public void setLicenseValidationResult(final LicenseValidationResult licenseValidationResult) {
		this.licenseValidationResult = licenseValidationResult;
	}
}
