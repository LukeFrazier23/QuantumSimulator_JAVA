class QuantumGates {

    // ----------------------------
    // Identity gate (1 qubit)
    // ----------------------------
    public static Matrix I() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(1, 0) }
        });
    }

    // ----------------------------
    // Pauli-X (NOT gate)
    // ----------------------------
    public static Matrix X() {
        return new Matrix(new complexNum[][]{
            { new complexNum(0, 0), new complexNum(1, 0) },
            { new complexNum(1, 0), new complexNum(0, 0) }
        });
    }

    // ----------------------------
    // Pauli-Z
    // ----------------------------
    public static Matrix Z() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0),  new complexNum(0, 0) },
            { new complexNum(0, 0),  new complexNum(-1, 0) }
        });
    }

    // ----------------------------
    // Pauli-Y
    // ----------------------------
    public static Matrix Y() {
        return new Matrix(new complexNum[][]{
            { new complexNum(0, 0),  new complexNum(0, -1) },
            { new complexNum(0, 1),  new complexNum(0, 0) }
        });
    }

    // ----------------------------
    // Hadamard gate (H)
    // ----------------------------
    public static Matrix H() {
        double s = 1.0 / Math.sqrt(2);

        return new Matrix(new complexNum[][]{
            { new complexNum(s, 0),  new complexNum(s, 0) },
            { new complexNum(s, 0),  new complexNum(-s, 0) }
        });
    }

    // ----------------------------
    // CNOT gate (4x4 matrix)
    // Control qubit = first qubit
    // Target qubit = second qubit
    // ----------------------------
    public static Matrix CNOT() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(1, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0) }
        });
    }
    // ----------------------------
    // Phase gate (S)
    // ----------------------------
    public static Matrix S() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 1) }
        });
    }

    // ----------------------------
    // T gate (π/8 phase gate)
    // ----------------------------
    public static Matrix T() {
        double angle = Math.PI / 4;
        complexNum phase = new complexNum(Math.cos(angle), Math.sin(angle));

        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), phase }
        });
    }

    // ----------------------------
    // SWAP gate (2-qubit)
    // ----------------------------
    public static Matrix SWAP() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(1, 0) }
        });
    }

    // ----------------------------
    // Controlled-Z (CZ) gate
    // ----------------------------
    public static Matrix CZ() {
        return new Matrix(new complexNum[][]{
            { new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(1, 0), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(0, 0), new complexNum(0, 0), new complexNum(-1, 0) }
        });
    }

    // ----------------------------
    // Rotation gates (single qubit)
    // ----------------------------

    public static Matrix RX(double theta) {
        double c = Math.cos(theta / 2.0);
        double s = Math.sin(theta / 2.0);

        return new Matrix(new complexNum[][]{
            { new complexNum(c, 0), new complexNum(0, -s) },
            { new complexNum(0, -s), new complexNum(c, 0) }
        });
    }

    public static Matrix RY(double theta) {
        double c = Math.cos(theta / 2.0);
        double s = Math.sin(theta / 2.0);

        return new Matrix(new complexNum[][]{
            { new complexNum(c, 0), new complexNum(-s, 0) },
            { new complexNum(s, 0), new complexNum(c, 0) }
        });
    }

    public static Matrix RZ(double theta) {
        double c = Math.cos(theta / 2.0);
        double s = Math.sin(theta / 2.0);

        return new Matrix(new complexNum[][]{
            { new complexNum(c, -s), new complexNum(0, 0) },
            { new complexNum(0, 0), new complexNum(c, s) }
        });
    }
}