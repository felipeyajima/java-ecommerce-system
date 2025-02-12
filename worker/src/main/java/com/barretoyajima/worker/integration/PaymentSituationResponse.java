package com.barretoyajima.worker.integration;

public class PaymentSituationResponse {
    private boolean approved;

    public PaymentSituationResponse(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


}
