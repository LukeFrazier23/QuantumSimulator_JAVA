



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

class LinearAlgebra {

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
}