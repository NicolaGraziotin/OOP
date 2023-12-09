
public class Calculator {

    int nOpDone;
    double lastRes;

    void build() {
        this.nOpDone = 0;
        this.lastRes = 0;
    }
    
    double add(double num1, double num2) {
        nOpDone++;
        return this.lastRes = num1 + num2;
    }

    double sub(double num1, double num2) {
        nOpDone++;
        return this.lastRes = num1 - num2;
    }

    double mul(double num1, double num2) {
        nOpDone++;
        return this.lastRes = num1 * num2;
    }

    double div(double num1, double num2) {
        nOpDone++;
        return this.lastRes = num1 / num2;
    }
}
