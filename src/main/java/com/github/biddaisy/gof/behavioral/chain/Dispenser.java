package com.github.biddaisy.gof.behavioral.chain;

public record Dispenser(Dispenser nextDispenser, CurrencyNote currencyNote) {

    public void dispense(CurrencyAmount currencyAmount) throws DispensingException {
        int noteValue = currencyNote.getValue();
        if (currencyAmount.getAmount() >= noteValue) {
            int num = currencyAmount.getAmount() / noteValue;
            int remainder = currencyAmount.getAmount() % noteValue;
            System.out.printf("Dispensing %d x %d$ note%n", num, noteValue);
            if (remainder != 0 && hasNextDispenser())
                nextDispenser.dispense(new CurrencyAmount(remainder));
            else if (remainder != 0)
                throw new DispensingException(String.format("no notes to dispense remaining amount %d", remainder));
        } else {
            if (!hasNextDispenser())
                throw new DispensingException(String.format("no notes to dispense remaining amount %d", currencyAmount.getAmount()));
            nextDispenser.dispense(currencyAmount);
        }
    }

    private boolean hasNextDispenser() {
        return nextDispenser != null;
    }

}
