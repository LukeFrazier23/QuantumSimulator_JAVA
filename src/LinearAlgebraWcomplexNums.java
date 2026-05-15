class Vector {
    complexNum[] data;

    public Vector(int size) {
        data = new complexNum[size];
        for (int i = 0; i < size; i++) {
            data[i] = new complexNum();
        }
    }

    public Vector(complexNum[] data) {
        this.data = data;
    }

    public int size() {
        return data.length;
    }
}

class Matrix {
    complexNum[][] data;
    int rows;
    int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new complexNum[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = new complexNum();
            }
        }
    }

    public Matrix(complexNum[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }
}

class LinearAlgebraWcomplexNums {

    // Matrix-vector multiplication (complex)
    public static Vector multiply(Matrix m, Vector v) {
        if (m.cols != v.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[] result = new complexNum[m.rows];

        for (int i = 0; i < m.rows; i++) {
            complexNum sum = new complexNum(0, 0);

            for (int j = 0; j < m.cols; j++) {
                sum = sum.add(m.data[i][j].multiply(v.data[j]));
            }

            result[i] = sum;
        }

        return new Vector(result);
    }

    // Matrix-matrix multiplication (complex)
    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.cols != b.rows) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[][] result = new complexNum[a.rows][b.cols];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                complexNum sum = new complexNum(0, 0);

                for (int k = 0; k < a.cols; k++) {
                    sum = sum.add(a.data[i][k].multiply(b.data[k][j]));
                }

                result[i][j] = sum;
            }
        }

        return new Matrix(result);
    }

    // Dot product (quantum inner product with conjugation)
    public static complexNum dot(Vector a, Vector b) {
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum sum = new complexNum(0, 0);

        for (int i = 0; i < a.size(); i++) {
            sum = sum.add(a.data[i].conjugate().multiply(b.data[i]));
        }

        return sum;
    }

    // Vector norm (magnitude)
    public static double norm(Vector v) {
        complexNum sum = new complexNum(0, 0);

        for (int i = 0; i < v.size(); i++) {
            complexNum val = v.data[i];
            sum = sum.add(val.conjugate().multiply(val));
        }

        return Math.sqrt(sum.getReal());
    }

    // Scalar multiply (Vector)
    public static Vector scale(Vector v, complexNum s) {
        complexNum[] result = new complexNum[v.size()];

        for (int i = 0; i < v.size(); i++) {
            result[i] = v.data[i].multiply(s);
        }

        return new Vector(result);
    }

    // Scalar multiply (Matrix)
    public static Matrix scale(Matrix m, complexNum s) {
        complexNum[][] result = new complexNum[m.rows][m.cols];

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result[i][j] = m.data[i][j].multiply(s);
            }
        }

        return new Matrix(result);
    }

    // Identity matrix
    public static Matrix identity(int n) {
        complexNum[][] result = new complexNum[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = new complexNum(0, 0);
            }
            result[i][i] = new complexNum(1, 0);
        }

        return new Matrix(result);
    }

    // Transpose matrix (no conjugation)
    public static Matrix transpose(Matrix m) {
        complexNum[][] result = new complexNum[m.cols][m.rows];

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result[j][i] = m.data[i][j];
            }
        }

        return new Matrix(result);
    }

    // Hermitian (conjugate transpose)
    public static Matrix hermitian(Matrix m) {
        complexNum[][] result = new complexNum[m.cols][m.rows];

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result[j][i] = m.data[i][j].conjugate();
            }
        }

        return new Matrix(result);
    }

    // Tensor product (Kronecker product) for matrices
    public static Matrix tensor(Matrix a, Matrix b) {

        int rows = a.rows * b.rows;
        int cols = a.cols * b.cols;

        complexNum[][] result = new complexNum[rows][cols];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {

                for (int k = 0; k < b.rows; k++) {
                    for (int l = 0; l < b.cols; l++) {

                        int row = i * b.rows + k;
                        int col = j * b.cols + l;

                        result[row][col] = a.data[i][j].multiply(b.data[k][l]);
                    }
                }
            }
        }

        return new Matrix(result);
    }

    // Tensor product for vectors
    public static Vector tensor(Vector a, Vector b) {

        complexNum[] result = new complexNum[a.size() * b.size()];

        int index = 0;

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {

                result[index] = a.data[i].multiply(b.data[j]);
                index++;
            }
        }

        return new Vector(result);
    }

    // Matrix addition
    public static Matrix add(Matrix a, Matrix b) {

        if (a.rows != b.rows || a.cols != b.cols) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[][] result = new complexNum[a.rows][a.cols];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {

                result[i][j] = a.data[i][j].add(b.data[i][j]);
            }
        }

        return new Matrix(result);
    }

    // Matrix subtraction
    public static Matrix subtract(Matrix a, Matrix b) {

        if (a.rows != b.rows || a.cols != b.cols) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[][] result = new complexNum[a.rows][a.cols];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {

                result[i][j] = a.data[i][j].subtract(b.data[i][j]);
            }
        }

        return new Matrix(result);
    }

    // Vector addition
    public static Vector add(Vector a, Vector b) {

        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[] result = new complexNum[a.size()];

        for (int i = 0; i < a.size(); i++) {
            result[i] = a.data[i].add(b.data[i]);
        }

        return new Vector(result);
    }

    // Vector subtraction
    public static Vector subtract(Vector a, Vector b) {

        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        complexNum[] result = new complexNum[a.size()];

        for (int i = 0; i < a.size(); i++) {
            result[i] = a.data[i].subtract(b.data[i]);
        }

        return new Vector(result);
    }

    // Outer product |a><b|
    public static Matrix outer(Vector a, Vector b) {

        complexNum[][] result = new complexNum[a.size()][b.size()];

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {

                result[i][j] = a.data[i].multiply(b.data[j].conjugate());
            }
        }

        return new Matrix(result);
    }

    // Expand single-qubit gate into full n-qubit system
    public static Matrix expandSingleQubitGate(
            Matrix gate,
            int targetQubit,
            int totalQubits) {

        Matrix result = null;

        for (int i = 0; i < totalQubits; i++) {

            Matrix current;

            if (i == targetQubit) {
                current = gate;
            } else {
                current = identity(2);
            }

            if (result == null) {
                result = current;
            } else {
                result = tensor(result, current);
            }
        }

        return result;
    }
}