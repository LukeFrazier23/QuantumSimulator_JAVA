Quantum Computer Simulator (unfinished)
Overview
Java based implementation of complex linear algebra designed to support quantum state simulation. It includes support for complex numbers, vector and matrix operations, and a quantum state system capable of simulating measurement and unitary transformations.
The goal of this project is to provide a foundational mathematical engine for quantum computing simulations using standard linear algebra constructs.

Project Structure
The project consists of three main components:
Complex Number Implementation (complexNum)
This class implements arithmetic for complex numbers, which are required for representing quantum amplitudes.
Features include:
•	Construction of complex numbers with real and imaginary parts
•	Addition, subtraction, multiplication, and division
•	Magnitude calculation
•	Complex conjugation
•	Equality comparison
•	String representation
Complex numbers are used throughout the vector and matrix system to represent quantum amplitudes.

Linear Algebra with Complex Numbers (LinearAlgebraWcomplexNums)
This class provides core linear algebra operations using complex numbers.
Implemented operations:
•	Matrix-vector multiplication
•	Matrix-matrix multiplication
•	Complex inner product (dot product with conjugation)
•	Vector norm (Euclidean magnitude)
•	Scalar multiplication for vectors and matrices
•	Identity matrix generation
•	Matrix transpose
•	Hermitian (conjugate transpose)
These operations form the mathematical backbone of the quantum simulation system.

Quantum State System (QuantumState)
This class represents a quantum system of n qubits using a complex vector of size 2^n.
Key functionality:
•	Initializes a quantum state in the |00…0⟩ basis state
•	Applies quantum gates using matrix-vector multiplication
•	Normalizes state vectors to ensure valid probability distributions
•	Performs measurement with probabilistic collapse
•	Outputs current quantum state
The measurement process uses probability amplitudes derived from the squared magnitude of complex numbers.

Design Notes
•	All quantum states are represented as vectors of complex numbers.
•	Quantum gates are represented as matrices applied to state vectors.
•	State evolution follows standard linear algebra operations.
•	Measurement collapses the system into a single basis state based on probability distribution.

Requirements
•	Java 8 or higher

Notes
This project is built from scratch without external linear algebra or quantum computing libraries. All mathematical operations are implemented manually to provide transparency into how quantum simulations operate at a low level.
