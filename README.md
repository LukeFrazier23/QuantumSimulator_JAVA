Quantum Computer Simulator (work in progress)

Overview
This is a Java based quantum computing simulator built from scratch. It models quantum systems using complex numbers, linear algebra, and a circuit-based execution model. The project focuses on showing how quantum computation can be represented using matrices and vectors without external quantum libraries.

The system now supports a basic quantum circuit architecture, including single-qubit gates, two-qubit gates, tensor products, and measurement-based state collapse.

⸻

Project Structure

Complex Number Implementation (complexNum)
This class handles complex arithmetic, which is required for representing quantum amplitudes.

Features include:
• Creation of complex numbers (real and imaginary parts)
• Addition, subtraction, multiplication, and division
• Magnitude calculation
• Complex conjugation
• Equality checking
• String formatting

Complex numbers are used throughout the simulator to represent probability amplitudes in quantum states.

⸻

Linear Algebra System (LinearAlgebraWcomplexNums)
This class implements the core mathematical operations required for quantum simulation.

Implemented operations:
• Matrix-vector multiplication (applying gates to states)
• Matrix-matrix multiplication
• Vector dot product (with complex conjugation)
• Vector norm (used for normalization)
• Scalar multiplication (vectors and matrices)
• Identity matrix generation
• Transpose and Hermitian (conjugate transpose)
• Tensor product (Kronecker product for multi-qubit systems)
• Expansion of single-qubit gates into n-qubit systems

This layer is the mathematical engine of the simulator.

⸻

Quantum State System (QuantumState)
This class represents a full quantum system of n qubits using a state vector of size 2^n.

Key functionality:
• Initializes the system in the |00…0⟩ state
• Applies quantum gates through matrix-vector multiplication
• Normalizes states to maintain valid probability distributions
• Performs probabilistic measurement and state collapse
• Prints the current state vector

Measurement is based on the squared magnitude of amplitudes, producing classical outcomes from quantum states.

⸻

Quantum Gates (Qgates)
This class defines standard quantum gate matrices used in the simulator.

Currently implemented gates include:
• Pauli-X, Y, Z
• Hadamard (H)
• S and T gates
• Rotation gates (RX, RY, RZ)
• CNOT (controlled NOT)
• CZ (controlled Z)
• SWAP

Some gates are defined as fixed matrices for 2-qubit systems, while single-qubit gates are expanded dynamically using tensor products.

⸻

Quantum Circuit System (Qcircuit)
This class acts as a quantum program builder.

Instead of applying gates directly to a state, it stores a sequence of operations and executes them in order.

Key features:
• Stores ordered list of quantum operations
• Supports single-qubit gate targeting (e.g. h(0), x(1))
• Supports two-qubit gates such as CNOT, SWAP, and CZ
• Expands single-qubit gates into full system matrices automatically
• Executes the full circuit on a QuantumState object

The circuit model separates “building a program” from “running the simulation.”

⸻

Tester Program (QCStester)
This class demonstrates how the simulator works.

It:
• Creates a quantum state
• Builds a quantum circuit
• Applies gates (Hadamard and CNOT)
• Executes the circuit
• Prints the resulting state
• Performs measurement and shows collapse

It is mainly used for testing and demonstrating quantum behavior such as superposition and entanglement.

⸻

Design Notes
• Quantum states are represented as complex vectors
• Quantum gates are matrices applied through linear algebra
• Multi-qubit behavior is built using tensor products
• Single-qubit gates are expanded into larger systems dynamically
• Two-qubit gates currently operate as fixed matrices (2-qubit scope)
• Measurement collapses the state probabilistically based on amplitude squares

⸻

Requirements
Java 8 or higher

⸻

Notes
This project is implemented entirely from scratch without external quantum computing or linear algebra libraries. The goal is to clearly show how quantum computation can be built from fundamental mathematical operations and structured into a circuit-based simulation model.
