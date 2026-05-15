public class QCStester {

    public static void main(String[] args) {

        // Create a 2-qubit system
        QuantumState qs = new QuantumState(2);

        System.out.println("Initial state:");
        qs.printState();

        // Build quantum circuit
        Qcircuit circuit = new Qcircuit();

        // Step 1: Put qubit 0 into superposition
        System.out.println("\nApplying Hadamard on qubit 0:");
        circuit.h(0);

        // Step 2: Entangle qubit 0 and 1
        System.out.println("Applying CNOT (0 -> 1):");
        circuit.cnot();

        // Execute circuit
        System.out.println("\nRunning circuit...");
        circuit.run(qs);

        System.out.println("\nState after circuit:");
        qs.printState();

        // Measure system
        System.out.println("\nMeasurement result:");
        int result = qs.measure();

        System.out.println("Measured state: |" + result + "⟩");

        System.out.println("\nFinal collapsed state:");
        qs.printState();
    }
}