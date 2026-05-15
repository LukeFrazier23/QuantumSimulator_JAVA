


class Vector {
    double[] data;

    public Vector(int size) {
        data = new double[size];
    }

    public Vector(double[] data) {
        this.data = data;
    }

    public int size() {
        return data.length;
    }
}

class Matrix {
    double[][] data;
    int rows;
    int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }
}

class LinearAlgebra {

    // Matrix-vector multiplication
    public static Vector multiply(Matrix m, Vector v) {
        if (m.cols != v.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        double[] result = new double[m.rows];

        for (int i = 0; i < m.rows; i++) {
            double sum = 0;
            for (int j = 0; j < m.cols; j++) {
                sum += m.data[i][j] * v.data[j];
            }
            result[i] = sum;
        }

        return new Vector(result);
    }

    // Matrix-matrix multiplication (basic)
    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.cols != b.rows) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        double[][] result = new double[a.rows][b.cols];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                double sum = 0;
                for (int k = 0; k < a.cols; k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                result[i][j] = sum;
            }
        }

        return new Matrix(result);
    }
    // Dot product of two vectors
    public static double dot(Vector a, Vector b) {
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Dimension mismatch");
        }

        double sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.data[i] * b.data[i];
        }
        return sum;
    }

    // Cross product (only for 3D vectors)
    public static Vector cross(Vector a, Vector b) {
        if (a.size() != 3 || b.size() != 3) {
            throw new IllegalArgumentException("Cross product only defined for 3D vectors");
        }

        double[] result = new double[3];

        result[0] = a.data[1] * b.data[2] - a.data[2] * b.data[1];
        result[1] = a.data[2] * b.data[0] - a.data[0] * b.data[2];
        result[2] = a.data[0] * b.data[1] - a.data[1] * b.data[0];

        return new Vector(result);
    }

    // Scalar multiply (Vector)
    public static Vector scale(Vector v, double s) {
        double[] result = new double[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.data[i] * s;
        }
        return new Vector(result);
    }

    // Scalar multiply (Matrix)
    public static Matrix scale(Matrix m, double s) {
        double[][] result = new double[m.rows][m.cols];
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result[i][j] = m.data[i][j] * s;
            }
        }
        return new Matrix(result);
    }

    // Vector norm (magnitude)
    public static double norm(Vector v) {
        double sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.data[i] * v.data[i];
        }
        return Math.sqrt(sum);
    }

    // Vector tensor (Kronecker product)
    public static Vector tensor(Vector a, Vector b) {
        double[] result = new double[a.size() * b.size()];
        int idx = 0;

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                result[idx++] = a.data[i] * b.data[j];
            }
        }
        return new Vector(result);
    }

    // Matrix tensor (Kronecker product)
    public static Matrix tensor(Matrix a, Matrix b) {
        int r = a.rows * b.rows;
        int c = a.cols * b.cols;

        double[][] result = new double[r][c];

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                for (int bi = 0; bi < b.rows; bi++) {
                    for (int bj = 0; bj < b.cols; bj++) {
                        result[i * b.rows + bi][j * b.cols + bj] =
                            a.data[i][j] * b.data[bi][bj];
                    }
                }
            }
        }

        return new Matrix(result);
    }

    // Identity matrix
    public static Matrix identity(int n) {
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1.0;
        }

        return new Matrix(result);
    }

    // Transpose matrix
    public static Matrix transpose(Matrix m) {
        double[][] result = new double[m.cols][m.rows];

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result[j][i] = m.data[i][j];
            }
        }

        return new Matrix(result);
    }
}