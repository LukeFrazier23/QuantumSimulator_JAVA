import java.util.ArrayList;

public class Qcircuit {

    // ----------------------------
    // Operation container
    // ----------------------------
    private static class Operation {
        Matrix gate;
        int target; // -1 means already full-system matrix

        Operation(Matrix gate, int target) {
            this.gate = gate;
            this.target = target;
        }
    }

    private ArrayList<Operation> operations;

    // Constructor
    public Qcircuit() {
        this.operations = new ArrayList<>();
    }

    // ----------------------------
    // Raw add (assumes full-system gate)
    // ----------------------------
    public void add(Matrix gate) {
        operations.add(new Operation(gate, -1));
    }

    // ----------------------------
    // Single-qubit gate helpers (NOW INDEXED)
    // ----------------------------
    public void h(int qubit) {
        operations.add(new Operation(QuantumGates.H(), qubit));
    }

    public void x(int qubit) {
        operations.add(new Operation(QuantumGates.X(), qubit));
    }

    public void y(int qubit) {
        operations.add(new Operation(QuantumGates.Y(), qubit));
    }

    public void z(int qubit) {
        operations.add(new Operation(QuantumGates.Z(), qubit));
    }

    public void s(int qubit) {
        operations.add(new Operation(QuantumGates.S(), qubit));
    }

    public void t(int qubit) {
        operations.add(new Operation(QuantumGates.T(), qubit));
    }

    // ----------------------------
    // Two-qubit gates (already full-system matrices)
    // ----------------------------
    public void cnot() {
        operations.add(new Operation(QuantumGates.CNOT(), -1));
    }

    public void swap() {
        operations.add(new Operation(QuantumGates.SWAP(), -1));
    }

    public void cz() {
        operations.add(new Operation(QuantumGates.CZ(), -1));
    }

    // ----------------------------
    // Rotation gates (apply to single qubit)
    // ----------------------------
    public void rx(int qubit, double theta) {
        operations.add(new Operation(QuantumGates.RX(theta), qubit));
    }

    public void ry(int qubit, double theta) {
        operations.add(new Operation(QuantumGates.RY(theta), qubit));
    }

    public void rz(int qubit, double theta) {
        operations.add(new Operation(QuantumGates.RZ(theta), qubit));
    }

    // ----------------------------
    // Execute circuit on quantum state
    // ----------------------------
    public void run(QuantumState qs) {

        int n = qs.getNumQubits();

        for (Operation op : operations) {

            Matrix finalGate;

            if (op.target == -1) {
                finalGate = op.gate;
            } else {
                finalGate = LinearAlgebraWcomplexNums.expandSingleQubitGate(
                        op.gate,
                        op.target,
                        n
                );
            }

            qs.apply(finalGate);
        }
    }

    // Optional: clear circuit
    public void clear() {
        operations.clear();
    }

    // Optional: number of operations
    public int size() {
        return operations.size();
    }
}