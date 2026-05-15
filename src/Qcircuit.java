import java.util.ArrayList;

public class Qcircuit {

    private ArrayList<Matrix> operations;

    // Constructor
    public Qcircuit() {
        this.operations = new ArrayList<>();
    }

    // Add raw matrix to the circuit
    public void add(Matrix gate) {
        operations.add(gate);
    }

    // ----------------------------
    // Standard single-qubit gates
    // ----------------------------
    public void h() {
        operations.add(QuantumGates.H());
    }

    public void x() {
        operations.add(QuantumGates.X());
    }

    public void y() {
        operations.add(QuantumGates.Y());
    }

    public void z() {
        operations.add(QuantumGates.Z());
    }

    public void s() {
        operations.add(QuantumGates.S());
    }

    public void t() {
        operations.add(QuantumGates.T());
    }

    // ----------------------------
    // Two-qubit gates
    // ----------------------------
    public void cnot() {
        operations.add(QuantumGates.CNOT());
    }

    public void swap() {
        operations.add(QuantumGates.SWAP());
    }

    public void cz() {
        operations.add(QuantumGates.CZ());
    }

    // ----------------------------
    // Rotation gates
    // ----------------------------
    public void rx(double theta) {
        operations.add(QuantumGates.RX(theta));
    }

    public void ry(double theta) {
        operations.add(QuantumGates.RY(theta));
    }

    public void rz(double theta) {
        operations.add(QuantumGates.RZ(theta));
    }

    // ----------------------------
    // Execute circuit on quantum state
    // ----------------------------
    public void run(QuantumState qs) {
        for (Matrix gate : operations) {
            qs.apply(gate);
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
//currently only works in 1 qubit systems