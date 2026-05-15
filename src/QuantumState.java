import java.util.Random;

class QuantumState {

    private Vector state;
    private int numQubits;
    private static final Random rand = new Random();

    // ----------------------------
    // Constructor: initialize |00...0>
    // ----------------------------
    public QuantumState(int numQubits) {
        this.numQubits = numQubits;

        int size = (int) Math.pow(2, numQubits);
        complexNum[] init = new complexNum[size];

        // all amplitudes = 0
        for (int i = 0; i < size; i++) {
            init[i] = new complexNum(0, 0);
        }

        // |0...0> = 1 amplitude at index 0
        init[0] = new complexNum(1, 0);

        state = new Vector(init);
    }

    // ----------------------------
    // Apply quantum gate (matrix x vector)
    // ----------------------------
    public void apply(Matrix gate) {
        state = LinearAlgebraWcomplexNums.multiply(gate, state);
    }

    // ----------------------------
    // normalize state (probabilities)
    // ----------------------------
    public void normalize() {
        double norm = LinearAlgebraWcomplexNums.norm(state);

        for (int i = 0; i < state.size(); i++) {
            state.data[i] = state.data[i].divide(new complexNum(norm, 0));
        }
    }

    // ----------------------------
    // Measurement (collapse state)
    // ----------------------------
    public int measure() {

        normalize();

        double[] probabilities = new double[state.size()];
        double sum = 0;

        for (int i = 0; i < state.size(); i++) {
            probabilities[i] = state.data[i].magnitude() 
                              * state.data[i].magnitude();
            sum += probabilities[i];
        }

        double r = rand.nextDouble();
        double cumulative = 0;

        int result = 0;

        for (int i = 0; i < probabilities.length; i++) {
            cumulative += probabilities[i] / sum;

            if (r <= cumulative) {
                result = i;
                break;
            }
        }

        // collapse state to measured outcome
        for (int i = 0; i < state.size(); i++) {
            state.data[i] = new complexNum(0, 0);
        }

        state.data[result] = new complexNum(1, 0);

        return result;
    }

    // ----------------------------
    // Get current state
    // ----------------------------
    public Vector getState() {
        return state;
    }

    public int getNumQubits() {
        return numQubits;
    }

    // ----------------------------
    // Print state
    // ----------------------------
    public void printState() {
        for (int i = 0; i < state.size(); i++) {
            System.out.println("|" + i + "⟩ : " + state.data[i]);
        }
    }
}