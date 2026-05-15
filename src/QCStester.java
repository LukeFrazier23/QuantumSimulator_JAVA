public class QCStester {

    public static void main(String[] args) {

        // Create a 1-qubit system
        QuantumState qs = new QuantumState(1);

        System.out.println("Initial state:");
        qs.printState();

        // Apply Hadamard gate (creating superposition)
        System.out.println("\nApplying Hadamard gate:");
        qs.apply(QuantumGates.H());
        qs.printState();

        // Apply Pauli-X (flip)
        System.out.println("\nApplying Pauli-X gate:");
        qs.apply(QuantumGates.X());
        qs.printState();

        // Measure the state
        System.out.println("\nMeasurement result:");
        int result = qs.measure();

        System.out.println("Measured state: |" + result + "⟩");
        System.out.println("\nFinal collapsed state:");
        qs.printState();
    }
}