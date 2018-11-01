package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.impl.PossibleSphereDataKeeper;

import java.util.Objects;

public class SphereValidationResult {

    private PossibleSphereDataKeeper result;
    private String error;

    public PossibleSphereDataKeeper getResult() {
        return result;
    }

    public void setResult(PossibleSphereDataKeeper result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        SphereValidationResult guest = (SphereValidationResult) object;

        return result == guest.result &&
                Objects.equals(error, guest.error);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.result.hashCode();
        result = prime * result + error.hashCode();
        return result;
    }
}
